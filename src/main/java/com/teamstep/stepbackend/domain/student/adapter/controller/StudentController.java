package com.teamstep.stepbackend.domain.student.adapter.controller;

import com.teamstep.stepbackend.domain.student.application.dto.response.StudentSearchResponse;
import com.teamstep.stepbackend.domain.student.application.usecase.StudentSearchUseCase;
import com.teamstep.stepbackend.domain.student.application.dto.request.StudentUpdateRequest;
import com.teamstep.stepbackend.domain.student.application.usecase.StudentUpdateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentSearchUseCase studentSearchUseCase;
    private final StudentUpdateUseCase studentUpdateUseCase;

    @GetMapping("/{student-id}")
    public StudentSearchResponse getStudentDetail(@PathVariable("student-id") Long studentId) {
        return studentSearchUseCase.search(studentId);
    }

    @PatchMapping("/{student-id}")
    public void updateStudent(@PathVariable("student-id") Long studentId, @RequestBody StudentUpdateRequest StudentUpdateRequest) {
        studentUpdateUseCase.execute(studentId, StudentUpdateRequest);
    }
}
