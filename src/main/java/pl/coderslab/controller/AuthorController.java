package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/update/{id}/{firstName}/{lastName}")
    @ResponseBody
    public String update(@PathVariable long id, @PathVariable String firstName, @PathVariable String lastName) {
        Author author = authorService.findById(id);
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "deleted";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        Author author = new Author();
        author.setFirstName("J.R.R.");
        author.setLastName("Tolkien");
        authorService.save(author);
        return "Id dodanego autora to:"
                + author.getId();
    }

    @RequestMapping("/all")
    @ResponseBody
    public String all(){
        return authorService.all().toString();
    }
}