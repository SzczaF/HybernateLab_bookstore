package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.service.PublisherService;


@Controller
@RequestMapping("/publisher/form")
@RequiredArgsConstructor
public class PublisherFormConrtroller {
    private final PublisherService publisherService;

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "/publisher/form";
    }
    @PostMapping("/add")
    public String addSave(Publisher publisher) {
//        System.out.println(book.toString());
        publisherService.save(publisher);
        return "redirect:/publisher/all";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publisher", publisher);
        return "/publisher/form";
    }
    @PostMapping("/edit/{id}")
    public String editSave(Publisher publisher) {
//        Publisher book = bookService.findById(id);
        publisherService.update(publisher);
        return "redirect:/publisher/all";
    }

    @GetMapping("/confirm/{id}")
    public String confirm(@PathVariable long id, Model model) {
        Publisher publisher = publisherService.findById(id);
        model.addAttribute("publisher", publisher);
        return "/publisher/confirm-delete";
    }
    @GetMapping("/delete/{id}")
    public String deleteSave(@PathVariable long id) {
        Publisher publisher = publisherService.findById(id);
        publisherService.delete(publisher);
        return "redirect:/publisher/all";
    }


}