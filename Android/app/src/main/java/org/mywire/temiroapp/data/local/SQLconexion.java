package org.mywire.temiroapp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLconexion extends SQLiteOpenHelper {

    private static final String DATABASE_FILE = "temiroapp.db";
    private static final int DATABASE_VERSION = 2;

    public SQLconexion(Context context) {
        super(context, DATABASE_FILE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE UsuarioRegistrado ( "+
                    " idUsuario INTEGER NOT NULL, "+
                    " nombreUsuario TEXT NOT NULL, "+
                    " claveUsuario TEXT NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " apellido TEXT NOT NULL, "+
                    " email TEXT NOT NULL, "+
                    " PRIMARY KEY (idUsuario) "+
                    " ) ");

        db.execSQL("CREATE TABLE Test ( "+
                    " idTest INTEGER NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " cantPasos INTEGER NOT NULL, "+
                    " PRIMARY KEY (idTest) "+
                    " ) ");

        db.execSQL("CREATE TABLE HistoricoTest ( "+
                    " idTest INTEGER NOT NULL, "+
                    " idUsuario INTEGER NOT NULL, "+
                    " fhInicio TEXT NOT NULL, "+
                    " fhFin TEXT NOT NULL, "+
                    " resultado BOOLEAN NOT NULL, "+
                    " PRIMARY KEY (idTest, idUsuario), "+
                    " FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario), "+
                    " FOREIGN KEY (idTest) REFERENCES Test(idTest) "+
                    " ) ");

        db.execSQL("CREATE TABLE PasoTest ( "+
                    " idTest INTEGER NOT NULL, "+
                    " orden INTEGER NOT NULL, "+
                    " idTipo INTEGER NOT NULL, "+
                    " descripcion TEXT NOT NULL, "+
                    " porcentaje INTEGER NOT NULL, "+
                    " PRIMARY KEY (idTest, orden), "+
                    " FOREIGN KEY (idTest) REFERENCES Test(idTest), "+
                    " FOREIGN KEY (idTipo) REFERENCES TipoTest(idTipo) "+
                    " ) ");

        db.execSQL("CREATE TABLE TipoTest ( "+
                    " idTipo INTEGER NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " PRIMARY KEY (idTipo) "+
                    " ) ");

        db.execSQL("CREATE TABLE SesionUsuario ( "+
                    " idSesion INTEGER NOT NULL, "+
                    " idUsuario INTEGER NOT NULL, "+
                    " fhInicio TEXT NOT NULL, "+
                    " fhFin TEXT NOT NULL, "+
                    " PRIMARY KEY (idSesion), "+
                    " FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario) "+
                    " ) ");

        db.execSQL("CREATE TABLE HistorialActividad ( "+
                    " idUsuario INTEGER NOT NULL, "+
                    " fhConsulta TEXT NOT NULL, "+
                    " asunto TEXT NOT NULL, "+
                    " consulta TEXT NOT NULL, "+
                    " telefono TEXT NOT NULL, "+
                    " PRIMARY KEY (idUsuario, fhConsulta), "+
                    " FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario) "+
                    " ) ");

        db.execSQL("CREATE TABLE Productos ( "+
                    " idProducto INTEGER NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " descripcion TEXT NOT NULL, "+
                    " precio REAL NOT NULL, "+
                    " PRIMARY KEY (idProducto) "+
                    " ) ");

        db.execSQL("CREATE TABLE Servicios ( "+
                    " idServicio INTEGER NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " descripcion TEXT NOT NULL, "+
                    " consulta TEXT NOT NULL, "+
                    " PRIMARY KEY (idServicio) "+
                    " ) ");

        db.execSQL("CREATE TABLE Compras ( "+
                    " idCompra INTEGER NOT NULL, "+
                    " idUsuario INTEGER NOT NULL, "+
                    " fecha TEXT NOT NULL, "+
                    " descripcion TEXT NOT NULL, "+
                    " importe REAL NOT NULL, "+
                    " PRIMARY KEY (idCompra), "+
                    " FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario) "+
                    " ) ");

        db.execSQL("CREATE TABLE TipoEjercicio ( "+
                    " idTipo INTEGER NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " PRIMARY KEY (idTipo) "+
                    " ) ");

        db.execSQL("CREATE TABLE Ejercicio ( "+
                    " idEjercicio INTEGER NOT NULL, "+
                    " idTipo INTEGER NOT NULL, "+
                    " nombre TEXT NOT NULL, "+
                    " descripcion TEXT NOT NULL, "+
                    " instruccion TEXT NOT NULL, "+
                    " PRIMARY KEY (idEjercicio), "+
                    " FOREIGN KEY (idTipo) REFERENCES TipoEjercicio(idTipo) "+
                    " ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                // para pasar a la version 2
                db.execSQL("CREATE TABLE TurnoReservado ( "+
                        " idUsuario INTEGER NOT NULL, "+
                        " fechaTurno TEXT NOT NULL, "+
                        " horaTurno TEXT NOT NULL, "+
                        " tema TEXT NOT NULL, "+
                        " PRIMARY KEY (idUsuario, fechaTurno), "+
                        " FOREIGN KEY (idUsuario) REFERENCES UsuarioRegistrado(idUsuario) "+
                        " ) ");
            case 2:
                // para pasar a la version 3

            case 3:
                // para pasar a la version 4

        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) db.execSQL("PRAGMA foreign_keys=ON;");
    }

}
