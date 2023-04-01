package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.model.Category;
import pl.coderslab.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookRepository bookRepository;

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

    @Transactional
    public List<Book> allWithRating(int rating) {
        List<Book> books = bookRepository.readBooksByRating(rating);
        getAuthorsToBookList(books);
        return books;
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

    @Transactional
    public List<Book> getBooksWithTitle(String title) {
        List<Book> books = bookRepository.readBooksByTitle(title);
        getAuthorsToBookList(books);
        return books;
    }

    @Transactional
    public List<Book> getBookWithCategory(Category category) {
        List<Book> books = bookRepository.readBooksByCategory(category);
        getAuthorsToBookList(books);
        return books;
    }

    @Transactional
    public List<Book> getBooksWithCategoryId(Long id) {
        List<Book> books = bookRepository.readBooksByCategoryId(id);
        getAuthorsToBookList(books);
        return books;
    }
    @Transactional
    public List<Book> getBooksByAuthor(Author author) {
        List<Book> books = bookRepository.readBooksByAuthors(author);
        getAuthorsToBookList(books);
        return books;
    }

    @Transactional
    public List<Book> getBooksByPublisher(Publisher publisher) {
        List<Book> books = bookRepository.readBooksByPublisher(publisher);
        getAuthorsToBookList(books);
        return books;
    }

    @Transactional
    public List<Book> getBooksByCategorySortedByName(Category category) {
        List<Book> books = bookRepository.findFirstBooksByCategoryOrderByTitleAsc(category);
        getAuthorsToBookList(books);
        return books;
    }

    // internal methods
    private void getAuthorsToBookList(List<Book> books) {
        books.stream()
                .forEach(b -> Hibernate.initialize(b.getAuthors()));
    }
}
