package com.northcoders.recordshopapi.service;

import com.northcoders.recordshopapi.model.Record;
import java.util.List;

public interface RecordShopService {

    List<Record> getAllRecords();
    Record insertRecord(Record record);
}
