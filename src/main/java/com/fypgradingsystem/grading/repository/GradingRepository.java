package com.fypgradingsystem.grading.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fypgradingsystem.grading.messaging.QueueSender;
import com.fypgradingsystem.grading.model.TeamGrade;
import io.smallrye.mutiny.Uni;

@Service
public class GradingRepository {

  @Autowired
  GradingCrudRepository crudRepository;

  @Autowired
  QueueSender sender;

  public Uni<TeamGrade> createTeamGrade(TeamGrade grades) {
    return crudRepository.persist(grades);
  }

  public Uni<List<TeamGrade>> getAllTeamGrades() {
    return Uni.createFrom().future(crudRepository.findAll().collectList().toFuture());
  }

  public Uni<List<TeamGrade>> getSquadTeamGrades(String teamId) {
    return crudRepository.getByTeamId(teamId);
  }
}
