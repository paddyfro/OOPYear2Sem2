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

public class Earthquakes {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo&style=full");  // an API returning JSON

            InputStream in = url.openStream();

            JsonReader reader = Json.createReader(in);

            JsonObject object = reader.readObject();  // top level object - first "{"

            // having consumed the first "{", 
            // we can now access values by their key e.g. "time" etc
            JsonArray arr = object.getJsonArray("earthquakes");

            // you use loop here to get all!!
            JsonObject obj0 = arr.getJsonObject(0);

            String datetime = obj0.getJsonString("datetime").getString();

            System.out.println("datetime:" + datetime);

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
