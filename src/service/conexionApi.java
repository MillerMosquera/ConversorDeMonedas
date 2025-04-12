package service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*Clase responsable de la comunicación con API externas*/
public class conexionApi {

    static String API_KEY = System.getenv("APIKEY");
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client;

    /*Constructor que inicializa el cliente Http*/
    public conexionApi() {
        this.client = HttpClient.newHttpClient();
    }

    /**
     * El constructor permite inyectar a un cliente personalizado
     *
     * @param client
     */
    public conexionApi(HttpClient client) {
        this.client = client;
    }

    /**
     * Realiza la petición GET a la API
     *
     * @param endpoint Ruta especifica del endpoint
     * @return Devuelve un String con la respuesta del servidor
     * @throws IOException          Si ocurre un error en la comunicación
     * @throws InterruptedException Sí se interrumpe la comunicación
     */
    public String ApiGet(String endpoint) throws IOException, InterruptedException {
        String url = URL_BASE + API_KEY + endpoint;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.
                send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

}
