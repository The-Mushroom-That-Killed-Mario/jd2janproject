package com.noirix.service;

import com.noirix.domain.Car;
import com.noirix.exception.EntityNotFoundException;
import com.noirix.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarsRepository carsRepository;
    @Autowired
    public CarServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public Optional<Car> findOne(Car car) {
        return carsRepository.findOne(car);
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
    public void delete(Long id) throws EntityNotFoundException {
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
