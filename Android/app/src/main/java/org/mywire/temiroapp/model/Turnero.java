package org.mywire.temiroapp.model;

import java.util.Calendar;

public class Turnero {
    private String motivoCita;
    private Calendar fechaCita;
    private boolean confirmado;
    private boolean cancelado;

    public Turnero(String motivoCita, Calendar fechaCita) {
        this.motivoCita = motivoCita;
        this.fechaCita = fechaCita;
        this.confirmado = false; // Por defecto, el turno no está confirmado
        this.cancelado = false; // Por defecto, el turno no está cancelado
    }

    public String getMotivoCita() {
        return motivoCita;
    }

    public void setMotivoCita(String motivoCita) {
        this.motivoCita = motivoCita;
    }

    public Calendar getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Calendar fechaCita) {
        this.fechaCita = fechaCita;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
}
