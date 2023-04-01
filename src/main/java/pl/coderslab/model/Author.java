package pl.coderslab.model;

import lombok.Data;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @NotNull
    @NotBlank
    String firstName;
    @NotNull
    @NotBlank
    String lastName;

    @PESEL
    String pesel;
    @Email
    String email;

    public String getFullName() {
        return lastName + " " + firstName;
    }
}
