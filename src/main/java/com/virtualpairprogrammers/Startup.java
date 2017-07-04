package com.virtualpairprogrammers;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualpairprogrammers.data.VehicleRepository;
import com.virtualpairprogrammers.domain.Vehicle;

/**
 * Used to ensure that the necessary data is pre-populated.
 */
@Service
@Transactional
public class Startup {
	Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private VehicleRepository data;
	
	private String[] requiredVehicles = {"city_truck", "village_truck", "small_parcel_service1", "express_delivery1"};
	
	public void populateData()
	{
		Arrays.stream(requiredVehicles).forEach(it -> createVehicleIfDoesntExist(it));
	}

	private void createVehicleIfDoesntExist(String name) {
		Vehicle exisiting = data.findByName(name);
		if (exisiting == null)
		{
			log.info("Creating record for " + name);
			this.data.save(new Vehicle(name));
		}
	}
	
	
}
