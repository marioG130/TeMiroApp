package org.mywire.temiroapp.model;

public class User {

    private int idusuario;
    private int tipousuario;
    private String usuario;
    private String password;
    private String email;
    private int aceptatc;

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(int tipousuario) {
        this.tipousuario = tipousuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAceptatc() {
        return aceptatc;
    }

    public void setAceptatc(int aceptatc) {
        this.aceptatc = aceptatc;
    }

}
