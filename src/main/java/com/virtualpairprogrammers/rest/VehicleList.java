package com.virtualpairprogrammers.rest;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.virtualpairprogrammers.domain.Vehicle;

@XmlRootElement(name="vehicles")
public class VehicleList
{
	private List<Vehicle> vehicles;
	
	public VehicleList() {}
	
	public VehicleList(List<Vehicle> vehicles)
	{
		this.vehicles = vehicles;
	}

	@XmlElement(name="vehicle")
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
