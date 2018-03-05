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
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ReadJSONObject {

    public static void main(String[] args)
    {
        try {
            URL url = new URL("http://date.jsontest.com");  // an API returning JSON
            
            InputStream in = url.openStream();

            JsonReader reader = Json.createReader(in);

            JsonObject object = reader.readObject();  // top level object - first "{"
            
            // having consumed the first "{", 
            // we can now access values by their key e.g. "time" etc

            String time = object.getJsonString("time").getString();

            Long milliseconds = object.getJsonNumber("milliseconds_since_epoch").longValue();

            String date = object.getJsonString("date").getString();
            
            System.out.println("Time: " + time);
            System.out.println("Elapsed " + milliseconds + " milliseconds since epoch");
            System.out.println("Date: " + date );

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
