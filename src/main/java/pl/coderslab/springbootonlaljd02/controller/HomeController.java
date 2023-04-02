package pl.coderslab.springbootonlaljd02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.springbootonlaljd02.cartoon.Cartoon;

import java.util.Map;

@RestController
public class HomeController {
    @Value("${customer.given:Alicja}")
    private String customerGivenGame;
    @Value("${customer.family}")
    private String customerFamilyGame;

    @GetMapping("/")
    public String home() {
        return String.format("welcome home, %s %s!", customerGivenGame, customerFamilyGame);
    }

    @GetMapping("/stat")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String stat() {
        return "methoda się powiodła";
    }

    @GetMapping("/ex")
    public String ex() {
        if(Math.random() < .5) {
            throw new RuntimeException("wystąpił wyjątek");
        }

        return "methoda się powiodła";
    }

    @GetMapping("/re")
    public ResponseEntity re() {
        Map<String, String> headers = Map.of("header-key", "header-value");
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @GetMapping("/re2")
    public ResponseEntity re2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "tajnehaslo");

        return new ResponseEntity("resource created", headers, HttpStatus.CREATED);
    }

    @GetMapping("/reb")
    public ResponseEntity<Cartoon> reBuilder() {
        if(Math.random() < .5) {
            return ResponseEntity
                    .status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(null);
        }
        return ResponseEntity.ok().body(new Cartoon(42L, "cartoon name", "cartoon description"));
    }
}
