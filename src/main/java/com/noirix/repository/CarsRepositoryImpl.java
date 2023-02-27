package com.noirix.repository;

import com.noirix.domain.Car;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
@Primary
public class CarsRepositoryImpl implements CarsRepository {
    {
        registerDriver();
    }

    public static final String POSTRGES_DRIVER_NAME = "org.postgresql.Driver";
    public static final String DATABASE_URL = "jdbc:postgresql://localhost:";
    public static final int DATABASE_PORT = 5432;
    public static final String DATABASE_NAME = "/apptest";
    public static final String DATABASE_LOGIN = "postgres";
    public static final String DATABASE_PASSWORD = "root";

    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String BRAND = "brand";
    private static final String PRICE = "price";
    private static final String USER_ID = "user_id";
    private static final String CREATED = "created";
    private static final String CHANGED = "changed";
    private static final String IS_DELETED = "is_deleted";

    private void registerDriver() {
        try {
            Class.forName(POSTRGES_DRIVER_NAME);    //загрузка дравера в classLoader (вроде просто на всякий случай)
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver Cannot be loaded!");
            throw new RuntimeException("JDBC Driver Cannot be loaded!");
        }
    }

    private Connection getConnection() {
        String jdbcURL = StringUtils.join(DATABASE_URL, DATABASE_PORT, DATABASE_NAME);
        try {
            return DriverManager.getConnection(jdbcURL, DATABASE_LOGIN, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Car parseResultSet(ResultSet rs) {

        Car car;

        try {
            car = new Car();
            car.setId(rs.getLong(ID)); //1 or id
            car.setName(rs.getString(NAME));
            car.setBrand(rs.getString(BRAND));
            car.setPrice(rs.getInt(PRICE));
            car.setUserId(rs.getLong(USER_ID));
            car.setCreated(rs.getTimestamp(CREATED));
            car.setChanged(rs.getTimestamp(CHANGED));
            car.setDeleted(rs.getBoolean(IS_DELETED));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return car;
    }

    @Override
    public Car findOne(Long id) {
        final String findOneQuery = "select * from cars where id = ";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findOneQuery + id);
        ) {
            if (rs.next()) {
                return parseResultSet(rs);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return null;
    }


    @Override
    public List<Car> findAll() {
        final String findAllQuery = "select * from cars order by id desc";
        List<Car> result = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findAllQuery);
        ) {
            while (rs.next()) {
                result.add(parseResultSet(rs));
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }


    //        INSERT INTO public.cars (id, name, brand, price, user_id, created, changed, is_deleted)
//        VALUES (DEFAULT, null, null, null, null, null, null, DEFAULT);
    @Override
    public Car create(Car car) {
        final String createCarQuery = "INSERT INTO public.cars (id, name, brand, price, user_id, created, changed, is_deleted)";

        StringBuilder strBuild = new StringBuilder();
        strBuild.append("\n VALUES(");
        strBuild.append(car.getId()).append(", '");
        strBuild.append(car.getName()).append("', '");
        strBuild.append(car.getBrand()).append("', ");
        strBuild.append(car.getPrice()).append(",");
        strBuild.append(car.getUserId()).append(", '");
        strBuild.append(car.getCreated()).append("', '");
        strBuild.append(car.getChanged()).append("', ");
        strBuild.append(car.isDeleted()).append("");
        strBuild.append(")");

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.execute(createCarQuery + strBuild);
            return car;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }

    }

    @Override
    public Car update(Car car) {

        StringBuilder strBuild = new StringBuilder();
        strBuild.append("UPDATE public.cars SET ");
        strBuild.append(NAME).append(" = '").append(car.getName()).append("',");
        strBuild.append(BRAND).append(" = '").append(car.getBrand()).append("',");
        strBuild.append(PRICE).append(" = ").append(car.getPrice()).append(",");
        strBuild.append(USER_ID).append(" = ").append(car.getUserId()).append(",");
        strBuild.append(CREATED).append(" = '").append(car.getCreated()).append("',");
        strBuild.append(CHANGED).append(" = '").append(car.getChanged()).append("',");
        strBuild.append(IS_DELETED).append(" = ").append(car.isDeleted()).append(" ");
        strBuild.append("WHERE id = ").append(car.getId()).append(";");

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(strBuild.toString());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }

        return car;
    }


    //DELETE
//FROM public.cars
//WHERE id = ;
    @Override
    public void delete(Long id) {
        final String deleteCarQuery = "DELETE FROM public.cars WHERE id = ";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();) {
            statement.execute(deleteCarQuery + id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
    }

    //поиск машин в регионе
    @Override
    public List<Car> searchCarsInRegion(String region) {

        final String searchCarsInRegionQuery =
                "select cars.* " +
                "from cars inner join l_users_locations lul on cars.user_id = lul.user_id " +
                "inner join locations l on lul.location_id = l.id " +
                "where l.city = ";

        List<Car> result = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(searchCarsInRegionQuery + "\'" + region + "\'");
        ) {
            while (rs.next()) {
                result.add(parseResultSet(rs)) ;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");

        }
        return result;

    }

    //поиск машины по имени пользователя
    @Override
    public List<Car> searchCarByUserName(String name) {

        final String findOneQuery =
                "select cars.* " +
                "from cars join users u on cars.user_id = u.id " +
                "and u.name = ";

        List<Car> result = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(findOneQuery +"\'" + name + "\'");
        ) {
            while (rs.next()) {
                result.add(parseResultSet(rs)) ;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException("SQL Issues!");
        }
        return result;
    }
}