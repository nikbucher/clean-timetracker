package io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectId;
import java.util.List;
import java.util.Optional;

public interface QueryProjectsPort {

  List<Project> listProjects();

  Optional<Project> findOne(ProjectId projectId);

}
