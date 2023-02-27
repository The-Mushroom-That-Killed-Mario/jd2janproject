package com.noirix.repository;

import com.noirix.domain.Car;

import java.util.List;

public interface CarsRepository extends CRUDRepository<Long, Car>{


    List<Car> searchCarsInRegion(String region);

    List<Car> searchCarByUserName(String name);
}
