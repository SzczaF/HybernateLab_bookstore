package pl.coderslab.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional

public class BookDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public Book findBookWithAuthorsById(Long id) {
        Book book = findById(id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    //    public List<Book> all() {
//        return entityManager.createQuery("select b from Book b").getResultList();
//    }
    public List<Book> allWithAuthors() {
        Query query = entityManager.createQuery("select distinct b from Book b join fetch b.authors order by b.id asc");
        return query.getResultList();
    }

    public List<Book> allWithRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b where b.rating = :rating order by b.id asc");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> findAllWithRatingAndAuthors(int r) {
        Query query = entityManager.createQuery(
                "SELECT b from Book b " +
                "left join Fetch b.authors " +
                "where b.rating = :rating " +
                "order by b.id asc");
        query.setParameter("rating", r);
        return query.getResultList();
    }

    public List<Book> allWithAnyPublisher() {
        return entityManager.createQuery(
                "select b from Book b " +
                "join b.publisher " +
                "join fetch b.authors " +
                "order by b.id asc").getResultList();
    }

    public List<Book> allWithPublisher(Publisher publisher) {
        Query query = entityManager.createQuery(
                "select b from Book b " +
                        "join b.publisher " +
                        "left join fetch b.authors where b.publisher =:publisher " +
                        "order by b.id asc");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> allWithAuthor(Author author) {
        return entityManager.createQuery(
                        "select b from Book b " +
                                "join b.publisher " +
                                "join fetch b.authors " +
                                "where :author member of b.authors")
                .setParameter("author", author)
                .getResultList();

    }

}
