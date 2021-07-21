package io.reflectoring.cleantimetracker.timecontext.adapter.out.projectcontext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import io.reflectoring.cleantimetracker.projectcontext.adapter.in.timecontext.TimeContextAdapter;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeTrackingTask;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.projectcontext.QueryTasksPort;
import org.springframework.stereotype.Service;

@Service
public class ProjectContextAdapter implements QueryTasksPort {

  private final TimeContextAdapter timeContextAdapter;

  private final TaskMapper taskMapper;

  public ProjectContextAdapter(TimeContextAdapter timeContextAdapter, TaskMapper taskMapper) {
    this.timeContextAdapter = timeContextAdapter;
    this.taskMapper = taskMapper;
  }

  @Override
  public List<TimeTrackingTask> listByIds(Set<Long> taskIds) {
    List<Task> tasks = timeContextAdapter.listTasksByIds(new ArrayList<>(taskIds));
    return taskMapper.toTimeTrackingTasks(tasks);
  }

  @Override
  public TimeTrackingTask loadTask(Long taskId) {
    Optional<Task> task = timeContextAdapter.loadTask(taskId);
    if (task.isPresent()) {
      return taskMapper.toTimeTrackingTask(task.get());
    } else {
      return null;
    }
  }

  @Override
  public List<TimeTrackingTask> listAllTasks() {
    return taskMapper.toTimeTrackingTasks(timeContextAdapter.listAll());
  }

}
