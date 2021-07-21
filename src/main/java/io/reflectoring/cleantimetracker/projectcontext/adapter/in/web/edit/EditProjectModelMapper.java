package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.edit;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
class EditProjectModelMapper {

  private final TaskModelMapper taskModelMapper;

  EditProjectModelMapper(TaskModelMapper taskModelMapper) {
    this.taskModelMapper = taskModelMapper;
  }

  EditProjectModel toModel(Project domainObject, List<Task> tasks) {
    return EditProjectModel.builder()
      .id(domainObject.getId().getValue())
      .name(domainObject.getName())
      .status(domainObject.getStatus())
      .tasks(taskModelMapper.toModels(tasks))
      .build();
  }

}
