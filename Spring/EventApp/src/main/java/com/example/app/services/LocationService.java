package com.example.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.models.Location;
import com.example.app.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepo;
	public LocationService(LocationRepository inject) {
		this.locationRepo = inject;
	}
	public void saveLocation(Location location){
		this.locationRepo.save(location);
	}
	public List<Location> getAll(){
		return this.locationRepo.findAll();
	}
	public Location newLocation(String address, String state){
		List<Location> location = locationRepo.findByAddressAndState(address, state);
		if (location.size() > 0) {
			return location.get(0);
		}else {
			Location newLocation = new Location(address,state);
			this.saveLocation(newLocation);
			return newLocation;
		}
	}
}
