package org.duckdns.microserv.vehicle;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import org.duckdns.microserv.vehicle.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	
	public List<Vehicle> findByOwnerId(int personId);

	}

