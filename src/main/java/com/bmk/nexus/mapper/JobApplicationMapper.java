package com.bmk.nexus.mapper;

import com.bmk.nexus.dto.request.JobApplicationRequestDto;
import com.bmk.nexus.dto.response.JobApplicationResponseDto;
import com.bmk.nexus.entity.JobApplication;
import com.bmk.nexus.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface JobApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    JobApplication toEntity(JobApplicationRequestDto requestDto, User user);

    JobApplicationResponseDto toResponseDto(JobApplication jobApplication);
}
