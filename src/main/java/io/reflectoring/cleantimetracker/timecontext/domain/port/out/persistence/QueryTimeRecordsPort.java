package io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import java.time.LocalDate;
import java.util.List;

public interface QueryTimeRecordsPort {

  List<TimeRecord> listTimeRecords(LocalDate from, LocalDate until);

}
