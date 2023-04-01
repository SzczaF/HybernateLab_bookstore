package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> readBooksByTitle(String title);

    List<Book> readBooksByCategory(Category category);

    List<Book> readBooksByCategoryId(Long id);
    List<Book> readBooksByAuthors(Author author);
    List<Book> readBooksByPublisher(Publisher publisher);
    List<Book> readBooksByRating(Integer rating);
    List<Book> findFirstBooksByCategoryOrderByTitleAsc(Category category);


}
