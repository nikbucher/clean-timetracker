package io.reflectoring.cleantimetracker.projectcontext.domain.usecase.listprojects;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.Project;
import io.reflectoring.cleantimetracker.projectcontext.domain.port.out.persistence.QueryProjectsPort;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListProjectsUseCase {

  private final QueryProjectsPort queryPort;

  public ListProjectsUseCase(QueryProjectsPort queryPort) {
    this.queryPort = queryPort;
  }

  public List<Project> listProjects() {
    return queryPort.listProjects();
  }

}
