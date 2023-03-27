package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    @RequestMapping("/add")
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        Author author1 = authorService.findById(1);
        Author author2 = authorService.findById(2);

        publisherService.save(publisher);
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setPublisher(publisher);
        book.addAuthor(author1);
        book.addAuthor(author2);
        bookService.save(book);
        return "/book/list";
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id) {
        Book book = bookService.findById(id);
        return book.toString();
    }

    @RequestMapping("/update/{id}/{title}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String title) {
        Book book = bookService.findById(id);
        book.setTitle(title);
        bookService.update(book);
        return book.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "deleted";
    }

    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("books", bookService.all());
        return "/book/list";
    }
    @RequestMapping("/all/rating/{rating}")
    @ResponseBody
    public String allWithRating(@PathVariable int rating) {
        return bookService.allWithRating(rating).toString();
    }
    @RequestMapping("/all/anyPublisher")
    @ResponseBody
    public String allWithAnyPublishers() {
        return bookService.allWithAnyPublisher().toString();
    }
    @RequestMapping("/all/publisher/{id}")
    @ResponseBody
    public String allWithPublisher(@PathVariable long id) {
        return bookService.allWithPublisher(id).toString();
    }
    @RequestMapping("/all/author/{id}")
    @ResponseBody
    public String allWithAuthor(@PathVariable long id) {
        return bookService.allWithAuthor(id).toString();
    }
}
