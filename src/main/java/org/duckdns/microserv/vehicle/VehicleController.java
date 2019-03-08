package org.duckdns.microserv.vehicle;

import java.util.HashMap;
import java.util.List;

import org.duckdns.microserv.vehicle.Vehicle;
import org.duckdns.microserv.vehicle.VehicleService;
import org.duckdns.microserv.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VehicleController {

		
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/persons/{personId}/vehicles")
	public List<Vehicle> getAllVehiclesByOwner(@PathVariable String personId) {
		return vehicleService.getAllVehiclesByOwner(Integer.parseInt(personId));
	}
	
	@RequestMapping(value="/persons/{personId}/vehicles/{id}")
	public Vehicle getVehicleByOwner(@PathVariable String id) {
		return vehicleService.getVehicle(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/persons/{personId}/vehicles")
	public void addVehicle(@RequestBody Vehicle vehicle, @PathVariable String personId) {
		vehicle.setOwner(new Person(Integer.parseInt(personId)));
		vehicleService.addVehicle(vehicle);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/persons/{personId}/vehicles/{id}")
	public void updateVehicleByOwner(@RequestBody Vehicle vehicle, @PathVariable String personId, @PathVariable String id) {
			vehicle.setOwner(new Person(Integer.parseInt(personId)));
			
			vehicleService.updateVehicle(vehicle);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = {"/persons/{personId}/vehicles/{id}", "/vehicles/{id}"})
	public void deleteVehicle( @PathVariable String id) {
		vehicleService.deleteVehicle(id);
	}
	
	@RequestMapping("/vehicles")
	public List<Vehicle> getAllVehicles() {
		return vehicleService.getAllVehicles();
		
	}
	
	@RequestMapping(value="/vehicles/{id}")
	public Vehicle getVehicle(@PathVariable String id) {
		return vehicleService.getVehicle(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/vehicles/{id}")
	public void updateVehicle(@RequestBody Vehicle vehicle,  @PathVariable String id) {			
		vehicleService.updateVehicle(vehicle);

	}
	
	@RequestMapping(method = RequestMethod.PATCH, value ="/vehicles/{id}")
	public void updateVehicleField(@RequestBody HashMap<String,String> keyValuePair, @PathVariable String id) {
		vehicleService.updateVehicleField(keyValuePair, id);
		
	}
	
	
	@RequestMapping(method = RequestMethod.PATCH, value ="/persons/{personId}/vehicles/{id}")
	public void updateVehicleFieldBYPerson(@RequestBody HashMap<String,String> keyValuePair,  @PathVariable String personId, @PathVariable String id) {
		keyValuePair.put("owner", personId);  //override if owner changed in this URL
		vehicleService.updateVehicleField(keyValuePair, id);
		
	}

	
}


