package com.teamstep.stepbackend.domain.student.application;

import com.teamstep.stepbackend.domain.student.entity.Student;
import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentSearchUseCase {
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    public StudentSearchResponse search(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);

        if (studentOptional.isEmpty()) {
            throw new RuntimeException("해당 ID를 가진 학생이 존재하지 않습니다.");
        }

        return StudentSearchResponse.of(studentOptional.get());
    }
}
