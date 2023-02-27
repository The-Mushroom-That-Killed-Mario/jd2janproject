package com.noirix.service;

import com.noirix.domain.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {
    Car findOne(Long id);

    List<Car> findAll();

    Car create(Car object);

    Car update(Car object);

    void delete(Long id);

    List<Car> searchCarsInRegion(String region);

    List<Car> searchCarByUserName(String name);
}
