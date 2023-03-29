package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

import java.util.List;

@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class BookFormController {
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "/book/form";
    }

    @PostMapping("/add")
    public String addSave(Book book) {
//        System.out.println(book.toString());
        bookService.save(book);
        return "redirect:/book/all";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book/form";
    }
    @PostMapping("/edit/{id}")
    public String editSave(Book book) {
//        Book book = bookService.findById(id);
        bookService.update(book);
        return "redirect:/book/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "/book/confirm-delete";
    }
    @GetMapping("/delete/{id}")
    public String deleteSave(@PathVariable long id) {
        Book book = bookService.findById(id);
        bookService.delete(book);
        return "redirect:/book/all";
    }

    @ModelAttribute("publishers")
    public List<Publisher> getPublishers() {
        return publisherService.all();
    }
    @ModelAttribute("authorsList")
    public List<Author> getAuthors() {
        return authorService.all();
    }
}