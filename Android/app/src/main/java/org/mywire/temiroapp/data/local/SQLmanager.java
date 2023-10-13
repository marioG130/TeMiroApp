package org.mywire.temiroapp.data.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLmanager {

    Context contexto;
    private SQLconexion conex;
    private SQLiteDatabase dblite;

    public SQLmanager(Context ctx) {
        contexto = ctx;
    }

    public void crearDatabase() {
        if (conex==null) conex = new SQLconexion(contexto);
        dblite = conex.getReadableDatabase();
        dblite.close();
    }

    public void cargarDatosEpica6() {
        if (conex==null) conex = new SQLconexion(contexto);
        dblite = conex.getWritableDatabase();
        try {
            dblite.execSQL("insert into TipoTest values (0,'No definido')");
            dblite.execSQL("insert into TipoTest values (1,'Imagen puntos')");
            dblite.execSQL("insert into Test values (1,'Daltonismo Básico',3)");
            dblite.execSQL("insert into Test values (2,'Daltonismo Avanzado',6)");
            dblite.execSQL("insert into PasoTest values (1,1,1,'Primer imagen',30)");
            dblite.execSQL("insert into PasoTest values (1,2,1,'Segunda imagen',60)");
            dblite.execSQL("insert into PasoTest values (1,3,1,'Tercer imagen',90)");
        } catch (Exception e) {
            Log.d("SQL","Error al insertar datos Epica6");
        }
        dblite.close();
    }

    public void cerrar() {
        dblite.close();
    }

}
