package com.bmk.nexus.service;

import com.bmk.nexus.dto.request.CreateJobApplicationRequestDto;
import com.bmk.nexus.dto.request.UpdateJobApplicationRequestDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.entity.User;
import com.bmk.nexus.exception.JobApplicationNotFoundException;
import com.bmk.nexus.exception.UserNotFoundException;
import com.bmk.nexus.mapper.JobApplicationMapper;
import com.bmk.nexus.repository.JobApplicationRepository;
import com.bmk.nexus.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    private User getUserOrThrow(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User with ID %d not found".formatted(id)
                ));
    }

    private JobApplication getJobApplicationOrThrow(Long id) {

        return jobApplicationRepository.findById(id)
                .orElseThrow(() -> new JobApplicationNotFoundException(
                        "Job application with ID %d not found".formatted(id)
                ));
    }

    public JobApplication createJobApplication(CreateJobApplicationRequestDto requestDto) {

        User user = getUserOrThrow(requestDto.getUserId());

        JobApplication jobApplication = jobApplicationMapper.toEntity(requestDto, user);

        return jobApplicationRepository.save(jobApplication);
    }

    public JobApplication getJobApplicationById(Long id) {

        return getJobApplicationOrThrow(id);
    }

    public List<JobApplication> getAllJobApplications() {

        return jobApplicationRepository.findAll();
    }

    public JobApplication updateJobApplication(Long id, UpdateJobApplicationRequestDto requestDto) {

        JobApplication jobApplication = getJobApplicationOrThrow(id);
        User user = getUserOrThrow(requestDto.getUserId());

        jobApplicationMapper.updateEntity(requestDto, user, jobApplication);

        return jobApplicationRepository.save(jobApplication);
    }

    public void deleteJobApplication(Long id) {
        JobApplication jobApplication = getJobApplicationOrThrow(id);

        jobApplicationRepository.delete(jobApplication);
    }
}
