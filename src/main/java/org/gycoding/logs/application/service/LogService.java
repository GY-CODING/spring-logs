package org.gycoding.logs.application.service;

import org.gycoding.logs.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private static final MongoTemplate mongoTemplate = null;
    private static final String collectionName = null;
    private static final String origin = null;

    @Autowired
    public LogService(
            MongoTemplate mongoTemplate,
            @Value("${gy.logs.collection.name}") String collectionName,
            @Value("${gy.logs.origin}") String origin
    ) {
        mongoTemplate = mongoTemplate;
        collectionName = collectionName;
    }

    public static void log(LogEntity logEntity) {
        logEntity.setOrigin(origin);

        System.out.println(logEntity.toString());
        mongoTemplate.save(logEntity.toJSON(), collectionName);
    }
}
