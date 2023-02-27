package com.noirix.controller;

import com.noirix.domain.Car;
import com.noirix.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CarsController extends HttpServlet {
    //Помним что так вызывать контект совсем не хорошо, сделано исключительно для тестов
    private final CarService carService = new AnnotationConfigApplicationContext("com.noirix").getBean(CarService.class);
//    Изначальная реализация
//    private final CarService carService = new CarServiceImpl(new CarsRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req, resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cars");
        if (dispatcher != null) {
            System.out.println("Forward will be done!");
            System.out.println("We are processing user request");

            List<Car> cars = carService.findAll();

            String collect = cars.stream().map(Car::getName).collect(Collectors.joining(","));

            req.setAttribute("carName", collect);
            req.setAttribute("cars", cars);

            req.setAttribute("CarsByVasia",carService.searchCarByUserName("Вася"));
            req.setAttribute("CarsByMinsk",carService.searchCarsInRegion("Минск"));

            String name = req.getParameter("name");
            if (name!= null) {
                req.setAttribute("userName", name);
                req.setAttribute("CarsByName", carService.searchCarByUserName(name));
            }

            dispatcher.forward(req, resp);
        }
    }
}
