package io.reflectoring.cleantimetracker.projectcontext.adapter.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Task;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.TaskId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
class TaskEntityMapper {

  private final EntityManager entityManager;

  private final ProjectEntityMapper projectEntityMapper;

  TaskEntityMapper(EntityManager entityManager, ProjectEntityMapper projectEntityMapper) {
    this.entityManager = entityManager;
    this.projectEntityMapper = projectEntityMapper;
  }

  TaskEntity toEntity(Task domainObject) {
    return TaskEntity.builder()
      .id(domainObject.getId() != null ? domainObject.getId().getValue() : null)
      .name(domainObject.getName())
      .project(projectReference(domainObject.getProject().getId()))
      .invoiceable(domainObject.isInvoiceable())
      .status(domainObject.getStatus())
      .build();
  }

  List<TaskEntity> toEntities(List<Task> domainObjects) {
    return domainObjects.stream()
      .map(this::toEntity)
      .collect(Collectors.toList());
  }

  Task toDomainObject(TaskEntity entity) {
    return Task.builder()
      .id(TaskId.of(entity.getId()))
      .name(entity.getName())
      .project(projectEntityMapper.toDomainObject(entity.getProject()))
      .invoiceable(entity.getInvoiceable())
      .status(entity.getStatus())
      .build();
  }

  List<Task> toDomainObjects(Iterable<TaskEntity> entities) {
    List<Task> projects = new ArrayList<>();
    entities.forEach(entity -> projects.add(toDomainObject(entity)));
    return projects;
  }

  private ProjectEntity projectReference(ProjectId projectId) {
    if (projectId == null || projectId.getValue() == null) {
      return null;
    }
    return entityManager.getReference(ProjectEntity.class, projectId.getValue());
  }

}
