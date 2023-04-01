package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.service.AuthorService;

import javax.validation.Valid;


@Controller
@RequestMapping("/author/form")
@RequiredArgsConstructor
public class AuthorFormConrtroller {
    private final AuthorService authorService;
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "/author/form";
    }
    @PostMapping("/add")
    public String addSave(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/form";
        }
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
    public String editSave(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/form";
        }
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