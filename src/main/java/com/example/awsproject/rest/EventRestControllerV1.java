package com.example.awsproject.rest;

import com.example.awsproject.model.Event;
import com.example.awsproject.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Rest Controller for class {@link Event}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/events/")
public class EventRestControllerV1 {

    private final EventService eventService;

    @PostMapping
    public Mono<Event> create(@RequestBody Event event) {
        log.info("EventRestControllerV1, method create {} " , event);
        return this.eventService.create(event);
    }

    @GetMapping
    public Flux<Event> getAll() {
        log.info("EventRestControllerV1, method getAll {} ");
        return this.eventService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Event> getById(@PathVariable Long id) {
        log.info("EventRestControllerV1, method getById {} ", id);
        return this.eventService.getById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        log.info("EventRestControllerV1, method delete {} " , id);
        return this.eventService.deleteById(id);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable Long id, Event event) {
        log.info("EventRestControllerV1, method update {} " , id);
        return this.eventService.updateById(id, event);

    }
}
