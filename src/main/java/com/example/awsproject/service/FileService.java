package com.example.awsproject.service;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.example.awsproject.model.IFile;
import com.example.awsproject.model.enums.StatusFile;
import com.example.awsproject.repository.FileRepository;
import com.example.awsproject.service.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    private final AmazonS3 s3Client;

    @Value("${spring.cloud.aws.credentials.bucketName}")
    private String bucketName;

    @SneakyThrows
    public void createBucket() {
        if (this.s3Client.doesBucketExistV2(bucketName)) {
            log.info("Bucket {} already exists, use a different name", bucketName);
            return;
        }

        this.s3Client.createBucket(bucketName);
    }

    @SneakyThrows
    public void listBuckets() {
        List<Bucket> buckets = this.s3Client.listBuckets();
        log.info("buckets: {}", buckets);
        System.out.println(buckets);
    }

    @SneakyThrows
    public void deleteBucket(String bucketName) {
        this.s3Client.deleteBucket(bucketName);
        log.info("delete Bucket {}", bucketName);

    }

    @SneakyThrows
    public void deleteFile(String fileName) {
        this.s3Client.deleteObject(this.bucketName, fileName);
    }


   @SneakyThrows
   public PutObjectResult upload(IFile file) {
       File someFile = new File(file.getLocation());

       file = IFile.builder()
               .fileName(someFile.getName())
               .location(s3Client.getBucketLocation(bucketName))
               .status(StatusFile.CREATED)
               .build();

       fileRepository.save(file);

       return this.s3Client.putObject(bucketName, file.getFileName(), someFile);

   }

    @SneakyThrows
    public InputStream downloadFile(IFile file) {
        if (this.s3Client.doesObjectExist(bucketName, file.getFileName())) {
            S3Object s3Object = this.s3Client.getObject(this.bucketName, file.getFileName());
            return s3Object.getObjectContent();
        }
        throw new NotFoundException("File does not exist ");
    }
}
