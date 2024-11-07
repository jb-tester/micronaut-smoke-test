package com.mytests.micronaut;


import jakarta.inject.Singleton;

@Singleton
public class DBService {


    private final PersonRepository repo;

    public DBService(PersonRepository repo) {
        this.repo = repo;
    }

    public void populateDB() {
        repo.save(new Person(1L, "masha","ivanova"));
        repo.save(new Person(2L, "sasha","petrov"));
        repo.save(new Person(3L, "dasha","sidorova"));
        repo.save(new Person(4L, "sasha","testov"));
        repo.save(new Person(5L, "pasha","pavlov"));
        System.out.println( "!!!!!!!!!!!!!!!!!! the db is filled !!!!!!!!!!1");
    }
}