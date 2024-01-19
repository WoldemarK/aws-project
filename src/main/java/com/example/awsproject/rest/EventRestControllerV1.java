package com.example.awsproject.rest;

import com.example.awsproject.model.Event;
import com.example.awsproject.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Rest Controller for interface {@link Event}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */

public interface EventRestControllerV1 {
    Mono<Event> create(Event event);

    Flux<Event> getAll();

    Mono<Event> getById(Long id);

    Mono<Void> delete(Long id);

    boolean update(Long id, Event event);
}
