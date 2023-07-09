package com.softwarepeliculas.servicio;

import com.softwarepeliculas.datos.AccesoDatos;
import com.softwarepeliculas.datos.AccesoDatosImpl;
import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;

import java.util.List;

public class ControlPeliculasImpl implements ControlPeliculas{
    private final AccesoDatos datos;

    public ControlPeliculasImpl() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula=new Pelicula(nombrePelicula);
        boolean anexar=false;
        try {
            anexar=datos.comprobarSiExisteArchivo(NOMBRE_RECURSO);
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        }catch (AccesoDatosExcepcion excepcion){
            System.out.println("Error de acceso a datos");
            excepcion.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
         List<Pelicula>  peliculas=datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula:peliculas) {
                System.out.println("Pelicula :" +pelicula);
            }
        }catch (AccesoDatosExcepcion excepcion){
            System.out.println("Error de acceso a datos");
            excepcion.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String pelicula) {
        String resultado=null;
        try {
            resultado=datos.buscar(NOMBRE_RECURSO,pelicula);
        }catch (AccesoDatosExcepcion excepcion){
            System.out.println("Error de acceso a datos");
            excepcion.printStackTrace(System.out);
        }
       if (resultado==null){
           System.out.println("pelicula no encontrada");
       }else {
           System.out.println("pelicula encontrada: "+pelicula);
       }
    }

    @Override
    public void iniciarControlDePeliculas() {
    try {
            if(datos.comprobarSiExisteArchivo(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                datos.crear(NOMBRE_RECURSO);
            }
    }catch (Exception excepcion){
        System.out.println("Error al iniciar control de peliculas");
        excepcion.printStackTrace(System.out);
    }
    }
}
