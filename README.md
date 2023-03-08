# jd2janproject
2023.02.27 добавлено:
1. Сущность Car.java
2. CarsRepository и CarsRepositoryImpl для работы с бд
3. CarService и CarServiceImpl для работы со слоем репозитория car.
4. Сервлет cars.jsp для работы с сервисом CarService.(теперь есть возможность отправить запрос со страницы прямо в бд)
5. Зависимость lombok
6. Реализована DI CarRepository через конструктор в CarServiceImpl с помощью @autowired
7. В классе Main проверка работоспособности DI and IoC, через sout().

2023.03.08
Внесены правки:
1. Создан и задействован EntityNotFoundException
2. Метод findById возвращает EntityNotFoundException, если выбранный ID отсутствует в базе
3. Метод findOne в CRUDRepository Теперь возвращает Optional
4. Метод delete в CRUDRepository возвращает объект или EntityNotFoundException если такой объект отсутствует в базе
