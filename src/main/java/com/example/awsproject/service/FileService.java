package com.example.awsproject.service;


import com.amazonaws.services.s3.model.PutObjectResult;
import com.example.awsproject.model.IFile;
import lombok.SneakyThrows;

import java.io.InputStream;

/**
 * Service interface for interface {@link FileService}.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
public interface FileService {
    @SneakyThrows
    void createBucket();
    @SneakyThrows
    void listBuckets();
    @SneakyThrows
    void deleteBucket(String bucketName);
    @SneakyThrows
    void deleteFile(String fileName);
    @SneakyThrows
    PutObjectResult upload(IFile file);
    @SneakyThrows
    InputStream downloadFile(IFile file);
}
