package com.noirix.repository;

import com.noirix.domain.Car;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarsRepositoryImplAdv implements CarsRepository{
    @Override
    public Car findOne(Long id) {
        return null;
    }

    @Override
    public List<Car> findAll() {
        return null;
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
    public void delete(Long id) {

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
