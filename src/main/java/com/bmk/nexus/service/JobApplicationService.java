package com.bmk.nexus.service;

import com.bmk.nexus.dto.request.JobApplicationRequestDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.exception.UserNotFoundException;
import com.bmk.nexus.repository.JobApplicationRepository;
import com.bmk.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.userRepository = userRepository;

    }

    public JobApplication createJobApplication(JobApplicationRequestDto jobApplicationRequestDto) {
        JobApplication jobApplication = new JobApplication();

        jobApplication.setCompanyName(jobApplicationRequestDto.getCompanyName());
        jobApplication.setJobTitle(jobApplicationRequestDto.getJobTitle());
        jobApplication.setLocation(jobApplicationRequestDto.getLocation());
        jobApplication.setStatus(jobApplicationRequestDto.getStatus());
        jobApplication.setNotes(jobApplicationRequestDto.getNotes());
        jobApplication.setApplicationUrl(jobApplicationRequestDto.getApplicationUrl());
        jobApplication.setAppliedDate(jobApplicationRequestDto.getAppliedDate());

        Long userId = jobApplicationRequestDto.getUserId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                    "User with ID %d not found".formatted(userId)
                ));

        jobApplication.setUser(user);

        return jobApplicationRepository.save(jobApplication);
    }
}
