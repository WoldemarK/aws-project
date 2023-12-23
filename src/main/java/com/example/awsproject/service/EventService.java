package com.example.awsproject.service;

import com.example.awsproject.model.Event;
import com.example.awsproject.repository.EventRepository;
import com.example.awsproject.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Mono<Event> create(Event event) {
        log.info("EventService, method create {} " + event);
        if (event == null) {
            throw new NotFoundException("Что то пошло не так");
        }
        return eventRepository.save(event);
    }

    public Flux<Event> getAll() {
        log.info("EventService, method getAll {} ");
        return eventRepository.findAll()
                .onErrorMap(throwable -> new FileNotFoundException("there is no data to display"));
    }

    public Mono<Event> getById(Long id) {
        log.info("EventService, method getById {} " + id);
        return eventRepository.findById(id)
                .onErrorMap(throwable -> new FileNotFoundException("no data available ID" + id));
    }

    public void delete(Long id) {
        log.info("EventService, method delete {} " + id);
        eventRepository.deleteById(id)
                .onErrorMap(throwable -> new FileNotFoundException("no data available ID" + id));
    }

    public boolean update(Long id, Event event) {
        log.info("EventService, method update {} " + id + " " + event);
        if (id == 0 && event == null) {
            throw new NotFoundException("ID == 0 and event==null check the correctness of the filling");
        }
        event = eventRepository
                .findById(id)
                .block();
        eventRepository.save(event);
        return true;
    }
}
