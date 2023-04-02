package pl.coderslab.springbootonlaljd02.clientservice;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.springbootonlaljd02.cinema.genre.Genre;

import java.util.Arrays;

@Controller
@RequestMapping("/apifootball")
public class ApiFootballClientController {
    private static final String API_KEY
            = "eee5028bd4f1a9645f0de3b18aa4c17c11a0eedd815aeaacf2cae4d5801e8969";
    private static final String API_URL
            = "https://apifootball.com/api/?action=get_countries&APIkey={apiKey}";

    @GetMapping("/call1")
    @ResponseBody
    public String exampleApiCall() {
            RestTemplate restTemplate = new RestTemplate();
            CountryDTO[] forObject = restTemplate.getForObject(API_URL,
                    CountryDTO[].class, API_KEY);
            return Arrays.toString(forObject);
    }
}
