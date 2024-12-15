package com.northcoders.recordshopapi.service;

import com.northcoders.recordshopapi.model.Record;
import java.util.List;
import java.util.Optional;

public interface RecordShopService {

    List<Record> getAllRecords();
    Record insertRecord(Record record);
    Optional<Record> getRecordById(Long id);
    Record updateRecord(Record record, Long id);
}
