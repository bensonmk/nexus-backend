package com.bmk.nexus.controller;

import com.bmk.nexus.dto.request.JobApplicationRequestDto;
import com.bmk.nexus.dto.response.JobApplicationResponseDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping
    public JobApplicationResponseDto createJobApplication(@Valid @RequestBody JobApplicationRequestDto jobApplicationRequestDto) {

        JobApplication savedRecord = jobApplicationService.createJobApplication(jobApplicationRequestDto);

        return new JobApplicationResponseDto(
                savedRecord.getId(),
                savedRecord.getCompanyName(),
                savedRecord.getJobTitle(),
                savedRecord.getLocation(),
                savedRecord.getStatus(),
                savedRecord.getNotes(),
                savedRecord.getApplicationUrl(),
                savedRecord.getAppliedDate()
        );
    }
}