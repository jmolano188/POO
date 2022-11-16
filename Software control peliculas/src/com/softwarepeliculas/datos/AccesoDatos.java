package com.softwarepeliculas.datos;

import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;
import com.softwarepeliculas.excepciones.EscrituraDatosExcepcion;
import com.softwarepeliculas.excepciones.LecturaDatosExcepcion;

import java.util.List;

public interface AccesoDatos {
    boolean comprobarSiExisteArchivo(String nombreArchivo) throws AccesoDatosExcepcion;
    List<Pelicula> listar(String nombreArchivo) throws LecturaDatosExcepcion;
    public void escribir(Pelicula pelicula, String nombreArchivo,boolean anexar) throws EscrituraDatosExcepcion;
    public String buscar(String nombreArchivo, String pelicula)throws LecturaDatosExcepcion;
    public void crear(String nombreArchivo)throws  EscrituraDatosExcepcion;
    public void borrar(String nombreArchivo) throws LecturaDatosExcepcion;
}
