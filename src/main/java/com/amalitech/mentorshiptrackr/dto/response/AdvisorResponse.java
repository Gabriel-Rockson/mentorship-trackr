package com.amalitech.mentorshiptrackr.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdvisorResponse extends CommonAdvisorAdviseeResponse {
}
