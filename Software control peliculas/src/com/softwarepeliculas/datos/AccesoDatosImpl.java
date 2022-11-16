package com.softwarepeliculas.datos;

import com.softwarepeliculas.domain.Pelicula;
import com.softwarepeliculas.excepciones.AccesoDatosExcepcion;
import com.softwarepeliculas.excepciones.EscrituraDatosExcepcion;
import com.softwarepeliculas.excepciones.LecturaDatosExcepcion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccesoDatosImpl implements  AccesoDatos{
    @Override
    public boolean comprobarSiExisteArchivo(String nombreArchivo) throws AccesoDatosExcepcion {
        File archivo= new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosExcepcion {
        File archivo= new File(nombreArchivo);
        List<Pelicula> peliculas=new ArrayList<>();
        try {
            BufferedReader entrada= new BufferedReader(new FileReader(archivo));
            String contenido=null;
            contenido=entrada.readLine();
            while (contenido!=null){
                Pelicula pelicula=new Pelicula(contenido);
                peliculas.add(pelicula);
                contenido=entrada.readLine();
            }
            entrada.close();
        }catch (IOException exception){
            exception.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Excepcion al listar peliculas : "+exception.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosExcepcion {
      File archivo=new File(nombreArchivo);
      try {
          PrintWriter salida=new PrintWriter(new FileWriter(archivo,anexar));
          salida.println(pelicula.toString());
          salida.close();
          System.out.println("");
          System.out.println("Se ha añadido la pelicula : "+ pelicula);
          System.out.println("");
      }catch (IOException exception){
          exception.printStackTrace(System.out);
          throw new EscrituraDatosExcepcion("Excepcion al escribir en el archivo : "+exception.getMessage());
      }
    }

    @Override
    public String buscar(String nombreArchivo, String pelicula) throws LecturaDatosExcepcion {
        File archivo=new File(nombreArchivo);
        String resultado=null;
        try {
            BufferedReader entrada= new BufferedReader(new FileReader(archivo));
            String linea=null;
            linea=entrada.readLine();
            int indice =1;
            while (linea!=null){
                if(pelicula!=null && pelicula.equalsIgnoreCase(linea)){
                    System.out.println("");
                    resultado="Pelicula "+ linea+" encontrada en el indice "+indice;
                    break;
                }
                linea=entrada.readLine();
                indice++;
            }
            entrada.close();
        }catch (IOException exception){
            exception.printStackTrace(System.out);
            throw new LecturaDatosExcepcion("Error al buscar  contenido en el archivo : "+exception.getMessage());
        }
        return resultado;
    }
    @Override
    public void crear(String nombreArchivo) throws EscrituraDatosExcepcion {
        File archivo=new File(nombreArchivo);
        try {
            PrintWriter salida=new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println(" se ha creado el archivo");
        }catch (IOException exception){
            exception.printStackTrace(System.out);
            throw  new EscrituraDatosExcepcion("Excepcion al crear el archivo: "+exception.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws LecturaDatosExcepcion {
        File archivo = new File(nombreArchivo);
        if(archivo.exists()){
            archivo.delete();
            System.out.println("se ha borrado el archivo");
        }


    }
}
