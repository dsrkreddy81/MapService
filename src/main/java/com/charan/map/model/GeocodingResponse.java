package com.charan.map.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class GeocodingResponse {
	private List<Geocoding> results;

	public List<Geocoding> getResults() {
		return results;
	}

	public void setResults(List<Geocoding> results) {
		this.results = results;
	}
}
