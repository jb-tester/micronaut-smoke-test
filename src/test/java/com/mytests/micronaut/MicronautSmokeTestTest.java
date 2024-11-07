package com.mytests.micronaut;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import jakarta.inject.Inject;

import java.util.List;

@MicronautTest
class MicronautSmokeTestTest {

    @Inject
    EmbeddedApplication<?> application;

    @Inject
    @Client("/person")
    HttpClient client;
    @Inject
    private PersonRepository personRepository;

    @Test
    void testAllPerson() {

        List<Person> results = client.toBlocking().retrieve(HttpRequest.GET("/all"), Argument.listOf(Person.class));
        results.forEach(System.out::println);
        Assertions.assertEquals(
                5,
                results.size()
        );
    }

    @Test
    void testPersonByName() {

         List<Person> results = client.toBlocking().retrieve(HttpRequest.GET("/byName/sasha"), Argument.listOf(Person.class));
results.forEach(System.out::println);
        Assertions.assertEquals(
                2,
                results.size()
        );
    }

    @Test
    void repositoryMethodsTest() {
        personRepository.save(new Person(20L, "natasha", "mashina"));
        int rez = personRepository.getIdByName("natasha");
        Assertions.assertEquals(20,rez);
    }
}
