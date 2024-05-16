package com.mytests.micronaut;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();
    int getSumIdByName(String name);

    @Query("select e from Person e where e.name= ?1")
    List<Person> customQuery1(String name);

}