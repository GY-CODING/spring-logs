package org.gycoding.logs.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@Profile("spring-logs")
@EnableMongoRepositories(
        basePackages = "org.gycoding.logs.application.service",
        mongoTemplateRef = "logsMongoTemplate"
)
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    private final String databaseName = "GYLogs";

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean(name = "logsMongoTemplate")
    public MongoTemplate logsMongoTemplate() {
        return new MongoTemplate(mongoClient(), databaseName);
    }
}