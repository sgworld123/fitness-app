package com.fitnessApp.activityservice.repository;

import com.fitnessApp.activityservice.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends MongoRepository<Activity , String> {
    List<Activity> findAllById(String id);
    List<Activity> findAllByUserId(String id);

}
