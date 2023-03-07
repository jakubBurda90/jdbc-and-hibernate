package pl.sda.orange2.jdbc;

import pl.sda.orange2.jdbc.config.H2config;

import javax.xml.transform.Result;
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

        ResultSet queryResult=null;

        try{

           var h2connection = DriverManager.getConnection(H2config.DB_URL,H2config.USER,
                    H2config.PASSWORD);
            System.out.println("got connection " +(h2connection != null));

            Statement queryStatement = h2connection.createStatement();

            queryStatement = h2connection.createStatement();
            queryResult = queryStatement.executeQuery(query);
            while (queryResult.next()){
                System.out.println("ID: " +queryResult.getInt(1));
                System.out.println("NAME: " +queryResult.getString(1));


            }
        }catch (SQLException exc){
            System.out.println("got exception " + exc);
            exc.printStackTrace();

        }finally {
            System.out.println("Finally i know it");
            if (queryResult != null) {
                try {
                    queryResult.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        System.out.println("The end");
    }
}}
