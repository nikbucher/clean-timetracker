package io.reflectoring.cleantimetracker.projectcontext.domain.usecase;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectStatus;
import java.util.Optional;

public class ProjectTestFactory {

  public static Optional<Project> defaultProject() {
    return Optional.of(Project.builder()
      .id(ProjectId.of(1L))
      .status(ProjectStatus.ACTIVE)
      .name("Project 1")
      .build());
  }

}
