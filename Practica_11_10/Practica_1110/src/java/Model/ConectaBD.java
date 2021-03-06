/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD {

    private Connection conexion = null;
    private String servidor = "localhost";
    private String database = "videojuegos";
    private String usuario = "root";
    private String password = "root";
    private String url = "";

    public ConectaBD() {
        try {
            // Establece la conexión con la base de datos
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://" + servidor + "/" + database;
            conexion = DriverManager.getConnection(url, usuario,
                    password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public Connection cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion = null;
        return conexion;
    }
}
