package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.changetaskstatus;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.reflectoring.cleantimetracker.MockitoExtension;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskStatus;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryTasksPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.UpdateTaskPort;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.TaskNotFoundException;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.TaskTestFactory;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@ExtendWith(MockitoExtension.class)
class ChangeTaskStatusUseCaseTest {

  @InjectMocks
  private ChangeTaskStatusUseCase usecase;

  @Mock
  private QueryTasksPort queryTasksPort;

  @Mock
  private UpdateTaskPort updateTaskPort;

  @Test
  void whenTaskIsFound_activatesTask() {
    Task task = TaskTestFactory.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.of(task));
    usecase.activateTask(task.getId());
    verify(updateTaskPort, times(1)).changeStatus(eq(task), eq(TaskStatus.ACTIVE));
  }

  @Test
  void whenTaskIsNotFound_activateThrowsException() {
    Task task = TaskTestFactory.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.empty());
    assertThatThrownBy(() -> usecase.activateTask(task.getId())).isInstanceOf(TaskNotFoundException.class);
  }

  @Test
  void whenTaskIsFound_deactivatesTask() {
    Task task = TaskTestFactory.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.of(task));
    usecase.deactivateTask(task.getId());
    verify(updateTaskPort, times(1)).changeStatus(eq(task), eq(TaskStatus.INACTIVE));
  }

  @Test
  void whenTaskIsNotFound_deactivateThrowsException() {
    Task task = TaskTestFactory.defaultTask().get();
    when(queryTasksPort.findOne(task.getId())).thenReturn(Optional.empty());
    assertThatThrownBy(() -> usecase.deactivateTask(task.getId())).isInstanceOf(TaskNotFoundException.class);
  }

}
