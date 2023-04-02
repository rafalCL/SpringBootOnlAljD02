package pl.coderslab.springbootonlaljd02.cartoon;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Find Cartoon by ID", description = "Returns a single Cartoon",
            tags = { "cartoon" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation",
                    content = @Content(schema = @Schema(implementation = Cartoon.class))),
            @ApiResponse(responseCode = "404", description = "Cartoon not found") })
    @GetMapping("/getCartoonById")
    public Cartoon getCartoonById(@RequestParam Long id) {
        if(Math.random() < .01) {
            throw new RuntimeException("wystąpił wyjątek");
        }

        return new Cartoon(id, "name"+id, "description"+id);
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
