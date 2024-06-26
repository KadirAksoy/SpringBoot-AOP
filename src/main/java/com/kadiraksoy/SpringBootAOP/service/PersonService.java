package com.kadiraksoy.SpringBootAOP.service;
import com.kadiraksoy.SpringBootAOP.model.Person;
import com.kadiraksoy.SpringBootAOP.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(Long id) {
        Optional<Person> personOptional = personRepository.findById(id);
        return personOptional.orElse(null);
    }

    public Person createPerson(Person person) {

        Person newPerson = personRepository.save(person);
        System.out.println(person.getName()+ " "+ "eklendi");

        return newPerson;
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        if (personRepository.existsById(id)) {
            updatedPerson.setId(id);
            return personRepository.save(updatedPerson);
        }
        return null;
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void aspectExample(){
        System.out.println("Sade haliyle PersonService aspect için fonksiyon örneğidir");
    }

    public void boolAspectExample(){
        System.out.println("Sade haliyle PersonService bool aspect için fonksiyon örneğidir");
    }
}