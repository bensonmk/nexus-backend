package com.bmk.nexus.service;

import com.bmk.nexus.dto.request.JobApplicationRequestDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.exception.UserNotFoundException;
import com.bmk.nexus.mapper.JobApplicationMapper;
import com.bmk.nexus.repository.JobApplicationRepository;
import com.bmk.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobApplicationMapper jobApplicationMapper;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository, UserRepository userRepository, JobApplicationMapper jobApplicationMapper) {
        this.jobApplicationRepository = jobApplicationRepository;
        this.userRepository = userRepository;
        this.jobApplicationMapper = jobApplicationMapper;

    }

    public JobApplication createJobApplication(JobApplicationRequestDto requestDto) {

        Long userId = requestDto.getUserId();

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                    "User with ID %d not found".formatted(userId)
                ));

        JobApplication jobApplication = jobApplicationMapper.toEntity(requestDto, user);

        return jobApplicationRepository.save(jobApplication);
    }
}
