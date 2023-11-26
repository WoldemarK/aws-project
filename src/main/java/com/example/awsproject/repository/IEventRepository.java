package com.example.awsproject.repository;

import com.example.awsproject.model.IEvent;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventRepository extends R2dbcRepository<IEvent, Long> {
}
