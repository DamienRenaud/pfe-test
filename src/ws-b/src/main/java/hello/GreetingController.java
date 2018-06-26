package hello;

import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.jws.WebMethod;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by damien on 23/03/2018.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s! I'm local ws B";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {    	
    	String result = String.format(template, name);
        return new Greeting(counter.incrementAndGet(), result);
    }
}
