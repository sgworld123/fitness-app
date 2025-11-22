package com.fitnessApp.activityservice.service;

import com.fitnessApp.activityservice.dto.ActivityRequest;
import com.fitnessApp.activityservice.dto.ActivityResponse;
import com.fitnessApp.activityservice.model.Activity;
import com.fitnessApp.activityservice.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;
    public ActivityResponse registerActivity(ActivityRequest request) {
        Activity activity = Activity.builder()
                .activityType(request.getActivityType())
                .userId(request.getUserId())
                .activityType(request.getActivityType())
                .startTime(request.getStartTime())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);
        return mapToResponse(savedActivity);
    }
    private ActivityResponse mapToResponse(Activity savedActivity)
    {
        ActivityResponse activityResponse = ActivityResponse.builder()
                .id(savedActivity.getId())
                .userId(savedActivity.getUserId())
                .activityType(savedActivity.getActivityType())
                .startTime(savedActivity.getStartTime())
                .duration(savedActivity.getDuration())
                .caloriesBurned(savedActivity.getCaloriesBurned())
                .additionalMetrics(savedActivity.getAdditionalMetrics())
                .createdAt(savedActivity.getCreatedAt())
                .updatedAt(savedActivity.getUpdatedAt())
                .build();
        return activityResponse;
    }

    public ActivityResponse findActivityByIds(String id) {
        Optional<Activity> activity = activityRepository.findById(id);
        if(activity.isPresent())
        {
            return mapToResponse(activity.get());
        }
        else
        {
            throw new RuntimeException("Not found");
        }
    }
}
