/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author user
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class DB {

    public ResultSet result;
    public Connection db;
    public int isSuccess;

    public DB(String query) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            db = DriverManager.getConnection(
                    "jdbc:mysql://localhost/u_todo", "root", "");
            Statement stmt = db.createStatement();
            if (query.contains("SELECT")) {
                result = stmt.executeQuery(query);
                isSuccess = 1;
            } else {
                isSuccess = stmt.executeUpdate(query);
            }

        } catch (ClassNotFoundException | SQLException e) {
            db = null;
            result = null;
            isSuccess = -1;
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println(" 🪲 -->" + e.getMessage());
        }
    }

    public void closeDB() {
        try {
            if (this.result == null) {
                throw new Exception("DB RESULT IS NULL.");
            }
            Boolean if_has_result = this.result.isClosed();
            if (if_has_result) {
                this.result.close();
            }
        } catch (Exception error) {
            System.out.println("\t🪲--->" + error.getMessage());
        }
    }
}
