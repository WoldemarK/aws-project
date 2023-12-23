package com.example.awsproject.repository;

import com.example.awsproject.model.Event;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
/**
 * Service interface for class {@link  Event}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Repository
public interface EventRepository extends R2dbcRepository<Event, Long> {
}
