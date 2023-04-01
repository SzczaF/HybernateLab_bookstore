package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorDao authorDao;
    private final AuthorRepository authorRepository;

    public void save(Author author) {
        authorDao.save(author);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(Author author) {
        authorDao.delete(author);
    }

    public List<Author> all() {
        return authorDao.all();
    }

    public Author findByEmail(String email) {
        return authorRepository.getAuthorsByEmail(email);
    }

    public Author findByPesel(String pesel) {
        return authorRepository.getAuthorsByPesel(pesel);
    }

    public Author findByLastName(String lastName) {
        return authorRepository.getAuthorsByLastName(lastName);
    }

}
