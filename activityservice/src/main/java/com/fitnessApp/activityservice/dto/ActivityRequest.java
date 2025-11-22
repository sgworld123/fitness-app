package com.fitnessApp.activityservice.dto;

import com.fitnessApp.activityservice.model.ActivityType;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Map;
@Data
public class ActivityRequest {
    private String userId;
    private ActivityType activityType;
    private Integer duration;
    private LocalDateTime startTime;

    private Map<String,Object> additionalMetrics;
    private Integer caloriesBurned;
}
