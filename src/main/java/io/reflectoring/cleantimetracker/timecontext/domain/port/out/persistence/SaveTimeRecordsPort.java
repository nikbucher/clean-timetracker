package io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import java.util.List;

public interface SaveTimeRecordsPort {

  void saveTimeRecords(List<TimeRecord> records);

}
