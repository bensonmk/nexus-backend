package com.bmk.nexus.mapper;

import com.bmk.nexus.dto.request.CreateJobApplicationRequestDto;
import com.bmk.nexus.dto.request.UpdateJobApplicationRequestDto;
import com.bmk.nexus.dto.response.JobApplicationResponseDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.entity.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    JobApplication toEntity(CreateJobApplicationRequestDto requestDto, User user);

    JobApplicationResponseDto toResponseDto(JobApplication jobApplication);

    List<JobApplicationResponseDto> toResponseDto(List<JobApplication> jobApplications);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(
            UpdateJobApplicationRequestDto requestDto,
            User user,
            @MappingTarget JobApplication jobApplication
    );
}
