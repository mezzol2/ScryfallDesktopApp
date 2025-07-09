//This file is the control file in the MVC model
public class ScryfallDesktop{
    public static void main(String[] args) {
        //Initialize the GUI and the API data
        Data data = new Data();
        GUI gui = new GUI();

        try {
            data.getRequest("/sets/aer");
        } catch (Exception e) {
            System.out.println("Request Failed");
        }
        
        data.printResponse();
        
    }
}
