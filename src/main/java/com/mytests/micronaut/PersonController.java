package com.mytests.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import jakarta.inject.Inject;


import java.util.List;


@Controller("/person")
public class PersonController {
    private PersonRepository repo;
    public PersonController(PersonRepository repo) {
        this.repo = repo;
        repo.save(new Person(1L, "masha","ivanova"));
        repo.save(new Person(2L, "sasha","petrov"));
        repo.save(new Person(3L, "dasha","sidorova"));
        repo.save(new Person(4L, "sasha","testov"));
        repo.save(new Person(5L, "pasha","pavlov"));

    }

    @Get("/all")
    public List<Person> getAll() {

        return repo.findAll();
    }
    @Get("/byName/{name}")
    public List<Person> getByName(@PathVariable String name) {

        return repo.customQuery1(name);
    }

   
}    