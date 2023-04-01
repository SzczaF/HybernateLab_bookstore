package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @NotBlank(message = "Pole nie może być puste") //przeniosione do ValidationMessages.properties
    @NotBlank
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 5)
    private int rating;
    @Size(max = 500)
    private String description;
    @NotNull
    @ManyToOne
    private Publisher publisher;

    @NotEmpty
    @ManyToMany
    private List<Author> authors;
    @Min(2)
    private int pages;

    public void addAuthor(Author author) {
        if (authors == null) {
            authors = new ArrayList<>();
        }
        authors.add(author);
    }


}

