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

import modelo.Empleado;
import CocinaCriolla.ConexionSQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class EmpleadoDAO {
    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT * FROM Empleado";
        
        try (Connection con = ConexionSQL.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                    rs.getInt("idEmpleado"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getInt("HorasTrabajadas"),
                    rs.getString("Asistencia"),
                    rs.getString("Turno")
                );
                empleados.add(empleado);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener empleados: " + e.getMessage());
            e.printStackTrace();
        }
        
        return empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO Empleado (Nombre, Apellido, HorasTrabajadas, Asistencia, Turno) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionSQL.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getHorasTrabajadas());
            ps.setString(4, empleado.getAsistencia());
            ps.setString(5, empleado.getTurno());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al agregar empleado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado(int id) {
        String sql = "DELETE FROM Empleado WHERE idEmpleado = ?";
        
        try (Connection con = ConexionSQL.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void actualizarEmpleado(Empleado empleado) {
        String sql = "UPDATE Empleado SET Nombre = ?, Apellido = ?, HorasTrabajadas = ?, Asistencia = ?, Turno = ? WHERE idEmpleado = ?";
        
        try (Connection con = ConexionSQL.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getHorasTrabajadas());
            ps.setString(4, empleado.getAsistencia());
            ps.setString(5, empleado.getTurno());
            ps.setInt(6, empleado.getId());
            
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}