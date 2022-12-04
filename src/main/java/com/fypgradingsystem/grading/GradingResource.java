package com.fypgradingsystem.grading;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fypgradingsystem.grading.model.Topic;
import com.fypgradingsystem.grading.model.TeamGrade;
import com.fypgradingsystem.grading.repository.TopicRepository;
import com.fypgradingsystem.grading.repository.GradingRepository;

import io.smallrye.mutiny.Uni;

@RestController
public class GradingResource {

  @Autowired
  TopicRepository topicRepository;

  @Autowired
  GradingRepository repository;

  @PostMapping("topics/create")
  public Uni<Topic> createTopic(@RequestBody Topic topic) {
    return topicRepository.createTopic(topic);
  }

  @GetMapping("topics")
  public Uni<List<Topic>> getAllTopics() {
    return topicRepository.getAllTopics();
  }

  @GetMapping("topics/{id}")
  public Uni<Topic> getTopicById(@RequestParam String id) {
    return topicRepository.getTopicById(id);
  }

  @PostMapping("topics/update")
  public Uni<Topic> updateTopic(@RequestBody Topic topic) {
    return topicRepository.updateTopic(topic);
  }

  @PostMapping("topics/delete/{id}")
  public Uni<Void> deleteTopic(@PathVariable("id") String id) {
    System.out.println(id);
    return topicRepository.deleteTopic(id);
  }

  @PostMapping("team-grades/create")
  public Uni<TeamGrade> createTeamGrade(@RequestBody TeamGrade grades) {
    return repository.createTeamGrade(grades);
  }

  @GetMapping("team-grades/{teamId}")
  public Uni<List<TeamGrade>> getAllTeamGrades(@PathVariable("teamId") String teamId) {
    return repository.getSquadTeamGrades(teamId);
  }
}
