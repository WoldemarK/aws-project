package com.example.awsproject.service;

import com.example.awsproject.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IEventService {
    private final IEventRepository IEventRepository;
}
