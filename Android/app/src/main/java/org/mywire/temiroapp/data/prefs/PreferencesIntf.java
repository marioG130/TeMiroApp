package org.mywire.temiroapp.data.prefs;

public interface PreferencesIntf {

    boolean isUsuarioRegistrado();
    void setUsuarioRegistrado(boolean esUR);

    String getNombreUsuario();
    void setNombreUsuario(String nombre);

    int getIdUsuario();
    void setIdUsuario(int id);

    String getTipoDalton1();
    void setTipoDalton1(String nombre);

}
