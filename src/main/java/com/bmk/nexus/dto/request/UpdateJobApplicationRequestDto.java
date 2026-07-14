package com.bmk.nexus.dto.request;

import com.bmk.nexus.entity.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UpdateJobApplicationRequestDto {

    private String companyName;

    private String jobTitle;

    private String location;

    private ApplicationStatus status;
    
    private String notes;

    private String applicationUrl;

    private LocalDate appliedDate;

    private Long userId;
}
