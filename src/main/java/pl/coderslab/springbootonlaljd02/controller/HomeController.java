package pl.coderslab.springbootonlaljd02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
}
