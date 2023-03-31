package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.service.AuthorService;



@Controller
@RequestMapping("/book/form")
@RequiredArgsConstructor
public class AuthorFormConrtroller {
    private final AuthorService authorService;

    @PostMapping("/add")
    public String addSave(Author author) {
//        System.out.println(book.toString());
        authorService.save(author);
        return "redirect:/author/all";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "/author/form";
    }
    @PostMapping("/edit/{id}")
    public String editSave(Author author) {
//        Author book = bookService.findById(id);
        authorService.update(author);
        return "redirect:/author/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Author author = authorService.findById(id);
        model.addAttribute("author", author);
        return "/author/confirm-delete";
    }
    @GetMapping("/delete/{id}")
    public String deleteSave(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "redirect:/author/all";
    }

}