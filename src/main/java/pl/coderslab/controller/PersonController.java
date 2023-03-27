package pl.coderslab.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.*;
import pl.coderslab.service.PersonService;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        Person person = new Person();
        person.setLogin("TurboDymoMan");
        person.setEmail("TurboDymoMan@yeah.pl");
        person.setPassword("TurboHasło");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setCity("Warszawa");
        personDetails.setFirstName("Turbo");
        personDetails.setLastName("DymoMen");
        personDetails.setStreet("Puławska");
        personDetails.setStreetNumber("18");
        person.setPersonDetails(personDetails);
        personService.save(person);
        return "Id dodanej osoby to:"
                + person.getId();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable long id) {
        Person person = personService.findById(id);
        return person.toString();
    }

    @RequestMapping("/update/{id}/{login}/{email}/{password}")
    @ResponseBody
    public String update(@PathVariable long id
            , @PathVariable String login
            , @PathVariable String email
            , @PathVariable String password
    ) {
        Person person = personService.findById(id);
        person.setLogin(login);
        person.setEmail(email);
        person.setPassword(password);
        return person.toString();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable long id) {
        Person perosn = personService.findById(id);
        personService.delete(perosn);
        return "deleted";
    }

//    @GetMapping("/form")
//    public String form() {
//        return "/person/form";
//    }
//
//    @PostMapping("/form")
//    @ResponseBody
//    public String add(@RequestParam String login, @RequestParam String password, @RequestParam String email){
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        personService.save(person);
//        return "Dodano ososobę o id " + person.getId();
//    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("person", new Person());
        return "/person/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String form(Person person){
        personService.save(person);
        return "Dodano ososobę o id " + person.getId();
    }
}