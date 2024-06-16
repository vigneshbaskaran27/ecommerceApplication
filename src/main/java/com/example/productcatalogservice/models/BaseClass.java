package com.example.productcatalogservice.models;

import com.example.productcatalogservice.enums.State;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@MappedSuperclass
public class BaseClass {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date UpdatedAt;
    private State state;
}
