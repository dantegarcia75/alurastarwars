import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// poner public ante de class de buscaPelicula para uqe pueda ser visible para cualquier clase en src
public class ConsultaPelicula {
    //Esta clase va a tener un método que va a recibir un parámetro
    // (el num de la peli que buscamos)
    public Pelicula buscaPelicula (int numeroDePelicula){
        //https://docs.oracle.com/en/java/javase/17/docs/api/
        // java.net.http/java/net/http/HttpRequest.html
        // del enlace de arriba corto y pego el código de httpRequest
        //NO OLVIDAR IMPORTAR: httpRequest, httpClient y URI
        URI direccion = URI.create("https://swapi.py4e.com/api/films/"+numeroDePelicula+"/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        // https://docs.oracle.com/en/java/javase/17/docs/api/
        // java.net.http/java/net/http/HttpResponse.html
        // del enlace de arriba copy/paste el cod de httpResponse
        // NO OLVIDAR: en send boton derecho esta para elegir "add exceptions to method signature"
        // o "MORE ACTIONS". elegir la última y elegir "surround con try/catch"

        // HttpResponse<String> response = null; ya no lo necesito porque el null no va a estar
        try {
            //response = client estaba antes, ahora se le coloca el HttpResponse<String>
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Pelicula.class);
        //} catch (IOException | InterruptedException e) {
        //    throw new RuntimeException(e); -->esto estaba al principio, luego bruno decidió cambiarlo
        } catch (Exception e) {
            throw new RuntimeException("No se encontró esa pelicula");
        }

        // para agregar Gson --> File > Project Structure > Modules > Dependencies
        // click en el signo "+" y elegimos la opcion: JARs or Directories...
        //desde ahi buscamos donde tenemos nuestro archivo gson-2.10.1.jar y le damos "OK"
        //NO OLVIDAR: importar gson --> import com.google.gson.Gson;
        //return new Gson().fromJson(response.body(), Pelicula.class); --> estaba antes y ahorra lo mete dentro del try


    }

}
