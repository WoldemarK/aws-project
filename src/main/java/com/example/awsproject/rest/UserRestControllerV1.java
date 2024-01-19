package com.example.awsproject.rest;

import com.example.awsproject.model.IUser;
import com.example.awsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Rest Controller for interface {@link IUser}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */

public interface UserRestControllerV1 {
    public Mono<IUser> getUserById(Long id);
    Flux<IUser> getAll();
    Mono<Void> deleteById(Long id);
}

