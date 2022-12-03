package com.fypgradingsystem.grading.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class TeamGrade {
  @Id
  private String id;
  private String teamId;
  private String juryId;
  private List<Grade> grades;
}
