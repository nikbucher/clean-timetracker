package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.edit;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskId;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.addtask.AddTaskUseCase;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.changetaskstatus.ChangeTaskStatusUseCase;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.listtasks.ListTasksUseCase;
import io.reflectoring.cleantimetracker.projectcontext.domain.usecase.loadproject.LoadProjectUseCase;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class EditProjectController {

  private final ListTasksUseCase listTasksUseCase;

  private final LoadProjectUseCase loadProjectUseCase;

  private final EditProjectModelMapper editProjectModelMapper;

  private final AddTaskUseCase addTaskUseCase;

  private final ChangeTaskStatusUseCase changeTaskStatusUseCase;

  EditProjectController(ListTasksUseCase listTasksUseCase, LoadProjectUseCase loadProjectUseCase, EditProjectModelMapper editProjectModelMapper, AddTaskUseCase addTaskUseCase, ChangeTaskStatusUseCase changeTaskStatusUseCase) {
    this.listTasksUseCase = listTasksUseCase;
    this.loadProjectUseCase = loadProjectUseCase;
    this.editProjectModelMapper = editProjectModelMapper;
    this.addTaskUseCase = addTaskUseCase;
    this.changeTaskStatusUseCase = changeTaskStatusUseCase;
  }

  @GetMapping("/projects/{id}")
  String displayProjectForm(@PathVariable("id") Long projectId, Model model) {
    Project project = loadProjectUseCase.loadProject(ProjectId.of(projectId));
    List<Task> tasks = listTasksUseCase.listTasksForProject(ProjectId.of(projectId));
    EditProjectModel projectModel = editProjectModelMapper.toModel(project, tasks);
    model.addAttribute("project", projectModel);
    model.addAttribute("addTaskForm", new AddTaskForm());
    return "project/editProject.html";
  }

  @PostMapping("/projects/{id}/add-task")
  String addTask(@PathVariable("id") Long projectId,
                 @ModelAttribute("addTaskForm") AddTaskForm form) {
    addTaskUseCase.addTask(form.getName(), form.isInvoiceable(), ProjectId.of(projectId));
    return "redirect:/projects/{id}";
  }

  @PostMapping("/projects/{projectId}/tasks/{taskId}/activate")
  String activateTask(@PathVariable("taskId") Long taskId) {
    changeTaskStatusUseCase.activateTask(TaskId.of(taskId));
    return "redirect:/projects/{projectId}";
  }

  @PostMapping("/projects/{projectId}/tasks/{taskId}/deactivate")
  String deactivateTask(@PathVariable("taskId") Long taskId) {
    changeTaskStatusUseCase.deactivateTask(TaskId.of(taskId));
    return "redirect:/projects/{projectId}";
  }


}
