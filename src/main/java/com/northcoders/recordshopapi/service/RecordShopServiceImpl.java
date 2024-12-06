package com.northcoders.recordshopapi.service;


import com.northcoders.recordshopapi.repository.RecordShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}