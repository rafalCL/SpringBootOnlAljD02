package pl.coderslab.springbootonlaljd02.cartoon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class CartoonController {
    @GetMapping("/getAllCartoons")
    public String getAllCartoons() {
        if(Math.random() < .01) {
            throw new RuntimeException("wystąpił wyjątek");
        }

        return "[{cartoon1},...,{cartoonN}]";
    }

    @GetMapping("/getCartoonById")
    public String getCartoonById(@RequestParam Long id) {
        if(Math.random() < .01) {
            throw new RuntimeException("wystąpił wyjątek");
        }

        return "{cartoon"+id+"}";
    }

    @PostMapping("/createCartoon")
    public String createCartoon(@RequestBody String body) {
        if(Math.random() < .01) {
            throw new RuntimeException("wystąpił wyjątek");
        }

        Cartoon cartoon = new Cartoon();
        // todo handle cartoon creation

        return "utworzono cartoon: "+body;
    }

    @GetMapping("/deleteCartoonById")
    public String deleteCartoonById(@RequestParam Long id) {
        if(Math.random() < .01) {
            throw new RuntimeException("wystąpił wyjątek");
        }
        return "usunięto cartoon id="+id;
    }
}
