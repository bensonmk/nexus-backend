package com.bmk.nexus.dto.request;

import com.bmk.nexus.entity.ApplicationStatus;
import com.bmk.nexus.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class JobApplicationRequestDto {

    private String companyName;

    private String jobTitle;

    private String location;

    private ApplicationStatus status;

    private String notes;

    private String applicationUrl;

    private LocalDate appliedDate;

    private Long userId;
}
