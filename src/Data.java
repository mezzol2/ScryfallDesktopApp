import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpClient;

//This is the Model file in the MVC
public class Data {
    //Declare variables for the Http Request
    private HttpClient client = HttpClient.newHttpClient();
    private final String API = "https://api.scryfall.com";
    private HttpResponse<String> response = null;

    public void getRequest(String data) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
            .GET()
            .header("User-Agent", "ScryfallDesktopApp")
            .header("Accept", "*/*")
            .uri(URI.create(API+data))
            .build();
        
        response = client.send(request, BodyHandlers.ofString());
    }

    //printResponse method is used for testing
    public void printResponse(){
        System.out.println(response.body());
    }
}
