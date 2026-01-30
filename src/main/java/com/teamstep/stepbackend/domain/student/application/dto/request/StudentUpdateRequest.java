package com.teamstep.stepbackend.domain.student.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentUpdateRequest {

    @JsonProperty("applying_position")
    private String applyingPosition; // 지원 분야
}