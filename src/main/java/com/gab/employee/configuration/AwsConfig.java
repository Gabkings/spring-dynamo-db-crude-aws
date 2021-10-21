package com.gab.employee.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aws", ignoreUnknownFields = false)
public class AwsConfig {
    /**
     * Aws access key ID
     */
    private String accessKey;


    /**
     * Aws secret access key
     */
    private String secretKey;

    /**
     * Aws region
     */
    private String region;

    /**
     * dynamodb endpoint
     */
    private String endpoint;
}
