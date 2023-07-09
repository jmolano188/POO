package com.softwarepeliculas.presentacion;

import com.softwarepeliculas.servicio.ControlPeliculas;
import com.softwarepeliculas.servicio.ControlPeliculasImpl;

import java.util.Scanner;

public class PresentacionControlPeliculas {
    public static void main(String[] args) {
        ControlPeliculas controlPeliculas= new ControlPeliculasImpl();
        Scanner teclado=new Scanner(System.in);
        teclado.useDelimiter("\n");
        int opcion;
        System.out.println("---------------------");
        System.out.println("Software  - control de peliculas");
        do{
            System.out.println("\n digite una opcion por favor: ");
            System.out.println("1. Iniciar control de peliculas");
            System.out.println("2. Agregar pelicula . ");
            System.out.println("3. Lista peliculas ");
            System.out.println("4. Buscar pelicula ");
            System.out.println("5. Salir ");
            System.out.println(" Seleccione una opcion :");
            opcion= teclado.nextInt();

            switch (opcion){
                case 1:
                        controlPeliculas.iniciarControlDePeliculas();
                    break;
                case 2:
                    System.out.println("Digite el nombre de la pelicula");
                    String nombrePelicula=teclado.next();
                    controlPeliculas.agregarPelicula(nombrePelicula);

                    break;
                case 3:
                    System.out.println("");
                    controlPeliculas.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Digite la pelicula a buscar");
                    String peliculaBuscar=teclado.next();
                    controlPeliculas.buscarPelicula(peliculaBuscar);
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Gracias por participar, hasta pronto");
                    opcion=5;
                    break;
                default:
                    System.out.println("");
                    System.out.println("Opcion no disponible, vuelva a intentarlo");

            }
        }while (opcion!=5);
    }
}
