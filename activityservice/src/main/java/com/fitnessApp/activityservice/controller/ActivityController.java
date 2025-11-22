package com.fitnessApp.activityservice.controller;

import com.fitnessApp.activityservice.dto.ActivityRequest;
import com.fitnessApp.activityservice.dto.ActivityResponse;
import com.fitnessApp.activityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @PostMapping
    public ResponseEntity<ActivityResponse> registerActivity(@RequestBody ActivityRequest request)
    {
        return ResponseEntity.ok(activityService.registerActivity(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ActivityResponse> getActivityById(@PathVariable String id)
    {
        return ResponseEntity.ok(activityService.findActivityByIds(id));
    }

}
