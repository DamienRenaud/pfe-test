package hello;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.jws.WebMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by damien on 23/03/2018.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s! I'm local ws A";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
    	Properties props = new Properties();
    	String filename = "application.properties";
    	InputStream input = null;
    	String result = null;
    	try {
    		input = WsAApplication.class.getClassLoader().getResourceAsStream(filename);
			props.load(input);
			String uriB = props.getProperty("wsb.url") + "greeting";
			String uriD = props.getProperty("wsd.url") + "greeting";
	    	
	    	RestTemplate restTemplate = new RestTemplate();
	    	Gson gson = new GsonBuilder().create();
	    	Greeting wsBResponse = gson.fromJson(restTemplate.getForObject(uriB, String.class), Greeting.class);
	    	Greeting wsDResponse = gson.fromJson(restTemplate.getForObject(uriD, String.class), Greeting.class);
	    	
	    	result = String.format(template, name) + ", I'm calling B and D, " + wsBResponse.getContent() + wsDResponse.getContent();
		
    	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        return new Greeting(counter.incrementAndGet(), result);
    }
}
