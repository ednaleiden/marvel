package org.example;

import java.io.IOException;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*CharacterController characterController = new CharacterController(new CharacterView());
        characterController.fetchCharacterInfo();
        characterController.insertCharacterInfoIntoDatabase(characterInfo);*/

        String url = "jdbc:mysql://localhost:3306/marvel";
        String usuario = "root";
        String contraseña = "";
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);

            System.out.println("Conexion establecido");
            stmt = conexion.createStatement();
            rs = stmt.executeQuery("SELECT * FROM comics");

            while (rs.next()) {
                String name = rs.getString("character_name");
                System.out.println(name + "\n");
            }

            conexion.close();
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el controlador JDBC.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión a la base de datos.");
            e.printStackTrace();
        }
    }

}