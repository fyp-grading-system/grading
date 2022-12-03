package com.fypgradingsystem.grading.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fypgradingsystem.grading.model.Topic;
import io.smallrye.mutiny.Uni;

@Service
public class TopicRepository {
  
  @Autowired
  private TopicCrudRepository topicCrudRepository;

  public Uni<Topic> createTopic(Topic topic) {
    return topicCrudRepository.persist(topic);
  }

  public Uni<List<Topic>> getAllTopics() {
    return Uni.createFrom().future(topicCrudRepository.findAll().collectList().toFuture());
  }

  public Uni<Topic> getTopicById(String id) {
    return Uni.createFrom().future(topicCrudRepository.findById(id).toFuture());
  }

  public Uni<Topic> updateTopic(Topic topic) {
    return topicCrudRepository.persist(topic);
  }

  public Uni<Void> deleteTopic(String id) {
    return Uni.createFrom().future(topicCrudRepository.deleteById(id).toFuture());
  }
}
