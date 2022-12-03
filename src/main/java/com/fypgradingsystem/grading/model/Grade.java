package com.fypgradingsystem.grading.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
  private String topicId;
  private String grade;
  private String studentId;
}
