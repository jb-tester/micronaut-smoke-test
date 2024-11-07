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
