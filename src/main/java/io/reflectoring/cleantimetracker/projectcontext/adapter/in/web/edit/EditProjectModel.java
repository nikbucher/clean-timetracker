package io.reflectoring.cleantimetracker.projectcontext.adapter.in.web.edit;

import io.reflectoring.cleantimetracker.projectcontext.domain.entity.ProjectStatus;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class EditProjectModel {

  private Long id;

  private String name;

  private ProjectStatus status;

  private List<TaskModel> tasks;

  public boolean isActive() {
    return this.status == ProjectStatus.ACTIVE;
  }
}
