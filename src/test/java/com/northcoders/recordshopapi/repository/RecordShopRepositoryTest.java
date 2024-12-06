package com.northcoders.recordshopapi.repository;


import com.northcoders.recordshopapi.service.RecordShopServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.northcoders.recordshopapi.model.Record;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DataJpaTest
class RecordShopRepositoryTest {

    @Mock
    private RecordShopRepository mockRecordShopRepository;

    @InjectMocks
    private RecordShopServiceImpl recordshopServiceImpl;

    @Test
    @DisplayName("getAllRecords returns with a list of records")
    public void testGetAllRecords() throws ParseException {
        // Arrange
        Record record = new Record(1L, "ABBA", "Abba", List.of(new String[]{"Waterloo", "Chiquitita", "Money, Money, Money", "Lay All Your Love", "Dancing Queen", "Gimme! Gimme! Gimme!"}), new SimpleDateFormat("yyyy-MM-dd").parse("1975-04-21"), true, new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-02").toInstant(), new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-02").toInstant());
        List<Record> mockRecords = new ArrayList<>();
        mockRecords.add(record);

        when(mockRecordShopRepository.findAll()).thenReturn(mockRecords);

        // Act
        List<Record> result = recordshopServiceImpl.getAllRecords();

        // Assert
        assertThat(result).hasSize(1);
    }

}