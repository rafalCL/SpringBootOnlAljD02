package pl.coderslab.springbootonlaljd02.clientservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import pl.coderslab.springbootonlaljd02.cinema.genre.Genre;

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

}
