/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package CocinaCriolla;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionSQL {
    private static final String URL = "jdbc:sqlserver://ABRAHAM:1433;databaseName=SelfServiceDB;user=sa;password=12345678;";

    public static void main(String[] args) {
        try (Connection con = connect()) {
            if (con != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                listarProductos(con);
            } else {
                System.err.println("La conexión a la base de datos falló.");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public static Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(URL);
    }

    public static int insertarPedido(int mesaId, int clienteId, int metodoPagoId, int empleadoId) {
    String query = "INSERT INTO Pedido (MesaId, ClienteId, MetodoPagoId, EmpleadoId, FechaPedido) VALUES (?, ?, ?, ?, GETDATE())";
    try (Connection con = connect();
         PreparedStatement stmt = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

        stmt.setObject(1, mesaId, java.sql.Types.INTEGER);
        stmt.setObject(2, clienteId, java.sql.Types.INTEGER);
        stmt.setObject(3, metodoPagoId, java.sql.Types.INTEGER);
        stmt.setObject(4, empleadoId, java.sql.Types.INTEGER);

        System.out.println("Ejecutando consulta: " + query);
        System.out.println("Valores: MesaId = " + mesaId + ", ClienteId = " + clienteId + ", MetodoPagoId = " + metodoPagoId + ", EmpleadoId = " + empleadoId);

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int generatedId = rs.getInt(1);
            System.out.println("Pedido insertado con ID: " + generatedId);
            return generatedId;
        }
    } catch (SQLException | ClassNotFoundException e) {
        System.err.println("Error al insertar Pedido: " + e.getMessage());
    }
    return -1;
}

   public static boolean insertarDetallePedido(int pedidoId, int productoId, int cantidad) {
    String query = "INSERT INTO DetallePedido (PedidoId, ProductoId, Cantidad) VALUES (?, ?, ?)";
    try (Connection con = connect();
         PreparedStatement stmt = con.prepareStatement(query)) {

        stmt.setInt(1, pedidoId);
        stmt.setInt(2, productoId);
        stmt.setInt(3, cantidad);

        System.out.println("Ejecutando consulta: " + query);
        System.out.println("Valores: PedidoId = " + pedidoId + ", ProductoId = " + productoId + ", Cantidad = " + cantidad);
        stmt.executeUpdate();

        System.out.println("Detalle insertado correctamente.");
        return true;
    } catch (SQLException | ClassNotFoundException e) {
        System.err.println("Error al insertar DetallePedido: " + e.getMessage());
        return false;
    }
}

    public static int obtenerIdProductoPorNombre(String nombreProducto) {
        String query = "SELECT idProducto FROM Producto WHERE Nombre = ?";
        try (Connection con = connect();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, nombreProducto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("idProducto");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Error al obtener ID de Producto: " + e.getMessage());
        }
        return -1; // Retorna -1 si no encuentra
    }

    private static void listarProductos(Connection con) {
        String query = "SELECT * FROM Producto";
        try (PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("Datos de la tabla Producto:");
            while (rs.next()) {
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("Nombre");
                double precio = rs.getDouble("Precio");
                System.out.println("ID: " + idProducto + ", Nombre: " + nombre + ", Precio: " + precio);
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
    }
}


//// Base de datos sqlserver:
//USE SelfServiceDB;
//
//
//-- Tabla Cliente
//CREATE TABLE Cliente (
//    idCliente INT PRIMARY KEY IDENTITY(1,1),
//    Nombres VARCHAR(100),
//    Apellidos VARCHAR(100),
//    Email VARCHAR(100) UNIQUE,
//    Telefono VARCHAR(20),
//    Direccion VARCHAR(255)
//);
//
//-- Tabla Mesa
//CREATE TABLE Mesa (
//    idMesa INT PRIMARY KEY IDENTITY(1,1),
//    Numero VARCHAR(10) NOT NULL
//);
//
//-- Tabla MetodoPago
//CREATE TABLE MetodoPago (
//    idMetodoPago INT PRIMARY KEY IDENTITY(1,1),
//    Tipo VARCHAR(45) NOT NULL,
//    Detalles VARCHAR(255)
//);
//
//-- Tabla Empleado
//CREATE TABLE Empleado (
//    idEmpleado INT PRIMARY KEY IDENTITY(1,1),
//    Nombre VARCHAR(100),
//    Apellido VARCHAR(100)
//);
//
//-- Tabla Producto
//CREATE TABLE Producto (
//    idProducto INT PRIMARY KEY IDENTITY(1,1),
//    Nombre VARCHAR(100) NOT NULL,
//    Descripcion VARCHAR(255),
//    Precio DECIMAL(10, 2) NOT NULL,
//    Categoria VARCHAR(45)
//);
//
//-- Tabla Pedido
//CREATE TABLE Pedido (
//    idPedido INT PRIMARY KEY IDENTITY(1,1),
//    MesaId INT,
//    ClienteId INT,
//    MetodoPagoId INT,
//    EmpleadoId INT,
//    FechaPedido DATETIME NOT NULL,
//    FOREIGN KEY (MesaId) REFERENCES Mesa(idMesa),
//    FOREIGN KEY (ClienteId) REFERENCES Cliente(idCliente),
//    FOREIGN KEY (MetodoPagoId) REFERENCES MetodoPago(idMetodoPago),
//    FOREIGN KEY (EmpleadoId) REFERENCES Empleado(idEmpleado)
//);
//
//-- Tabla DetallePedido
//CREATE TABLE DetallePedido (
//    idDetallePedido INT PRIMARY KEY IDENTITY(1,1),
//    ProductoId INT NOT NULL,
//    PedidoId INT NOT NULL,
//    Cantidad INT NOT NULL,
//    FOREIGN KEY (ProductoId) REFERENCES Producto(idProducto),
//    FOREIGN KEY (PedidoId) REFERENCES Pedido(idPedido)
//);

