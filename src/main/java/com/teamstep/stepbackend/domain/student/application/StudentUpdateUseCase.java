package com.teamstep.stepbackend.domain.student.application;

import com.teamstep.stepbackend.domain.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentUpdateUseCase {
    private final StudentRepository studentRepository;

    @Transactional()
    public void execute(Long studentId, StudentUpdateRequest studentUpdateRequest) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("해당 학생을 찾을 수 없음.");
        }

        Student student = studentOptional.get();

        try {
            student.updateField(studentUpdateRequest.getApplyingPosition());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
