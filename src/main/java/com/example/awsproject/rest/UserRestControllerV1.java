package com.example.awsproject.rest;

import com.example.awsproject.model.Event;
import com.example.awsproject.model.IUser;
import com.example.awsproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * Rest Controller for class {@link IUser}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/users/")
public class UserRestControllerV1 {

    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<IUser> getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);

    }

    @GetMapping
    public Flux<IUser> getAll() {
        return this.userService.getAll();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return this.userService.delete(id);
    }
}

