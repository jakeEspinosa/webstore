package com.jakeespinosa.fruitbackend.rest;

import com.jakeespinosa.fruitbackend.dao.CartRepository;
import com.jakeespinosa.fruitbackend.dto.CartDTO;
import com.jakeespinosa.fruitbackend.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartModificationController {

    @Autowired
    private CartRepository cartRepository;

    @PutMapping("/apples-increment") // refactor for global exception handling
    public @ResponseBody Cart updateCart(@RequestBody CartDTO cartDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = auth.getName();

        Cart cart = cartRepository.getReferenceById(currentUsername);

        switch (cartDTO.getItemId()) {
            case 1:
                cart.setApples(cart.getApples() + 1);
                break;

            case 2:
                cart.setBananas(cart.getBananas() + 1);
                break;

            case 3:
                cart.setWatermelons(cart.getWatermelons() + 1);
                break;
        }

        Cart dbCart = cartRepository.save(cart);


        return dbCart;
    }

}
