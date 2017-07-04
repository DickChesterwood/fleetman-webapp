package com.virtualpairprogrammers.services;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.virtualpairprogrammers.controllers.Position;

@Profile("development")
@Service
public class RemoteMicroserviceStubImpl implements RemotePositionMicroserviceCalls 
{
	private int counter = 0;
	
	private Position[] positions = { 
			new Position(new BigDecimal("53.3519601635634899139404296875"),
					     new BigDecimal("-1.54410858638584613800048828125"), new java.util.Date(),true, "city_truck"),
			new Position(new BigDecimal("53.35"),
				         new BigDecimal("-1.54"), new java.util.Date(),true, "city_truck")
	}; 
	
	@Override
	public Position getLatestPositionForVehicle(String name) 
	{
		return positions[counter++ % positions.length];
	}

}
