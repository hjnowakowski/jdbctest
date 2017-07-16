package info.henryk.springdataaccess.jdbc;

import org.mariadb.jdbc.MySQLDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDataSource {

    public static final String CLASSICMODELS = "classicmodels";
    public static final String SERVER_NAME = "192.168.1.13";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) {
        MySQLDataSource dataSource = new MySQLDataSource();
        dataSource.setDatabaseName(CLASSICMODELS);
        dataSource.setServerName(SERVER_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while(resultSet.next()){
                String productName = resultSet.getString("productName");
                double buyPrice = resultSet.getDouble("buyPrice");

                System.out.println(productName + ": " + buyPrice);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}