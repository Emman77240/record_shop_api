package com.northcoders.recordshopapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Record {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long id;

    @Column
    String name;

    @Column
    String artist;

    @Column
    ArrayList<String> songs;

    @Column
    Date releaseDate;

    @Column
    boolean inStock;

    @Column
    Instant createdDate;

    @Column
    Instant modifiedDate;



}
