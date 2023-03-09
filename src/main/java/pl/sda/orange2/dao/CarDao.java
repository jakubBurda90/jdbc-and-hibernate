package pl.sda.orange2.dao;

import pl.sda.orange2.entity.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao implements DataAcess <Car, Long>{


    private final Connection dbConnection;

    public CarDao(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    @Override
    public void save(Car car) {

    }

    @Override
    public List<Car> findAll() {

        //var is the same as: List<Car> result = new ArrayList<Car>();

        var cars = new ArrayList<Car>();

        // TODO: VALIDATE QUERY
        String allCarsQuery = """
                SELECT ID, COLOUR, BRAND, MODEL
                FROM CARS
                """;
        /*
        CREATE TABLE CARS (
                ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                COLOUR VARCHAR(255),
                BRAND VARCHAR(255),
                MODEL VARCHAR(255)
        )

        INSERT INTO CARS (COLOUR, BRAND, MODEL) VALUES ('BLUE', 'Mazda', 'VI');
INSERT INTO CARS (COLOUR, BRAND, MODEL) VALUES ('RED', 'TOYOTA', 'COROLLA');
        */

        try {
            Statement queryStatement = dbConnection.createStatement();
            ResultSet queryResult = queryStatement.executeQuery(allCarsQuery);

            while (queryResult.next()){
                Long id = queryResult.getLong(1);
                String colour = queryResult.getString(2);
                String brand = queryResult.getString(3);
                String model = queryResult.getString(4);

                Car carFromDb = new Car (id, colour, brand, model);
                cars.add(carFromDb);
            }
        } catch (SQLException e) {
            System.out.println("Unexpected sql exeption occured");
            e.printStackTrace();
        }
        return cars;
    }

    @Override
    public Car findById(Long id) {
        Car result = null;

        String carByIdQuery = """
                SELECT ID, COLOUR, BRAND, MODEL
                FROM CARS
                WHERE ID = ?
                """;

        try {
            PreparedStatement queryStatement = dbConnection.prepareStatement(carByIdQuery);
            queryStatement.setLong(1,id);
            ResultSet queryResult = queryStatement.executeQuery();

            if(queryResult.next()){
                result = new Car(
                        queryResult.getLong("ID"),
                        queryResult.getString("COLOUR"),
                        queryResult.getString("BRAND"),
                        queryResult.getString("MODEL")
                );
            }


        } catch (SQLException e) {
            System.out.println("Unexpected sql exeption occured");
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void deleteById(Long id) {

    }
}
