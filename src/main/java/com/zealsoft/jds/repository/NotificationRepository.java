package com.zealsoft.jds.repository;

import com.zealsoft.jds.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "notification", path = "notification")
public interface NotificationRepository extends MongoRepository<Notification, String> {
}
