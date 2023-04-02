package pl.coderslab.springbootonlaljd02.cinema.genre;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genres")
class GenreController {
    private GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("")
    public List<Genre> getAll() {
        return this.genreService.getAll();
    }

    @PostMapping()
    public ResponseEntity<Genre> create(@RequestBody Genre genre) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.genreService.create(genre));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
        }
    }

    @GetMapping("{id}")
    public Genre getOneById(@PathVariable long id) {
        return this.genreService.getOneById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOneById(@PathVariable long id) {
        try {
            this.genreService.deleteOneById(id);
            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Genre> modifyOne(@RequestBody Genre genre) {
        try {
            this.genreService.update(genre); // long running operation (run asynchronous)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
        }
    }
}
