package io.reflectoring.cleantimetracker.timecontext.adapter.out.persistence;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecordId;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TimeRecordMapper {

  public TimeRecord toDomainObject(TimeRecordEntity entity) {
    return TimeRecord.builder()
      .status(entity.getStatus())
      .minutes(entity.getMinutes())
      .date(entity.getDate())
      .taskId(entity.getTaskId())
      .id(entity.getId() == null ? null : TimeRecordId.of(entity.getId()))
      .build();
  }

  public List<TimeRecord> toDomainObjects(List<TimeRecordEntity> entities) {
    List<TimeRecord> domainObjects = new ArrayList<>();
    for (TimeRecordEntity entity : entities) {
      domainObjects.add(toDomainObject(entity));
    }
    return domainObjects;
  }

  public TimeRecordEntity toEntity(TimeRecord domainObject) {
    return TimeRecordEntity.builder()
      .status(domainObject.getStatus())
      .minutes(domainObject.getMinutes())
      .date(domainObject.getDate())
      .taskId(domainObject.getTaskId())
      .id(domainObject.getId() == null ? null : domainObject.getId().getValue())
      .build();
  }

  public List<TimeRecordEntity> toEntities(List<TimeRecord> domainObjects) {
    List<TimeRecordEntity> entities = new ArrayList<>();
    for (TimeRecord domainObject : domainObjects) {
      entities.add(toEntity(domainObject));
    }
    return entities;
  }

}
