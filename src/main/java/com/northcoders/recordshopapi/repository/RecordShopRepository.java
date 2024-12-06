package com.northcoders.recordshopapi.repository;

import com.northcoders.recordshopapi.model.Record;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordShopRepository extends CrudRepository<Record, Long> {
}
