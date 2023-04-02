package pl.coderslab.springbootonlaljd02.cartoon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cartoon {
    @Schema(description = "Unique identifier of the Cartoon.",
            example = "1", required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Schema(description = "Name of the Cartoon.",
            example = "Johny Bravo", required = true)
    private String name;
    @Schema(description = "Description of this Cartoon.",
            example = "Johny Bravo is a funny young man that likes cakes", required = true)
    private String description;
}
