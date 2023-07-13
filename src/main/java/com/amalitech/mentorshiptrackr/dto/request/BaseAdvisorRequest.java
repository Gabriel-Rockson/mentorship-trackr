package com.amalitech.mentorshiptrackr.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseAdvisorRequest {
    @NotBlank(message = "This field is required.")
    private String username;

    @NotBlank(message = "This field is required.")
    private String email;

    @NotNull(message = "This field is required.")
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    // TODO: create validators for dateOfBirth field
    private LocalDate dateOfBirth;

    @NotNull(message = "This field is required.")
    private String countryName;

    @NotNull(message = "This field is required.")
    private String cityName;
}
