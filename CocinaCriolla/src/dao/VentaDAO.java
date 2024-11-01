/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author USER
 */
import CocinaCriolla.ConexionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class VentaDAO {
    public String obtenerVentasRegistradas() {
        ConexionSQL conexion = new ConexionSQL();
        Connection con = conexion.getConnection();
        StringBuilder ventas = new StringBuilder();
        
        String query = "SELECT p.idPedido, c.Nombres AS Cliente, e.Nombre AS Empleado, m.Numero AS Mesa, mp.Tipo AS MetodoPago, p.Fecha_Pedido " +
                       "FROM Pedido p " +
                       "JOIN Cliente c ON p.Cliente_idCliente = c.idCliente " +
                       "JOIN Empleado e ON p.Empleado_idEmpleado = e.idEmpleado " +
                       "JOIN Mesa m ON p.Mesa_idMesa = m.idMesa " +
                       "JOIN MetodoPago mp ON p.MetodoPago_idMetodoPago = mp.idMetodoPago";
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int idPedido = rs.getInt("idPedido");
                String cliente = rs.getString("Cliente");
                String empleado = rs.getString("Empleado");
                String mesa = rs.getString("Mesa");
                String metodoPago = rs.getString("MetodoPago");
                String fechaPedido = rs.getString("Fecha_Pedido");
                
                ventas.append("ID Pedido: ").append(idPedido)
                      .append(", Cliente: ").append(cliente)
                      .append(", Empleado: ").append(empleado)
                      .append(", Mesa: ").append(mesa)
                      .append(", Metodo de Pago: ").append(metodoPago)
                      .append(", Fecha: ").append(fechaPedido)
                      .append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.closeConnection();
        }
        
        return ventas.toString();
    }
}
