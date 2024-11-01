/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package CocinaCriolla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;
/**
 *
 * @author aldaiR
 */
public class ConexionSQL {
    
      public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL= "jdbc:sqlserver://ABRAHAM:1433;databaseName=SelfServiceDB;user=sa;password=12345678;";
        Connection con=DriverManager.getConnection(connectionURL);
        System.out.println("Conectado a SQL SERVER");
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery ("SELECT  * FROM Producto");
        
        while (rs.next()) { 
            int ID = rs.getInt(1);
            String Nombre = rs.getString(2);
            String Precio = rs.getString(4); // Cambiamos a getString para Precio
            System.out.println(ID + ": " + Nombre + " S/." + Precio);
        }
    }

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

