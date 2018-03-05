package JsonObjectReader;


/**
 * Retrieve JSON data from a Date API.
 * Parsing JSON data using JsonReader (Object Model)
 *
 * Ref:http://www.developer.com/java/ent/explore-the-java-api-for-json-processing.html
 *
 * Jar: javax.json-1.0.4.jar  - download and add to library
 *
 * Json Object Model Parsing
 * Reads JSON data from a date API , parses the data and displays it
 */

import java.io.InputStream;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Cities {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Dundalk&APPID=0d74278a94f6a4c65ea58eedebe033fa");  // an API returning JSON

            InputStream in = url.openStream();

            JsonReader reader = Json.createReader(in);

            JsonObject object = reader.readObject();  // top level object - first "{"
               String base = object.getJsonString("base").getString();
            
            
//            Double lon = object.getJsonNumber("lon").doubleValue();
            // having consumed the first "{", 
            // we can now access values by their key e.g. "time" etc
            JsonArray arr = object.getJsonArray("weather");

            // you use loop here to get all!!
            JsonObject obj0 = arr.getJsonObject(0);

            String main = obj0.getJsonString("main").getString();
            int id = obj0.getJsonNumber("id").intValue();
            String descritpion = obj0.getJsonString("description").getString();

            System.out.println("Main: " + main);
            System.out.println("id: " + id);
            System.out.println("description: " + descritpion);
            System.out.println("base: " + base);
            
            JsonObject objectCoord = object.getJsonObject("coord");
            System.out.println("coord " + objectCoord);
            
            JsonObject objectMain = object.getJsonObject("main");
            System.out.println("main " + objectMain);
            
            JsonObject objectWind = object.getJsonObject("wind");
            System.out.println("main " + objectWind);
            

            //Long milliseconds = object.getJsonNumber("milliseconds_since_epoch").longValue();
            //String date = object.getJsonString("date").getString();
            //System.out.println("Time: " + time);
            // System.out.println("Elapsed " + milliseconds + " milliseconds since epoch");
            //System.out.println("Date: " + date );
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

//https://swapi.co/api/people/4?format=json
