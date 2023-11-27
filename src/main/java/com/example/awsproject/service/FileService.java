package com.example.awsproject.service;


import com.example.awsproject.model.IFile;
import com.example.awsproject.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public Mono<IFile> create(IFile file) {
        if (file == null) {
            throw new RuntimeException("Ошибка");
        }
        return fileRepository.save(file);
    }

    public Flux<IFile> getAll() {
        return fileRepository.findAll();
    }
    public Mono<IFile>findById(Long id){
        return fileRepository.findById(id);
    }
}
