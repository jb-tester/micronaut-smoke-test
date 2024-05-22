package com.mytests.micronaut;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.hibernate.annotations.Parameter;

import java.util.List;


@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

    List<Person> findAll();

    int getIdByName(String name);

    @Query("select e from Person e where e.name= :name")
    List<Person> customQuery1(String name);

}
