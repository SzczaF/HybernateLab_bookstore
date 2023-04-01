package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class ValidationController {
    private final Validator validator;
    @RequestMapping("/validate/book")
    public String validateBook(Model model) {
        Book book = new Book();
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Book> violation : violations) {
                System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
            }
        }

        model.addAttribute("messageList", violations);
        return "/validation/show";
    }
    @RequestMapping("/validate/author")
    public String validateAuthor(Model model) {
        Author author = new Author();
        Set<ConstraintViolation<Author>> violations = validator.validate(author);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Author> violation : violations) {
                System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
            }
        }

        model.addAttribute("messageList", violations);
        return "/validation/show";
    }

    @RequestMapping("/validate/publisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        Set<ConstraintViolation<Publisher>> violations = validator.validate(publisher);
        if (!violations.isEmpty()) {
            for (ConstraintViolation<Publisher> violation : violations) {
                System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
            }
        }

        model.addAttribute("messageList", violations);
        return "/validation/show";
    }
}
