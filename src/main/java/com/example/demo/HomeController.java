package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/")
    public String index(Model model) {
        //First let's create a person
        Person person = new Person();
        person.setName("Brianna Plowright");
        person.setSsn("55555555");
        Passport passport = new Passport();
        passport.setNationality("Jamaican");
        person.setPassport(passport);
        personRepository.save(person);
        model.addAttribute("persons", personRepository.FindAll());
        return "index";
    }
    }

