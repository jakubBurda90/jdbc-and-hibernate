package pl.sda.orange2.jdbc;

import pl.sda.orange2.jdbc.config.H2config;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {

        try{

           var h2connection = DriverManager.getConnection(H2config.DB_URL,H2config.USER,
                    H2config.PASSWORD);
            System.out.println("got connection " +(h2connection != null));
        }catch (SQLException exc){
            System.out.println("got exception " + exc);

        }
    }
}
