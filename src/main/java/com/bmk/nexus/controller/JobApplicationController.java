package com.bmk.nexus.controller;

import com.bmk.nexus.dto.request.CreateJobApplicationRequestDto;
import com.bmk.nexus.dto.request.UpdateJobApplicationRequestDto;
import com.bmk.nexus.dto.response.JobApplicationResponseDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.mapper.JobApplicationMapper;
import com.bmk.nexus.service.JobApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public JobApplicationResponseDto createJobApplication(@Valid @RequestBody CreateJobApplicationRequestDto requestDto) {

        JobApplication jobApplication = jobApplicationService.createJobApplication(requestDto);

        return jobApplicationMapper.toResponseDto(jobApplication);
    }

    @GetMapping("/{id}")
    public JobApplicationResponseDto getJobApplicationById(@PathVariable Long id) {

        JobApplication jobApplication = jobApplicationService.getJobApplicationById(id);

        return jobApplicationMapper.toResponseDto(jobApplication);
    }

    @GetMapping
    public List<JobApplicationResponseDto> getJobApplications() {

        List<JobApplication> jobApplications = jobApplicationService.getAllJobApplications();

        return jobApplicationMapper.toResponseDto(jobApplications);
    }

    @PatchMapping("/{id}")
    public JobApplicationResponseDto updateJobApplication(@PathVariable Long id, @Valid @RequestBody UpdateJobApplicationRequestDto requestDto) {

        JobApplication jobApplication = jobApplicationService.updateJobApplication(id, requestDto);

        return jobApplicationMapper.toResponseDto(jobApplication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Long id) {

        jobApplicationService.deleteJobApplication(id);

        return ResponseEntity.noContent().build();
    }
}