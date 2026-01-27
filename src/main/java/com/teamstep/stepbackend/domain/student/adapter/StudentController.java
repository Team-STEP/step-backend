package com.teamstep.stepbackend.domain.student.adapter;

import com.teamstep.stepbackend.domain.student.application.StudentSearchResponse;
import com.teamstep.stepbackend.domain.student.application.StudentSearchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentSearchUseCase studentSearchUseCase;

    @GetMapping("/{student-id}")
    public StudentSearchResponse getStudentDetail(@PathVariable("student-id") Long studentId) {
        return studentSearchUseCase.search(studentId);
    }
}
