package com.javaweb.QLktx.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentVisitorDTO {
    private String studentId;
    private String studentName;
    private String visitorName;
    private int visitCount;

    // getters and setters
}
