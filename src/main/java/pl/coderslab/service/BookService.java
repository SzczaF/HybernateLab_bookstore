package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public void save(Book book){
        bookDao.save(book);
    }

    public Book findById(long id){
        return bookDao.findBookWithAuthorsById(id);
    }

    public void update(Book book){
        bookDao.update(book);
    }

    public void delete(Book book){
        bookDao.delete(book);
    }

    public List<Book> all(){
        return bookDao.allWithAuthors();
    }
    public List<Book> allWithRating(int rating) {
        return bookDao.findAllWithRatingAndAuthors(rating);
    }

    public List<Book> allWithAnyPublisher(){
        return bookDao.allWithAnyPublisher();
    }
    public List<Book> allWithPublisher(long id){
        Publisher publisher = publisherService.findById(id);
        return bookDao.allWithPublisher(publisher);
    }

    public List<Book> allWithAuthor(long id){
        Author author = authorService.findById(id);
        return bookDao.allWithAuthor(author);
    }

}
