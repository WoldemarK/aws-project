package com.example.awsproject.repository;

import com.example.awsproject.model.IUser;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * Service interface for class {@link IUser}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Repository
public interface UserRepository extends R2dbcRepository<IUser,Long> {
    Mono<IUser> findByUsername(String userName);
}
