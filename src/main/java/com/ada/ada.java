package com.ada;

import java.sql.*;

public class ada {
    private static final String URL = "jdbc:mysql://localhost:3306/birbz";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static void main(String[] args) {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("оу щищ");
        }
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.execute("INSERT INTO animal(anim_name, anim_desc) VALUES ('name', 'desc');");
            int res = statement.executeUpdate("UPDATE animal SET anim_name='New Name' WHERE id = 1");
            System.out.println(res);
            //statement.execute("INSERT INTO users(name, age, email) VALUES ('Дашка', 21, 'darkajopka@mail.ru');");
            ResultSet resultSet = statement.executeQuery("SELECT id, email, age FROM users where name = 'Дашка'");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int age = resultSet.getInt(3);
                String email = resultSet.getString(2);
                System.out.println("ID: " + id + ", EMAIL: " + email + ", AGE: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
