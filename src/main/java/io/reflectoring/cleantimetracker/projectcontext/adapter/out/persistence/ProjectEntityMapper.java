package io.reflectoring.cleantimetracker.projectcontext.adapter.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
class ProjectEntityMapper {

  ProjectEntity toEntity(Project domainObject) {
    return ProjectEntity.builder()
      .id(domainObject.getId() != null ? domainObject.getId().getValue() : null)
      .name(domainObject.getName())
      .status(domainObject.getStatus())
      .build();
  }

  List<ProjectEntity> toEntities(List<Project> domainObjects) {
    return domainObjects.stream()
      .map(this::toEntity)
      .collect(Collectors.toList());
  }

  Project toDomainObject(ProjectEntity entity) {
    return Project.builder()
      .id(ProjectId.of(entity.getId()))
      .name(entity.getName())
      .status(entity.getStatus())
      .build();
  }

  List<Project> toDomainObjects(Iterable<ProjectEntity> entities) {
    List<Project> projects = new ArrayList<>();
    entities.forEach(entity -> projects.add(toDomainObject(entity)));
    return projects;
  }

}
