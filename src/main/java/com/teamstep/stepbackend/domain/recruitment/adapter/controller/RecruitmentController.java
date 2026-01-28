package com.teamstep.stepbackend.domain.recruitment.adapter.controller;

import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentCreateRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentUpdateRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentCreateResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.usecase.CreateRecruitmentUseCase;
import com.teamstep.stepbackend.domain.recruitment.application.usecase.DeleteRecruitmentUseCase;
import com.teamstep.stepbackend.domain.recruitment.application.usecase.UpdateRecruitmentUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recruitments")
public class RecruitmentController {

    private final CreateRecruitmentUseCase createRecruitmentUseCase;
    private final UpdateRecruitmentUseCase updateRecruitmentUseCase;
    private final DeleteRecruitmentUseCase deleteRecruitmentUseCase;

    // Write
    // Create
    @PostMapping
    public ResponseEntity<RecruitmentCreateResponseDto> createRecruitment(
            @Valid @RequestBody RecruitmentCreateRequestDto requestDto
    ){
        RecruitmentCreateResponseDto response = createRecruitmentUseCase.createRecruitment(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update
    @PutMapping("/{recruitmentId}")
    public ResponseEntity<Void> updateRecruitment(
            @Valid @PathVariable("recruitmentId") String id, @RequestBody RecruitmentUpdateRequestDto requestDto
    ){
        updateRecruitmentUseCase.updateRecruitment(id, requestDto);
        return ResponseEntity.ok().build();
    }
    // Delete
    @DeleteMapping("/{recruitmentId}")
    public ResponseEntity<Void> deleteRecruitment(
            @PathVariable("recruitmentId") String id
    ){
        deleteRecruitmentUseCase.deleteRecruitment(id);
        return ResponseEntity.noContent().build();
    }


    // Read
    // ListSearch
    // DetailSearch
}
