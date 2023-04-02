package pl.coderslab.springbootonlaljd02.cinema.genre;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
class GenreService {
    List<Genre> getAll() {
        return List.of(new Genre(1L, "comedy"), new Genre(2L, "action"));
    }

    public Genre getOneById(final long id) {
        if(Math.random() < .5) {
            throw new ResourceNotFoundException("brak zasobu o id="+id);
        }
        return new Genre(id, "genre "+id);
    }

    public Genre create(Genre genre) {
        if(Math.random() < .5) {
            throw new RuntimeException("wystąpił wyjątek podczas dodawania");
        }
        Random r = new Random(System.nanoTime());
        int newId = r.nextInt();
        System.out.println("utworzono wpis w bazie id="+newId);
        return new Genre(newId, genre.getName());

    }

    public void deleteOneById(long id) {
        if(Math.random() < .5) {
            throw new ResourceNotFoundException("brak zasobu o id="+id);
        }
        System.out.println("usunięcie encji o id="+id);
    }

    public Genre update(Genre genre) {
        if(Math.random() < .5) {
            throw new ResourceNotFoundException("brak zasobu o id="+genre.getId());
        }
        return genre;
    }
}
