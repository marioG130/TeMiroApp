package org.mywire.temiroapp.data.prefs;

public interface PreferencesIntf {

    boolean isUsuarioRegistrado();
    void setUsuarioRegistrado(boolean esUR);

    String getNombreUsuario();
    void setNombreUsuario(String nombre);

    int getIdUsuario();
    void setIdUsuario(int id);

    int getIdCliente();

    void setIdCliente(int idCliente);

}
