package org.m2acsi.boundary;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PrincipalRestController {

    @GetMapping(value = "/user")
    public Principal principal(Principal principal) {
        return principal;
    }
}