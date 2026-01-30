package com.teamstep.stepbackend.domain.student.application.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.teamstep.stepbackend.domain.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StudentSearchResponse {
    @JsonProperty("student_name")
    private String studentName;

    @JsonProperty("student_number")
    private String studentNumber;

    private String email;

    @JsonProperty("student_department")
    private String studentDepartment;

    private String field;

    // 엔티티를 dto로 변환하는 팩토리 메서드!
    public static StudentSearchResponse of(Student student) {
        return StudentSearchResponse.builder()
                .studentName(student.getStudentName())
                .studentNumber(String.valueOf(student.getStudentNumber()))
                .email(student.getEmail())
                .studentDepartment(student.getStudentDepartment())
                .field(student.getField())
                .build();
    }
}
