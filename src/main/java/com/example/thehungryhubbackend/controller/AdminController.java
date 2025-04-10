package com.example.thehungryhubbackend.controller;

import com.example.thehungryhubbackend.config.CurrentUser;
import com.example.thehungryhubbackend.config.UserPrincipal;
import com.example.thehungryhubbackend.user.User;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AdminController {
    @GetMapping("/getAll")
    public ResponseEntity<String> getData() {
        try {
            return ResponseEntity.ok("data received");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<User> getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {

        User user = new User();
        user.setId(userPrincipal.getId());
        user.setUsername(userPrincipal.getUsername());
        user.setName(userPrincipal.getName());

        return ResponseEntity.ok(user);
    }
}
