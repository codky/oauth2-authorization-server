package com.example.oauth2authorizationserver.repository;

import com.example.oauth2authorizationserver.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJpaRepositoryTest {
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void insertNewUser() {
        userJpaRepository.save(User.builder()
                .uid("user")
                .password(passwordEncoder.encode("pass"))
                .name("msky0912.test")
                .email("msky0912@test.com")
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }
}
