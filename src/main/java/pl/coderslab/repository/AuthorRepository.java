package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author getAuthorsByEmail(String email);
    Author getAuthorsByPesel(String pesel);
//    Listę autorów o zadanym nazwisku.
    Author getAuthorsByLastName(String pesel);
}
