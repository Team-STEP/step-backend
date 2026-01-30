package com.teamstep.stepbackend.domain.recruitment.adapter.controller;

import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentCreateRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentDetailSearchRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentListSearchRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.request.RecruitmentUpdateRequestDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentCreateResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentDetailSearchResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.dto.response.RecruitmentListSearchResponseDto;
import com.teamstep.stepbackend.domain.recruitment.application.usecase.*;
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
    private final GetRecruitmentListUseCase getRecruitmentListUseCase;
    private final GetRecruitmentUseCase getRecruitmentUseCase;

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
            @PathVariable String recruitmentId, @Valid @RequestBody RecruitmentUpdateRequestDto requestDto
    ){
        updateRecruitmentUseCase.updateRecruitment(recruitmentId, requestDto);
        return ResponseEntity.ok().build();
    }

    // Delete
    @DeleteMapping("/{recruitmentId}")
    public ResponseEntity<Void> deleteRecruitment(
            @PathVariable String recruitmentId
    ){
        deleteRecruitmentUseCase.deleteRecruitment(recruitmentId);
        return ResponseEntity.noContent().build();
    }

    // ListSearch
    @GetMapping
    public ResponseEntity<RecruitmentListSearchResponseDto> getRecruitmentList(
            @ModelAttribute RecruitmentListSearchRequestDto requestDto
    ) {
        return ResponseEntity.ok(getRecruitmentListUseCase.getRecruitmentList(requestDto));
    }

    // DetailSearch
    @GetMapping("/{recruitmentId}")
    public ResponseEntity<RecruitmentDetailSearchResponseDto> getRecruitmentDetail(
            @PathVariable String recruitmentId
    ) {
        RecruitmentDetailSearchRequestDto requestDto = new RecruitmentDetailSearchRequestDto(recruitmentId);
        return ResponseEntity.ok(getRecruitmentUseCase.getRecruitment(requestDto));
    }
}
