package org.duckdns.microserv.person;

import java.util.HashMap;
import java.util.List;

import org.duckdns.microserv.person.Person;
import org.duckdns.microserv.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

		
		@Autowired
		private PersonService personService;
		
		@RequestMapping("/persons")
		public List<Person> getAllPersons() {
			return personService.getAllPersons();
		}
		
		@RequestMapping("/persons/{id}")
		public Person getPerson(@PathVariable String id) {
			return personService.getPerson(Integer.parseInt(id));
		}
		
		@RequestMapping(method = RequestMethod.POST, value ="/persons")
		public void addPerson(@RequestBody(required=true) Person person) {
			personService.addPerson(person);
		}
		
		@RequestMapping(method = RequestMethod.PUT, value ="/persons/{id}")
		public void addPerson(@RequestBody(required=true) Person person, @PathVariable String id) {
			personService.updatePerson(person, Integer.parseInt(id));
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value ="/persons/{id}")
		public void deletePerson(@PathVariable String id) {
			personService.deletePerson(Integer.parseInt(id));
		}
		
		@RequestMapping(method = RequestMethod.PATCH, value ="/persons/{id}")
		public void updatePersonField(@RequestBody HashMap<String,String> keyValuePair, @PathVariable String id) {
			System.out.println(keyValuePair);
			personService.updatePersonField(keyValuePair, Integer.parseInt(id));
			
		}

	}


