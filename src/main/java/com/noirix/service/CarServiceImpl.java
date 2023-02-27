package com.noirix.service;

import com.noirix.domain.Car;
import com.noirix.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private final CarsRepository carsRepository;
    @Autowired
    public CarServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Car findOne(Long id) {
        return carsRepository.findOne(id);
    }

    @Override
    public List<Car> findAll() {
        return carsRepository.findAll();
    }

    @Override
    public Car create(Car car) {
        return carsRepository.create(car);
    }

    @Override
    public Car update(Car car) {
        return carsRepository.update(car);
    }


    @Override
    public void delete(Long id) {
        carsRepository.delete(id);
    }

    @Override
    public List<Car> searchCarsInRegion(String region) {
        return carsRepository.searchCarsInRegion(region);
    }

    @Override
    public List<Car> searchCarByUserName(String name) {
        return carsRepository.searchCarByUserName(name);
    }
}
