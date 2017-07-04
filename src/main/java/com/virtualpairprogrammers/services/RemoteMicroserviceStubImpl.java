package com.virtualpairprogrammers.services;

import java.math.BigDecimal;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.virtualpairprogrammers.controllers.Position;

@Profile("development")
@Service
public class RemoteMicroserviceStubImpl implements RemotePositionMicroserviceCalls 
{	
	// This stub implementation simply returns a random position in a small area.
	// Something in the area of 53.3xxxx and -1.6xxxxxx
	public Position getLatestPositionForVehicle(String name) 
	{
		String randomFraction = "" + Math.random();
		randomFraction = randomFraction.substring(2, randomFraction.length());
				
        BigDecimal lat = new BigDecimal("53.35" + randomFraction);

		randomFraction = "" + Math.random();
		randomFraction = randomFraction.substring(2, randomFraction.length());
		
		BigDecimal longitude = new BigDecimal("-1.54" + randomFraction);
		return new Position(lat, longitude,new java.util.Date(), true, name);
	}

}
