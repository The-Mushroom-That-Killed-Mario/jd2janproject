package com.noirix;

import com.noirix.repository.CarsRepository;
import com.noirix.repository.UserRepository;
import com.noirix.service.CarService;
import com.noirix.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringTest {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:application-context.xml");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.noirix");

        //Object bean = applicationContext.getBean();
//        UserRepository repository = applicationContext.getBean("userRepository", UserRepository.class);
        UserRepository userRepository = applicationContext.getBean("userRepositoryImpl", UserRepository.class);
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        System.out.println(userRepository.findAll());
        System.out.println(userService.findAll());

        System.out.println("======Тест контекста для Сars========");

        CarsRepository carsRepository = applicationContext.getBean(CarsRepository.class);
        CarService carService = applicationContext.getBean(CarService.class);
        System.out.println(carsRepository.findAll());
        System.out.println(carService.findAll());

    }
}