package com.kadiraksoy.SpringBootAOP;

import com.kadiraksoy.SpringBootAOP.model.Person;
import com.kadiraksoy.SpringBootAOP.repository.PersonRepository;
import com.kadiraksoy.SpringBootAOP.service.DumyService;
import com.kadiraksoy.SpringBootAOP.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PersonService personService, DumyService dumyService){
		return args -> {
			demoBeforeAdvice(personService, dumyService);
//			personService.createPerson(new Person("kadir", 22));
			demoAfterReturningAdvice(personService);

		};
	}

	private void demoBeforeAdvice(PersonService personService,DumyService dumyService){
		personService.aspectExample();

		dumyService.aspectExample();

		personService.boolAspectExample();
		personService.createPerson(new Person("yeni insan", 1));
		personService.createPerson(new Person("yeni insan 2", 2));
		personService.createPerson(new Person("yeni insan 3", 3));

	}

	private void demoAfterReturningAdvice(PersonService personService){
		List<Person> personList = personService.getAllPersons();
	}

}
