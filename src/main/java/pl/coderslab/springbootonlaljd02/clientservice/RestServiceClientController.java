package pl.coderslab.springbootonlaljd02.clientservice;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.springbootonlaljd02.cinema.genre.Genre;

import java.util.Arrays;

@Controller
@RequestMapping("/client")
public class RestServiceClientController {

    @GetMapping("/call1")
    @ResponseBody
    public String exampleApiCall() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/genres/{id}";
        Genre responseObj = restTemplate.getForObject(url, Genre.class, 4242L);

        return "wysłano zapytanie http, obiekt odpowiedzi: "+responseObj;
    }

    @GetMapping("/call2")
    @ResponseBody
    public String exampleExternalApiCall() {
        final String url = "https://api.chucknorris.io/jokes/random";
        final String responseBody = new RestTemplate().getForObject(url, String.class);

        return "wysłano zapytanie http, ciało odpowiedzi: " + responseBody;
    }

    @GetMapping("/call3")
    @ResponseBody
    public String exampleApiCall2() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8082/genres/{id}";
        ResponseEntity<Genre> responseEntity = restTemplate.getForEntity(url, Genre.class, 4242L);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return "wysłano zapytanie http, obiekt odpowiedzi: "+responseEntity.getBody();
        }

        return "wysłano zapytanie http, serwis zwrócił błąd: "+responseEntity.getStatusCode() + ", " + responseEntity.getStatusCodeValue();
    }

    @GetMapping("/exchange")
    @ResponseBody
    public String exchangeExample() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8082/genres/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        try {
            ResponseEntity<Genre> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Genre.class, 1);
            // tu obsługujemy tylko kody 2xx,
            // gdyż w innym wypdaku metoda exchange() rzuca wyjątek, a nie zwraca ResponseEntity
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                return "wysłano zapytanie http, obiekt odpowiedzi: " + responseEntity.getBody();
            }
        } catch (RestClientException e) {
            return "wysłano zapytanie http, serwis zwrócił błąd: "+ e.getMessage();
        }

        return "unhandled case";
    }
}
