package com.example.awsproject.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.http.async.SdkAsyncHttpClient;
import software.amazon.awssdk.http.nio.netty.NettyNioAsyncHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3AsyncClientBuilder;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.utils.StringUtils;

import java.time.Duration;

/**
 * Configuration class for S3Config application.
 *
 * @author Kovtynov Vladimir
 * @version 1.0
 */
@Configuration
public class S3Config {

    @Value("${spring.cloud.aws.credentials.aws_access_key_id}")
    private String keyId;
    @Value("${spring.cloud.aws.credentials.aws_secret_access_key}")
    private String secretKey;
    @Value("${spring.cloud.aws.credentials.region}")
    private String region;
    @Value("${spring.cloud.aws.credentials.serviceEndpoint}")
    private String serviceEndpoint;

    @Bean
    public AmazonS3 amazonS3() {
        AWSCredentials credentials = new BasicAWSCredentials(keyId, secretKey);
        return AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(
                        new AmazonS3ClientBuilder.EndpointConfiguration(serviceEndpoint, region)).build();
    }

}