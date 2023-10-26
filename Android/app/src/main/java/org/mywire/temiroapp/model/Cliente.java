package org.mywire.temiroapp.model;

public class Cliente {
    private int idcliente;
    private int idusuario;
    private String apellido;
    private String nombre;
    private int dni;
    private String direccion;
    private String email;
    private int idciudad;
    private String telefono;
    private String celular;
    private String fechanac;


    public Cliente(int idcliente, int idusuario, String apellido, String nombre, int dni, String direccion, String email, int idciudad, String telefono, String celular, String fechanac) {
        this.idcliente = idcliente;
        this.idusuario = idusuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.email = email;
        this.idciudad = idciudad;
        this.telefono = telefono;
        this.celular = celular;
        this.fechanac = fechanac;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    public int getIdciudad() {
        return idciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCelular() {
        return celular;
    }

    public String getFechanac() {
        return fechanac;
    }
}
