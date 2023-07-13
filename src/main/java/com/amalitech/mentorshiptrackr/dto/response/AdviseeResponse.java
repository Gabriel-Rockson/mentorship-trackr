package com.amalitech.mentorshiptrackr.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class AdviseeResponse extends CommonAdvisorAdviseeResponse {
    private Map<String, Object> advisor;
}