package com.fitnessApp.activityservice.dto;

import com.fitnessApp.activityservice.model.ActivityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Map;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityResponse {
    private String id;
    private String userId;
    private ActivityType activityType;
    private Integer duration;
    private LocalDateTime startTime;

    private Map<String,Object> additionalMetrics;
    private Integer caloriesBurned;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
