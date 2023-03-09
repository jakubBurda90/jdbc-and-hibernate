package pl.sda.orange2.jdbc;

import pl.sda.orange2.dao.CarDao;
import pl.sda.orange2.entity.Car;
import pl.sda.orange2.jdbc.config.H2config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarDaoExample {


    public static void main(String[] args) {
        System.out.println("Car dao example");
        System.out.println("Reading all cars from db");

        Connection h2connection = null;
        try {
            h2connection = DriverManager.getConnection(H2config.DB_URL,H2config.USER,
                    H2config.PASSWORD);

            CarDao carDao = new CarDao(h2connection);
            var allCarsFromDb = carDao.findAll();
            System.out.println("All cars from db " + allCarsFromDb);

            System.out.println("Finding car by id");
            System.out.println("First with existing id");
            Car existingCar = carDao.findById(1L);
            System.out.println("Existing car " +existingCar);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
