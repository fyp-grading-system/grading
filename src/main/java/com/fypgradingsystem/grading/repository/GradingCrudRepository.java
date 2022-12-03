package com.fypgradingsystem.grading.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.fypgradingsystem.grading.model.TeamGrade;
import io.smallrye.mutiny.Uni;

public interface GradingCrudRepository extends ReactiveCrudRepository<TeamGrade, String> {

  default Uni<TeamGrade> persist(TeamGrade grades) {
    return Uni.createFrom().future(save(grades).toFuture());
  }

  @Query("{ 'squadId': ?0 }")
  Uni<List<TeamGrade>> getByTeamId(String id);
}
