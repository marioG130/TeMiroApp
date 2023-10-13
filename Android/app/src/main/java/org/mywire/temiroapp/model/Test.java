package org.mywire.temiroapp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.mywire.temiroapp.data.local.DatosSQL;

public class Test extends DatosSQL {

    private int idTest;
    private String nombre;
    private int cantidadPasos;

    public Test(Context ctx) {
        super(ctx);
        limpiarCampos();
    }

    public void limpiarCampos() {
        idTest = 0;
        nombre = "";
        cantidadPasos = 0;
    }

    public int getIdTest() {
        return idTest;
    }

    public void setIdTest(int idTest) {
        this.idTest = idTest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadPasos() {
        return cantidadPasos;
    }

    public void setCantidadPasos(int cantidadPasos) {
        this.cantidadPasos = cantidadPasos;
    }

    // Inserta un nuevo registro con los datos de este objeto
    public boolean insertar() {
        ContentValues registro = new ContentValues();
        registro.put("idTest", getIdTest());
        registro.put("nombre", getNombre());
        registro.put("cantPasos", getCantidadPasos());
        long resu = dbliteRW.insert("Test", null, registro);
        if (resu<0) {
            Log.d("SQL", "insert Test FAIL");
            return false;
        }
        return true;
    }

    // Borra el registro con el ID de este objeto
    public boolean borrar() {
        int canti = dbliteRW.delete("Test", "idTest = " + getIdTest(), null);
        boolean resu = (canti == 1);
        if (resu) limpiarCampos();
        return resu;
    }

    // Modifica todos los campos del registro con el ID de este objeto
    public boolean modificar() {
        ContentValues registro = new ContentValues();
        registro.put("idTest", getIdTest());
        registro.put("nombre", getNombre());
        registro.put("cantPasos", getCantidadPasos());
        int canti = dbliteRW.update("Test", registro, "idTest = " + getIdTest(), null);
        boolean resu = (canti == 1);
        return resu;
    }

    // Busca un registro con el ID dado, si lo encuentra lo carga en este objeto
    public boolean buscar(int xid) {
        String Query;
        Cursor registro;
        boolean okFound = false;

        limpiarCampos();
        Query = "select nombre, cantPasos from Test where idTest = "+String.valueOf(xid);
        registro = dbliteRO.rawQuery(Query, null);
        registro.moveToFirst();
        if (!registro.isAfterLast()) {
            idTest = xid;
            nombre = registro.getString(0);
            cantidadPasos = registro.getInt(1);
            okFound = true;
        }
        registro.close();
        return okFound;
    }

}
