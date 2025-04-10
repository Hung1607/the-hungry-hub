package com.example.thehungryhubbackend.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class InMemoryUserStore {
    private final Map<String, UserDetails> users = new ConcurrentHashMap<>();

    public void saveUser(String username, UserDetails userDetails) {
        users.put(username, userDetails);
    }

    public UserDetails getUser(String username) {
        return users.get(username);
    }
}
