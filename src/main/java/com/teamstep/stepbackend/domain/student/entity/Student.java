package com.teamstep.stepbackend.domain.student.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentName; // 이름

    @Column(nullable = false, unique = true)
    private Integer studentNumber; // 학번

    @Column(nullable = false)
    private String email; // 메일주소

    @Column(nullable = false)
    private String studentDepartment; // 학과

    @Column(nullable = false)
    private String field; // 지원분야

    public void updateField(String field) {
        if (field == null || field.isBlank()) {
            throw new IllegalArgumentException("지원 분야는 비어있을 수 없습니다.");
        }
        this.field = field;
    }
}