package com.jakeespinosa.fruitbackend.rest;

import com.jakeespinosa.fruitbackend.dto.WhoAmIDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhoAmIController {

    @GetMapping("/who-am-i")
    public WhoAmIDTO getUsername(WhoAmIDTO whoAmIDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        whoAmIDTO.setUsername(auth.getName());

        return whoAmIDTO;
    }
}
