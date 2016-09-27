package com.virtualpairprogrammers.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.virtualpairprogrammers.data.VehicleRepository;
import com.virtualpairprogrammers.domain.Vehicle;

@Controller
@RequestMapping("/website/vehicles")
public class VehicleController 
{
	@Autowired
	private VehicleRepository data;

	@RequestMapping(value="/newVehicle.html",method=RequestMethod.POST)
	public String newVehicle(Vehicle vehicle)
	{
		data.save(vehicle);
		return "redirect:/website/vehicles/list.html";
	}
	
	@RequestMapping(value="/deleteVehicle.html", method=RequestMethod.POST)
	public String deleteVehicle(@RequestParam Long id)
	{
		data.delete(id);
		return "redirect:/website/vehicles/list.html";		
	}
	
	@RequestMapping(value="/newVehicle.html",method=RequestMethod.GET)
	public ModelAndView renderNewVehicleForm()
	{
		Vehicle newVehicle = new Vehicle();
		return new ModelAndView("newVehicle","form",newVehicle);
	} 
	
	@RequestMapping(value="/list.html", method=RequestMethod.GET)	
	public ModelAndView vehicles()
	{
		List<Vehicle> allVehicles = data.findAll();
		return new ModelAndView("allVehicles", "vehicles", allVehicles);
	}
	  
	@RequestMapping(value="/vehicle/{name}")
	public ModelAndView showVehicleByName(@PathVariable("name") String name)
	{
		Vehicle vehicle = data.findByName(name);
		
		// get the current position for this vehicle from the microservice
		// TODO - lots to do here to get rid of this horrid hardcoding!!!
		RestTemplate rest = new RestTemplate();
		Position response = rest.getForObject("http://localhost:8090/vehicles/" + name, Position.class);
		
		Map<String,Object> model = new HashMap<>();
		model.put("vehicle", vehicle);
		model.put("position", response);
		return new ModelAndView("vehicleInfo", "model",model);
	}
	
}
