package com.noirix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Car {
    private Long id;
    private String name;
    private String brand;
    private Long userId;
    private int price;
    private Timestamp created;
    private Timestamp changed;
    private boolean isDeleted;
}
