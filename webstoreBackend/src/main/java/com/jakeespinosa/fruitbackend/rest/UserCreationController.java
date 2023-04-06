package com.jakeespinosa.fruitbackend.rest;

import com.jakeespinosa.fruitbackend.dao.CartRepository;
import com.jakeespinosa.fruitbackend.dao.RoleRepository;
import com.jakeespinosa.fruitbackend.dao.UserRepository;
import com.jakeespinosa.fruitbackend.entity.Cart;
import com.jakeespinosa.fruitbackend.entity.Role;
import com.jakeespinosa.fruitbackend.entity.User;
import com.jakeespinosa.fruitbackend.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class UserCreationController {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private CartRepository cartRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserCreationController(
            UserRepository userRepository,
            RoleRepository roleRepository,
            CartRepository cartRepository,
            PasswordEncoder passwordEncoder
    )
    {

        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.cartRepository = cartRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/users") // refactor for global exception handling
    public @ResponseBody User createUser(@RequestBody User user) throws UserAlreadyExistsException {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        user.setIsEnabled(true);

        User dbUser = userRepository.save(user);

        Role role = new Role(dbUser.getUsername(), "ROLE_USER");
        Role dbRole = roleRepository.save(role);

        Cart cart = new Cart(user.getUsername(), 0, 0, 0);
        Cart dbCart = cartRepository.save(cart);

        return dbUser;
    }
}
