package org.duckdns.microserv.person;


import org.springframework.data.jpa.repository.JpaRepository;
import org.duckdns.microserv.person.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	}

