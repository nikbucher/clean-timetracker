package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.changetaskstatus;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryTasksPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.UpdateTaskPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.TaskNotFoundException;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChangeTaskStatusUseCase {

  private final QueryTasksPort queryTasksPort;

  private final UpdateTaskPort updateTaskPort;

  public ChangeTaskStatusUseCase(QueryTasksPort queryTasksPort, UpdateTaskPort updateTaskPort) {
    this.queryTasksPort = queryTasksPort;
    this.updateTaskPort = updateTaskPort;
  }

  public void deactivateTask(TaskId taskId) {
    Optional<Task> optionalTask = queryTasksPort.findOne(taskId);
    if (optionalTask.isPresent()) {
      updateTaskPort.changeStatus(optionalTask.get(), TaskStatus.INACTIVE);
    } else {
      throw new TaskNotFoundException(taskId);
    }
  }

  public void activateTask(TaskId taskId) {
    Optional<Task> optionalTask = queryTasksPort.findOne(taskId);
    if (optionalTask.isPresent()) {
      updateTaskPort.changeStatus(optionalTask.get(), TaskStatus.ACTIVE);
    } else {
      throw new TaskNotFoundException(taskId);
    }
  }

}
