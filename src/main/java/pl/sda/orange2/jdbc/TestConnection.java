package pl.sda.orange2.jdbc;

import pl.sda.orange2.jdbc.config.H2config;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
    public static void main(String[] args) {

        String className = TestConnection.class.getName();
        System.out.println(className);


        String query = """
                SELECT ID, NAME
                FROM TEST
                """;


        try{

           var h2connection = DriverManager.getConnection(H2config.DB_URL,H2config.USER,
                    H2config.PASSWORD);
            System.out.println("got connection " +(h2connection != null));

            Statement queryStatement = h2connection.createStatement();
            ResultSet queryResult = queryStatement.executeQuery(query);
            while (queryResult.next()){
                System.out.println("ID: " +queryResult.getInt(1));
                System.out.println("NAME: " +queryResult.getString(1));


            }
        }catch (SQLException exc){
            System.out.println("got exception " + exc);

        }
    }
}
