/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspert13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    private static Connection conn;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        if (conn == null || conn.isClosed()) {
            try {
                // Load driver PostgreSQL
                Class.forName("org.postgresql.Driver");

                String url  = "jdbc:postgresql://localhost:5432/pbo_pert13";
                String user = "postgres";     
                String pass = "ABCDE12345";   

                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("Koneksi berhasil!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver PostgreSQL tidak ditemukan!");
                throw e;  // lempar exception agar bisa ditangani di pemanggil
            } catch (SQLException e) {
                System.err.println("Koneksi database gagal!");
                throw e;
            }
        }
        return conn;
    }
}
