package com.noirix;

import com.noirix.domain.Car;
import com.noirix.domain.User;
import com.noirix.repository.CarsRepository;
import com.noirix.repository.CarsRepositoryImpl;
import com.noirix.repository.UserRepository;
import com.noirix.repository.UserRepositoryImpl;

import java.util.List;

public class Main {

    //Ctrl+Alt+O - import optimizing
    //Ctrl+Alt+L - formatting

    public static void main(String[] args) {

        UserRepository userRepository = new UserRepositoryImpl();

        List<User> all = userRepository.findAll();

        for (User user : all) {
            System.out.println(user);
        }

        CarsRepository carsRepository = new CarsRepositoryImpl();

        List<Car> allCar = carsRepository.findAll();

        for (Car car : allCar) {
            System.out.println(car);
        }


        System.out.println("Цена до изменения");
        System.out.println(carsRepository.findOne(4L));
        System.out.println();
        Car car = carsRepository.findOne(4L);
        car.setPrice(900000);
        System.out.println("Цена после изменения");
        System.out.println(carsRepository.update(car));
        System.out.println("==========================");


//        car.setId(1L);
//        car.setUserId(4L);
//        carsRepository.create(car);
//        System.out.println("CREATE::  ");


//        carsRepository.delete(1L);
//        System.out.println("DELETE::  ");


        for (Car car1 : carsRepository.findAll()) {
            System.out.println(car1);
        }

        System.out.println("====cars in region \"Минск\"======");
        for (Car car1 : carsRepository.searchCarsInRegion("Минск")) {
            System.out.println(car1);
        }

        System.out.println("====cars by UserName \"Вася\"======");
        for (Car car1 : carsRepository.searchCarByUserName("Вася")) {
            System.out.println(car1);
        }
    }
}