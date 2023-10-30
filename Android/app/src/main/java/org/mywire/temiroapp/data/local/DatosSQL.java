package org.mywire.temiroapp.data.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatosSQL {

    static SQLconexion conex;
    static public SQLiteDatabase dbliteRO;
    static public SQLiteDatabase dbliteRW;
    Context contexto;

    public DatosSQL(Context ctx) {
        contexto = ctx;
        if (conex==null) conex = new SQLconexion(contexto);
        if (dbliteRO==null) dbliteRO = conex.getReadableDatabase();
        if (dbliteRW==null) dbliteRW = conex.getWritableDatabase();
    }

    public Cursor queryToCursor(String consulta) {
        Cursor lista;
        if (conex==null) conex = new SQLconexion(contexto);
        if (dbliteRO==null) dbliteRO = conex.getReadableDatabase();
        lista = dbliteRO.rawQuery(consulta, null);
        return lista;
    }

}
