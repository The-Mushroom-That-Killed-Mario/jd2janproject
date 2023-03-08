package com.noirix.service;

import com.noirix.domain.Car;
import com.noirix.exception.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Optional<Car> findOne(Car car);

    List<Car> findAll();

    Car create(Car object);

    Car update(Car object);

    void delete(Long id) throws EntityNotFoundException;

    List<Car> searchCarsInRegion(String region);

    List<Car> searchCarByUserName(String name);
}
