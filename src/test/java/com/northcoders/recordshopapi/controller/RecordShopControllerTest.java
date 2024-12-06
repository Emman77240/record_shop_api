package com.northcoders.recordshopapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.recordshopapi.service.RecordShopServiceImpl;
import com.northcoders.recordshopapi.model.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@AutoConfigureMockMvc
@SpringBootTest
class RecordShopControllerTest {

    @Mock
    private RecordShopServiceImpl mockRecordShopServiceImpl;

    @InjectMocks
    private RecordShopController recordShopController;

    @Autowired
    private MockMvc mockMvcController;
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        mockMvcController = MockMvcBuilders.standaloneSetup(recordShopController).build();
        mapper = new ObjectMapper();
    }


    @Test
    void getAllRecords() throws Exception {
        // Arrange
        List<Record> records = new ArrayList<>();
        records.add(new Record(1L, "ABBA", "Abba", List.of(new String[]{"Waterloo", "Chiquitita", "Money, Money, Money", "Dancing Queen"}), new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-02"), true, new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-02").toInstant(), new SimpleDateFormat("yyyy-MM-dd").parse("2024-12-02").toInstant()));

        // Act
        when(mockRecordShopServiceImpl.getAllRecords()).thenReturn(records);

        // Assert
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/recordshop"))
                .andExpect(MockMvcResultMatchers.status().isOk())   //verifies the http response
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1));
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].setupLine").value("Why did the developer leave their job?"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].punchLine").value("Because they didn't get arrays."))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].category").value("PROGRAMMING"));


    }
}