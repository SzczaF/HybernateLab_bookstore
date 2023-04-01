package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.AuthorService;

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
    public String all(Model model) {
        model.addAttribute("authorsList", authorService.all());
        return "/author/list";
    }

    @RequestMapping("/email/{email}")
    @ResponseBody
    public String getAuthorByEmail(@PathVariable String email) {
        System.out.println(email);
        Author author = authorService.findByEmail(email);
        return author.toString();
    }
    @RequestMapping("/pesel/{pesel}")
    @ResponseBody
    public String getAuthorByPesel(@PathVariable String pesel) {
        System.out.println(pesel);
        Author author = authorService.findByPesel(pesel);
        return author.toString();
    }
    @RequestMapping("/lastName/{lastName}")
    @ResponseBody
    public String getAuthorByLastName(@PathVariable String lastName) {
        System.out.println(lastName);
        Author author = authorService.findByLastName(lastName);
        return author.toString();
    }
}