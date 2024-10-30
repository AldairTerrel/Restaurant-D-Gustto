-- Crear la base de datos 
CREATE DATABASE SelfServiceDB;
GO
USE SelfServiceDB;
GO

-- Tabla Cliente
CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY IDENTITY(1,1),
    Nombres VARCHAR(45),
    Apellidos VARCHAR(45),
    Email VARCHAR(45),
    Telefono VARCHAR(45),
    Direccion VARCHAR(45)
);

-- Tabla Mesa
CREATE TABLE Mesa (
    idMesa INT PRIMARY KEY IDENTITY(1,1),
    Numero VARCHAR(45)
);

-- Tabla MetodoPago
CREATE TABLE MetodoPago (
    idMetodoPago INT PRIMARY KEY IDENTITY(1,1),
    Tipo VARCHAR(45),
    Detalles VARCHAR(45)
);

-- Tabla Empleado
CREATE TABLE Empleado (
    idEmpleado INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(45),
    Apellido VARCHAR(45)
);

-- Tabla Producto
CREATE TABLE Producto (
    idProducto INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(45),
    Descripcion VARCHAR(45),
    Precio VARCHAR(45),
    Categoria VARCHAR(45)
);

-- Tabla Pedido
CREATE TABLE Pedido (
    idPedido INT PRIMARY KEY IDENTITY(1,1),
    Mesa_idMesa INT,
    Cliente_idCliente INT,
    MetodoPago_idMetodoPago INT,
    Empleado_idEmpleado INT,
    Fecha_Pedido VARCHAR(45),
    FOREIGN KEY (Mesa_idMesa) REFERENCES Mesa(idMesa),
    FOREIGN KEY (Cliente_idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (MetodoPago_idMetodoPago) REFERENCES MetodoPago(idMetodoPago),
    FOREIGN KEY (Empleado_idEmpleado) REFERENCES Empleado(idEmpleado)
);

-- Tabla DetallePedido
CREATE TABLE DetallePedido (
    idDetallePedido INT PRIMARY KEY IDENTITY(1,1),
    Producto_idProducto INT,
    Pedido_idPedido INT,
    Pedido_Mesa_idMesa INT,
    Pedido_Cliente_idCliente INT,
    Pedido_MetodoPago_idMetodoPago INT,
    Pedido_Empleado_idEmpleado INT,
    FOREIGN KEY (Producto_idProducto) REFERENCES Producto(idProducto),
    FOREIGN KEY (Pedido_idPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY (Pedido_Mesa_idMesa) REFERENCES Mesa(idMesa),
    FOREIGN KEY (Pedido_Cliente_idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (Pedido_MetodoPago_idMetodoPago) REFERENCES MetodoPago(idMetodoPago),
    FOREIGN KEY (Pedido_Empleado_idEmpleado) REFERENCES Empleado(idEmpleado)
);



----------------SELECTS-----------------------
-- Seleccionar todos los datos de la tabla Cliente
SELECT * FROM Cliente;

-- Seleccionar todos los datos de la tabla Mesa
SELECT * FROM Mesa;

-- Seleccionar todos los datos de la tabla MetodoPago
SELECT * FROM MetodoPago;

-- Seleccionar todos los datos de la tabla Empleado
SELECT * FROM Empleado;

-- Seleccionar todos los datos de la tabla Producto
SELECT * FROM Producto;

-- Seleccionar todos los datos de la tabla Pedido
SELECT * FROM Pedido;

-- Seleccionar todos los datos de la tabla DetallePedido
SELECT * FROM DetallePedido;
