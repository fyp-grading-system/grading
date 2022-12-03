package com.fypgradingsystem.grading.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.fypgradingsystem.grading.model.Topic;
import io.smallrye.mutiny.Uni;

public interface TopicCrudRepository extends ReactiveCrudRepository<Topic, String> {
  default Uni<Topic> persist(Topic topic) {
    return Uni.createFrom().future(save(topic).toFuture());
  }
}
