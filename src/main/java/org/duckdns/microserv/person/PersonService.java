package org.duckdns.microserv.person;

import java.util.HashMap;
import java.util.List;

import org.duckdns.microserv.person.Person;
import org.duckdns.microserv.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
		
	@Autowired
	private PersonRepository personRepository;
	

	
	public List<Person> getAllPersons(){		
		return personRepository.findAll();
		}

	public Person getPerson(int id) {
		return personRepository.findOne(id);
		
		}

	public void addPerson(Person person) {	
		personRepository.save(person);
		
		}

	public void updatePerson(Person person, int id) {
		personRepository.save(person);					
		
		}

	public void deletePerson(int id) {
		personRepository.delete(id);

			
		}

	public void updatePersonField(HashMap<String,String> keyValuePair, int id) {
		Person person= personRepository.findOne(id);
		
		for(String key:keyValuePair.keySet()){
		
		switch(key) {
			case "first_name":
				person.setFirstName(keyValuePair.get(key));
				break;
				
			case "last_name":
				person.setLastName(keyValuePair.get(key));
				break;
				
			case "driverslicense":
				person.setDriverslicense(keyValuePair.get(key));
				break;
				
			case "city":
				person.setCity(keyValuePair.get(key));
				break;
				
			case "email":
				person.setEmail(keyValuePair.get(key));
				break;
				
			default:
				break;
		}
		}
		personRepository.save(person);
		
	}
	

	}


