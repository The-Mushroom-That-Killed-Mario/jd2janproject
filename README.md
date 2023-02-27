# jd2janproject
2023.02.27 добавлено:
1. Сущность Car.java
2. CarsRepository и CarsRepositoryImpl для работы с бд
3. CarService и CarServiceImpl для работы со слоем репозитория car.
4. Сервлет cars.jsp для работы с сервисом CarService.(теперь есть возможность отправить запрос со страницы прямо в бд)
5. Зависимость lombok
6. Реализована DI CarRepository через конструктор в CarServiceImpl с помощью @autowired
7. В классе Main проверка работоспособности DI and IoC, чере sout().
