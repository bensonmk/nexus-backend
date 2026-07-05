package com.bmk.nexus.dto.response;

import com.bmk.nexus.entity.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class JobApplicationResponseDto {

    private Long id;

    private String companyName;

    private String jobTitle;

    private String location;

    private ApplicationStatus status;

    private String notes;

    private String applicationUrl;

    private LocalDate appliedDate;
}
