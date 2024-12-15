package com.northcoders.recordshopapi.service;

import com.northcoders.recordshopapi.exceptions.RecordNotFoundException;
import com.northcoders.recordshopapi.model.Record;
import com.northcoders.recordshopapi.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class RecordShopServiceImpl implements RecordShopService{

    @Autowired
    RecordShopRepository recordShopRepository;

    @Override
    public List<Record> getAllRecords() {
        List<Record> records = new ArrayList<>();
        recordShopRepository.findAll().forEach(records::add);

        return records;
    }

    @Override
    public Record insertRecord(Record record) {
        return recordShopRepository.save(record);
    }

    @Override
    public Optional<Record> getRecordById(Long id) {
        return recordShopRepository.findById(id);
    }

    @Override
    public Record updateRecord(Record record, Long id) {
        Record myRecord = recordShopRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record does not exist with id: " + id));
        myRecord.setName(record.getName());
        myRecord.setArtist(record.getArtist());
        myRecord.setSongs(record.getSongs());
        myRecord.setReleaseYear(record.getReleaseYear());
        myRecord.setInStock(record.isInStock());

        return recordShopRepository.save(myRecord);
    }

    @Override
    public HashMap<String, Boolean> deleteRecordById(Long id) {
        Record record = recordShopRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found for this id: " + id));

        recordShopRepository.delete(record);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
