package com.example.awsproject.service;


import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.example.awsproject.model.IFile;
import com.example.awsproject.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final AmazonS3 s3Client;
    @Value("${spring.cloud.aws.credentials.bucketName}")
    private String bucketName;
    @SneakyThrows
    public  void createBucket()  {
        if (s3Client.doesBucketExistV2(bucketName)) {
            log.info("Bucket {} already exists, use a different name", bucketName);
            return;
        }
        s3Client.createBucket(bucketName);
    }
    @SneakyThrows
    public void listBuckets(){
        List<Bucket>buckets = s3Client.listBuckets();
        log.info("buckets: {}", buckets);
        System.out.println(buckets);
    }
    @SneakyThrows
    public void uploadFile() {
        ClassLoader loader = FileService.class.getClassLoader();
        File file = new File(Objects.requireNonNull(loader.getResource("aws.txt")).getFile());
        s3Client.putObject(bucketName,"aws.txt",file);
    }
}