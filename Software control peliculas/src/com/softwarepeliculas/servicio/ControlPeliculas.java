package com.softwarepeliculas.servicio;

public interface ControlPeliculas {
    String NOMBRE_RECURSO= "peliculas.txt";
    public void agregarPelicula(String nombrePelicula);
    public void  listarPeliculas();
    public void buscarPelicula(String pelicula);
    public void iniciarControlDePeliculas();
}
