import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // ANSI escape code constants for text colors
        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        //String YELLOW = "\u001B33[m";
        String YELLOW = "\u001B[33m";

        Scanner lectura = new Scanner(System.in);
        // hasta la pelicula 7 está disponible
        ConsultaPelicula consulta = new ConsultaPelicula();
        String tituloStarWars = YELLOW+"""
                                 
                                 d888888888888888888  d8888b    8888888888b
                                 Y888888888888888888 d88PY88b   88888888888b
                                  Y888b    88888    ,88P  Y88.  888R    X88P
                                   Y888b   88888    d88'  `88b  8888bood88P
                           8888888888888b  88888   ,8888888888. 8888PY88888888888
                           8888888888888P  88888   888P    Y888 8888  Y8888888888
                   \s
                           Y88b   d88b   d88P  d8888b    8888888888b  d8888888888
                           `888b d8888b d888' d88PY88b   88888888888b Y8888888888
                            Y888V888888V888P ,88P  Y88.  888R    X88P  Y888b
                            `888888PY888888' d88'  `88b  8888bood88P    Y888b
                             Y8888P  Y8888P ,8888888888. 8888PY8SSt&cgmm88888b
                              Y88P    Y88P  888P    Y888 8888  Y8888888888888P
                """+RESET;
        String menu = """    
                             ===================== MENU ======================
                             1) Una Nueva Esperanza | 2) El Imperio Contrataca
                             3) El Regreso del Jedi | 4) La Amenaza Fantasma
                         5) El ataque de los Clones | 6) La Venganza de los Sith
                """;

        System.out.println(tituloStarWars);
        System.out.println(menu);
        System.out.println("Ingrese el número que identifica a la película que busca:");
    try{
        var numeroDePelicula = Integer.valueOf(lectura.nextLine());
        Pelicula pelicula = consulta.buscaPelicula(numeroDePelicula);
        System.out.println(pelicula);
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        generador.guardarJson(pelicula);
        System.out.println("Saliendo... GRACIAS y...,"+YELLOW+" que la fuerza te acompañe!"+RESET);
    }catch(NumberFormatException | IOException e) {
        System.out.println("Número no encontrado " +e.getMessage());
    }catch (RuntimeException e){
        System.out.println(e.getMessage());
        System.out.println("saliendo de la app... que la fuerza te acompañe!");
    }


    }
}
