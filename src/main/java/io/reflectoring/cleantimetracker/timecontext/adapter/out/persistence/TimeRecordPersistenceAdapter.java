package io.reflectoring.cleantimetracker.timecontext.adapter.out.persistence;

import io.reflectoring.cleantimetracker.timecontext.domain.entity.TimeRecord;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence.QueryTimeRecordsPort;
import io.reflectoring.cleantimetracker.timecontext.domain.port.out.persistence.SaveTimeRecordsPort;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TimeRecordPersistenceAdapter implements QueryTimeRecordsPort, SaveTimeRecordsPort {

  private final TimeRecordMapper timeRecordMapper;

  private final TimeRecordRepository timeRecordRepository;

  public TimeRecordPersistenceAdapter(TimeRecordMapper timeRecordMapper, TimeRecordRepository timeRecordRepository) {
    this.timeRecordMapper = timeRecordMapper;
    this.timeRecordRepository = timeRecordRepository;
  }

  @Override
  public List<TimeRecord> listTimeRecords(LocalDate from, LocalDate until) {
    List<TimeRecordEntity> recordEntities = timeRecordRepository.findByDateBetween(from, until);
    return timeRecordMapper.toDomainObjects(recordEntities);
  }

  @Override
  public void saveTimeRecords(List<TimeRecord> records) {
    List<TimeRecordEntity> recordEntities = timeRecordMapper.toEntities(records);
    timeRecordRepository.saveAll(recordEntities);
  }
}
