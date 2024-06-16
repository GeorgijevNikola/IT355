package com.studentsystem.studentsystem.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    @GetMapping
    public ResponseEntity<Map<String, String>> getUserInfo(Principal principal) {
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("username", principal.getName());
        userInfo.put("role", getRole(principal)); // Pretpostavimo da imate metodu koja vraća rolu korisnika
        return ResponseEntity.ok(userInfo);
    }

    private String getRole(Principal principal) {
        // Pretpostavimo da koristite UserDetailsService za dobijanje korisničkih detalja
        UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
        return userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst().orElse("USER"); // Vratite prvu rolu, ili 'USER' kao podrazumevanu
    }
}
