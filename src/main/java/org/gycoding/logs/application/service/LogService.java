package org.gycoding.logs.application.service;

import jakarta.annotation.PostConstruct;
import org.gycoding.logs.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private static MongoTemplate mongoTemplate;
    private static String collectionName;
    private static String origin;

    @Value("${gy.logs.collection.name}")
    private String collectionNameProp;

    @Value("${gy.logs.origin}")
    private String originProp;

    @Autowired
    public LogService(MongoTemplate mongoTemplate) {
        LogService.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    private void init() {
        LogService.collectionName = this.collectionNameProp;
        LogService.origin = this.originProp;
    }

    public static void log(LogEntity logEntity) {
        logEntity.setOrigin(origin);
        System.out.println(logEntity.toString());
        mongoTemplate.save(logEntity.toJSON(), collectionName);
    }
}
