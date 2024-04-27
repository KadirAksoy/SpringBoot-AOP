package com.kadiraksoy.SpringBootAOP.repository;

import com.kadiraksoy.SpringBootAOP.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
