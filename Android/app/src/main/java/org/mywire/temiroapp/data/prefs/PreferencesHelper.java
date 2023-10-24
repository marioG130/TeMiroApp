package org.mywire.temiroapp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper implements PreferencesIntf {

    private static final String PREF_USUARIO_REGISTRADO = "PREF_USUARIO_REGISTRADO";
    private static final String PREF_USUARIO_NOMBRE = "PREF_USUARIO_NOMBRE";
    private static final String PREF_USUARIO_ID = "PREF_USUARIO_ID";

    private static final String PREF_USUARIO_ID_CLIENTE = "PREF_USUARIO_ID_CLIENTE";
    private final SharedPreferences appPref;

    public PreferencesHelper(Context context) {
        appPref = context.getSharedPreferences("ConfigGlobal", Context.MODE_PRIVATE);
    }

    @Override
    public boolean isUsuarioRegistrado() {
        boolean isuser = appPref.getBoolean(PREF_USUARIO_REGISTRADO,false);
        return isuser;
    }

    @Override
    public void setUsuarioRegistrado(boolean esUR) {
        appPref.edit().putBoolean(PREF_USUARIO_REGISTRADO, esUR).apply();
    }

    @Override
    public String getNombreUsuario() {
        String username = appPref.getString(PREF_USUARIO_NOMBRE,"");
        return username;
    }

    @Override
    public void setNombreUsuario(String nombre) {
        appPref.edit().putString(PREF_USUARIO_NOMBRE, nombre).apply();
    }

    @Override
    public int getIdUsuario() {
        int userid = appPref.getInt(PREF_USUARIO_ID,0);
        return userid;
    }

    @Override
    public void setIdUsuario(int id) {
        appPref.edit().putInt(PREF_USUARIO_ID, id).apply();
    }


    @Override
    public int getIdCliente() {
        int idCliente = appPref.getInt(PREF_USUARIO_ID_CLIENTE, 0);
        return idCliente;
    }

    @Override
    public void setIdCliente(int idCliente) {
        appPref.edit().putInt(PREF_USUARIO_ID_CLIENTE, idCliente).apply();
    }

}

