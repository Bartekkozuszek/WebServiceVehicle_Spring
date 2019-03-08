package org.duckdns.microserv.vehicle;

import java.util.HashMap;
import java.util.List;

import org.duckdns.microserv.vehicle.Vehicle;
import org.duckdns.microserv.vehicle.VehicleRepository;
import org.duckdns.microserv.person.Person;
import org.duckdns.microserv.person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {
		
	@Autowired
	private VehicleRepository vehicleRepository;
	

	
	public List<Vehicle> getAllVehiclesByOwner(int personId){		
		return vehicleRepository.findByOwnerId(personId);
		}

	public Vehicle getVehicle(String id) {
		return vehicleRepository.findOne(id);
		
		}

	public void addVehicle(Vehicle vehicle) {	
		vehicleRepository.save(vehicle);
		
		}

	public void updateVehicle(Vehicle vehicle) {
		vehicleRepository.save(vehicle);					
		
		}

	public void deleteVehicle(String id) {
		vehicleRepository.delete(id);

		
	}

	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	public void updateVehicleField(HashMap<String, String> keyValuePair, String id) {
		Vehicle vehicle= vehicleRepository.findOne(id);
		
		for(String key:keyValuePair.keySet()){
		
		switch(key) {
			case "brand":
				vehicle.setBrand(keyValuePair.get(key));
				break;
				
			case "model":
				vehicle.setModel(keyValuePair.get(key));
				break;
				
			case "modelyear":
				vehicle.setModelyear(Integer.parseInt((keyValuePair.get(key))));
				break;
				
			case "type":
				vehicle.setType(keyValuePair.get(key));
				break;
				
			case "regnumber":
				vehicle.setRegnumber(keyValuePair.get(key));
				break;
				
			case "owner":
				vehicle.setOwner(new Person(Integer.parseInt((keyValuePair.get(key)))));
				break;
				
			default:
				break;
		}
		}
		vehicleRepository.save(vehicle);
		
	}
		
	}




