package com.noirix.repository;

import com.noirix.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class CarsRepositoryImplAdv implements CarsRepository{
    @Override
    public Optional<Car> findOne(Car car) {
        return Optional.empty();
    }

    @Override
    public Car findById(Long id) {
        return null;
    }

    @Override
    public List<Car> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Car create(Car object) {
        return null;
    }

    @Override
    public Car update(Car object) {
        return null;
    }

    @Override
    public Car delete(Long id) {
        return null;
    }

    @Override
    public List<Car> searchCarsInRegion(String region) {
        return null;
    }

    @Override
    public List<Car> searchCarByUserName(String name) {
        return null;
    }
}
