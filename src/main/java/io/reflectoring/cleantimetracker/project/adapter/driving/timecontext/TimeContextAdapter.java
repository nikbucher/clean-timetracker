package io.reflectoring.cleantimetracker.project.adapter.driving.timecontext;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import io.reflectoring.cleantimetracker.project.domain.entity.Task;
import io.reflectoring.cleantimetracker.project.domain.entity.TaskId;
import io.reflectoring.cleantimetracker.project.domain.port.driven.persistence.QueryTasksPort;
import org.springframework.stereotype.Service;

@Service
public class TimeContextAdapter {

  private QueryTasksPort queryTasksPort;

  public TimeContextAdapter(QueryTasksPort queryTasksPort) {
    this.queryTasksPort = queryTasksPort;
  }

  public List<Task> listTasksByIds(List<Long> taskIds) {
    return queryTasksPort.listByIds(taskIds.stream()
            .map(TaskId::of)
            .collect(Collectors.toList()));
  }

  public Optional<Task> loadTask(Long taskId) {
    return queryTasksPort.findOne(TaskId.of(taskId));
  }

}
