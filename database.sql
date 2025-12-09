CREATE DATABASE GestionEmail;

USE GestionEmail;

-- Tabla Empresa
CREATE TABLE dbo.empresa(
    idEmpresa INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR (250) NOT NULL,
    direccion VARCHAR (250),
    telefono VARCHAR(20),
    email VARCHAR (75) UNIQUE
);

-- Tabla TipoBandeja
CREATE TABLE dbo.TipoBandeja(
    idTipoBandeja INT PRIMARY KEY IDENTITY(1,1),
    nombreTipo VARCHAR(75) NOT NULL
);

-- Tabla EstadoEmail
CREATE TABLE dbo.EstadoEmail(
    idEstadoEmail INT PRIMARY KEY IDENTITY(1,1),
    nombreEstado VARCHAR (50) NOT NULL
);

-- Tabla Usuario
CREATE TABLE dbo.usuario(
    usuario VARCHAR(50) PRIMARY KEY,
    idEmpresa INT NULL,
    nombre VARCHAR (250) NOT NULL,
    apellido VARCHAR (250) NOT NULL,
    email VARCHAR (250) UNIQUE NOT NULL ,
    contrasena VARCHAR (255) NOT NULL,
    fechaRegistro DATE NOT NULL,
    estado VARCHAR(15) CHECK (estado IN ('Activo', 'Inactivo')) NOT NULL,
    FOREIGN KEY (idEmpresa) REFERENCES dbo.empresa(idEmpresa)
);

-- Tabla RecuperarContrasena
CREATE TABLE dbo.RecuperarContrasena(
    idRecuperacion INT PRIMARY KEY IDENTITY(1,1),
    usuario VARCHAR (50) NOT NULL,
    fechaSolicitud DATE NOT NULL,
    codigoRecuperacion VARCHAR (50) NOT NULL,
    estadoSolicitud VARCHAR(15) CHECK (estadoSolicitud IN ('Pendiente', 'Confirmada', 'Cancelada', 'Completada')) NOT NULL,
    FOREIGN KEY (usuario) REFERENCES dbo.usuario(usuario)
);

-- Tabla Bandeja (solo un remitente)
CREATE TABLE dbo.Bandeja(
    idBandeja INT PRIMARY KEY IDENTITY(1,1),
    usuarioRemitente VARCHAR(50) NOT NULL,
    idTipoBandeja INT,
    idEstadoEmail INT,
    asunto VARCHAR (500),
    mensaje VARCHAR (MAX),
    fechaEnvio DATETIME2(3) NOT NULL,
    adjunto VARCHAR (500),
    FOREIGN KEY (usuarioRemitente) REFERENCES dbo.usuario(usuario),
    FOREIGN KEY (idTipoBandeja) REFERENCES dbo.TipoBandeja(idTipoBandeja),
    FOREIGN KEY (idEstadoEmail) REFERENCES dbo.EstadoEmail(idEstadoEmail)
);

-- Tabla HistorialIngresos
CREATE TABLE dbo.HistorialIngresos(
    idHistorial INT PRIMARY KEY IDENTITY (1,1),
    usuario VARCHAR(50) NOT NULL,
    fechaIngreso DATETIME2(3) NOT NULL,
    fechaSalida DATETIME2(3) NULL,
    FOREIGN KEY (usuario) REFERENCES dbo.usuario(usuario)
);

-- Tabla DestinatarioEmail (múltiples destinatarios)
CREATE TABLE dbo.DestinatarioEmail(
    idDestinatario INT PRIMARY KEY IDENTITY(1,1),
    idBandeja INT NOT NULL,
    usuarioDestinatario VARCHAR(50) NOT NULL,
    tipoDestinatario VARCHAR(10) CHECK (tipoDestinatario IN ('Para', 'CC', 'CCO')) NOT NULL,
    FOREIGN KEY (idBandeja) REFERENCES dbo.Bandeja(idBandeja),
    FOREIGN KEY (usuarioDestinatario) REFERENCES dbo.usuario(usuario)
);