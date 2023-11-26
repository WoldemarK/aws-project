package com.example.awsproject.service;

import com.example.awsproject.repository.IFileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IFileService {
    private final IFileRepository fileRepository;
}
