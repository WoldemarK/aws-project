package com.example.awsproject.service;

import com.example.awsproject.model.IUser;
import com.example.awsproject.model.IUserRole;
import com.example.awsproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Mono<IUser> registerUser(IUser user) {
        return userRepository.save(
                user.toBuilder()
                        .password(passwordEncoder.encode(user.getPassword()))
                        .role(IUserRole.USER)
                        .enabled(true)
                        .createAt(LocalDate.from(LocalDateTime.now()))
                        .updateAt(LocalDate.from(LocalDateTime.now()))
                        .build()
        ).doOnSuccess(u -> {
            log.info("IN registerUser - user: {} created", u);
        });
    }

    public Mono<IUser> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Mono<IUser> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}