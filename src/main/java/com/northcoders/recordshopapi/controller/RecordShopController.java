package com.northcoders.recordshopapi.controller;

import com.northcoders.recordshopapi.model.Record;
import com.northcoders.recordshopapi.service.RecordShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recordshop")
public class RecordShopController {

    @Autowired
    RecordShopService recordShopService;

    @GetMapping
    public ResponseEntity<List<Record>> getAllRecords() {
        List<Record> records = recordShopService.getAllRecords();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }
    
    @GetMapping({"/{recordId}"})
    public ResponseEntity<Optional<Record>> getRecordById(@PathVariable Long recordId) {
        Optional<Record> record = recordShopService.getRecordById(recordId);
        
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Record> addRecord(@RequestBody Record record) {
        Record newRecord = recordShopService.insertRecord(record);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("record", "/api/v1/recordshop/" + newRecord.getId().toString());
        return new ResponseEntity<>(newRecord, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping({"/{recordId}"})
    public ResponseEntity<Record> updateRecordById(@RequestBody Record record, @PathVariable Long recordId) {
        Record recordToUpdate = recordShopService.updateRecord(record, recordId);

        return new ResponseEntity<>(recordToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Boolean>> deleteRecordById(@PathVariable Long id) {

        return new ResponseEntity<>(recordShopService.deleteRecordById(id), HttpStatus.GONE);
    }
}
