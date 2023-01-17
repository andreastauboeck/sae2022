package at.ac.fhwn.location.server;

import at.ac.fhwn.sae.lesson3.Cow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloWorldController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String root(){
        return "Hello World";
    }

    @GetMapping("/cow")
    public Cow cow(){
        return new Cow("Loisi");
    }

    @GetMapping("/cows")
    public List<Cow> cows(){
        Cow first = new Cow("Loisi");
        Cow second = new Cow("Zenzi");
        List<Cow> cows = new ArrayList<>();
        cows.add(first);
        cows.add(second);
        return cows;
    }
}
