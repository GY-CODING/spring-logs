package org.gycoding.logs.application.service;

import org.gycoding.logs.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private static MongoTemplate mongoTemplate;

    @Value("${gy.logs.collection.name}")
    private static String collectionName;

    @Value("${gy.logs.origin}")
    private static String origin;

    @Autowired
    public LogService(MongoTemplate mongoTemplate) {
        LogService.mongoTemplate = mongoTemplate;
    }

    public static void log(LogEntity logEntity) {
        logEntity.setOrigin(origin);

        System.out.println(logEntity.toString());
        mongoTemplate.save(logEntity.toJSON(), collectionName);
    }
}
