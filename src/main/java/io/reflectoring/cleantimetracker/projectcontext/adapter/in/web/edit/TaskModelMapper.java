package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.edit;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
class TaskModelMapper {

  TaskModel toModel(Task domainObject) {
    return TaskModel.builder()
      .id(domainObject.getId().getValue())
      .invoiceable(domainObject.isInvoiceable())
      .name(domainObject.getName())
      .status(domainObject.getStatus())
      .build();
  }

  List<TaskModel> toModels(List<Task> domainObjects) {
    return domainObjects.stream()
      .map(this::toModel)
      .collect(Collectors.toList());
  }

}
