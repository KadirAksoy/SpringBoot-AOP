package com.kadiraksoy.SpringBootAOP.config;

import com.kadiraksoy.SpringBootAOP.model.Person;
import com.kadiraksoy.SpringBootAOP.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SetupConfig {


    // personRepository otomatik olarak enjekte edilir @Bean anotasyonu sayesinde.
    @Bean
    CommandLineRunner run(PersonRepository personRepository){
        return args -> {
            Person person1 = new Person("kadir ",22);
            Person person2 = new Person("baran ",17);
            Person person3 = new Person("aksoy",56);
            Person person4 = new Person("ali",42);
            Person person5 = new Person("duru",30);

            personRepository.save(person1);
            personRepository.save(person2);
            personRepository.save(person3);
            personRepository.save(person4);
            personRepository.save(person5);

            System.out.println("Kullanıcılar eklendi.");
        };
    }
}
