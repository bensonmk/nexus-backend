package com.bmk.nexus.controller;

import com.bmk.nexus.dto.request.JobApplicationRequestDto;
import com.bmk.nexus.dto.response.JobApplicationResponseDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.mapper.JobApplicationMapper;
import com.bmk.nexus.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-applications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;
    private final JobApplicationMapper jobApplicationMapper;

    public JobApplicationController(JobApplicationService jobApplicationService, JobApplicationMapper jobApplicationMapper) {
        this.jobApplicationService = jobApplicationService;
        this.jobApplicationMapper = jobApplicationMapper;
    }

    @PostMapping
    public JobApplicationResponseDto createJobApplication(@Valid @RequestBody JobApplicationRequestDto requestDto) {

        JobApplication jobApplication = jobApplicationService.createJobApplication(requestDto);

        return jobApplicationMapper.toResponseDto(jobApplication);
    }
}