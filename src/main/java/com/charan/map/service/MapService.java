package com.charan.map.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.charan.map.model.GeocodingResponse;
import com.charan.map.model.Location;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MapService {

	private static final String apiKey = "AIzaSyCTWAOF_H060Hi9GKYHvRApqrWPrOCjGI0";

	public Location addCoordinates(Location location) {

		String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location.getCity() + ","
				+ location.getState() + "&key=" + apiKey;

		RestTemplate restTemplate = new RestTemplate();
		GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
		Location coordinates = response.getResults().get(0).getGeometry().getLocation();

		location.setLat(coordinates.getLat());
		location.setLng(coordinates.getLng());

		System.out.printf("Latitude " , coordinates.getLat());
		System.out.printf("Longitude " , coordinates.getLng());

		return location;
	}

}
