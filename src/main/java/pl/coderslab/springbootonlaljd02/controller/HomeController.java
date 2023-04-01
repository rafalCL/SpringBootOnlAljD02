package pl.coderslab.springbootonlaljd02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
