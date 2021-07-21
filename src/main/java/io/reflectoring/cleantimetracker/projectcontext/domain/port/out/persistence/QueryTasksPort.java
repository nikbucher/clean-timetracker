package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskId;
import java.util.List;
import java.util.Optional;

public interface QueryTasksPort {

  List<Task> listTasksForProject(ProjectId projectId);

  Optional<Task> findOne(TaskId taskId);

  List<Task> listByIds(List<TaskId> taskIds);

  List<Task> listAllTasks();
}
