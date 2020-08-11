package com.hobbyappgame.retrofit.Interfaz;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestAuth {

    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Apellido")
    @Expose
    private String apellido;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestAuth() {
    }

    /**
     *
     * @param apellido
     * @param nombre
     */
    public RequestAuth(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
