PRAGMA foreign_keys = OFF;
DROP TABLE IF EXISTS UsuarioRegistrado;
DROP TABLE IF EXISTS Test;
DROP TABLE IF EXISTS HistoricoTest;
DROP TABLE IF EXISTS PasoTest;
DROP TABLE IF EXISTS TipoTest;
DROP TABLE IF EXISTS SesionUsuario;
DROP TABLE IF EXISTS HistorialActividad;
DROP TABLE IF EXISTS Productos;
DROP TABLE IF EXISTS Servicios;
DROP TABLE IF EXISTS Compras;
DROP TABLE IF EXISTS TipoEjercicio;
DROP TABLE IF EXISTS Ejercicio;
PRAGMA foreign_keys = ON;

CREATE TABLE UsuarioRegistrado (
    idUsuario INTEGER NOT NULL,
    nombreUsuario TEXT NOT NULL,
    claveUsuario TEXT NOT NULL,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    email TEXT NOT NULL,
    PRIMARY KEY (idUsuario)
);

CREATE TABLE Test (
    idTest INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    cantPasos INTEGER NOT NULL,
    PRIMARY KEY (idTest)
);

CREATE TABLE HistoricoTest (
    idTest INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    fhInicio TEXT NOT NULL,
    fhFin TEXT NOT NULL,
    resultado BOOLEAN NOT NULL,
    PRIMARY KEY (idTest, idUsuario),
    FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario),
    FOREIGN KEY (idTest) REFERENCES Test(idTest)    
);

CREATE TABLE PasoTest (
    idTest INTEGER NOT NULL,
    orden INTEGER NOT NULL,
    idTipo INTEGER NOT NULL,
    descripcion TEXT NOT NULL,
    porcentaje INTEGER NOT NULL,
    PRIMARY KEY (idTest, orden),
    FOREIGN KEY (idTest) REFERENCES Test(idTest),
    FOREIGN KEY (idTipo) REFERENCES TipoTest(idTipo)
);

CREATE TABLE TipoTest (
    idTipo INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    PRIMARY KEY (idTipo)
);

CREATE TABLE SesionUsuario (
    idSesion INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    fhInicio TEXT NOT NULL,
    fhFin TEXT NOT NULL,
    PRIMARY KEY (idSesion),
    FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario)
);

CREATE TABLE HistorialActividad (
    idUsuario INTEGER NOT NULL,
    fhConsulta TEXT NOT NULL,
    asunto TEXT NOT NULL,
    consulta TEXT NOT NULL,
    telefono TEXT NOT NULL,
    PRIMARY KEY (idUsuario, fhConsulta),
    FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario)
);

CREATE TABLE Productos (
    idProducto INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    descripcion TEXT NOT NULL,
    precio REAL NOT NULL,
    PRIMARY KEY (idProducto)
);

CREATE TABLE Servicios (
    idServicio INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    descripcion TEXT NOT NULL,
    consulta TEXT NOT NULL,
    PRIMARY KEY (idServicio)
);

CREATE TABLE Compras (
    idCompra INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    fecha TEXT NOT NULL,
    descripcion TEXT NOT NULL,
    importe REAL NOT NULL,
    PRIMARY KEY (idCompra),
    FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario)
);

CREATE TABLE TipoEjercicio (
    idTipo INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    PRIMARY KEY (idTipo)
);

CREATE TABLE Ejercicio (
    idEjercicio INTEGER NOT NULL,
    idTipo INTEGER NOT NULL,
    nombre TEXT NOT NULL,
    descripcion TEXT NOT NULL,
    instruccion TEXT NOT NULL,
    PRIMARY KEY (idEjercicio),
    FOREIGN KEY (idTipo) REFERENCES TipoEjercicio(idTipo)
);
