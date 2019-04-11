package com.xy.pois.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xy.pois.domain.POI;
import com.xy.pois.services.POIsService;

@RestController
@RequestMapping(value="/xypois")
public class POIsController {

	@Autowired
	private POIsService poisService;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> add(@Valid @RequestBody POI poi, BindingResult result){
		
	    if (result.hasErrors()) {
			return new ResponseEntity<Object>(result.getAllErrors(), HttpStatus.PRECONDITION_FAILED);
	    }else {
	    	POI insertedPoi = poisService.insert(poi);
	    	return new ResponseEntity<POI>(insertedPoi, HttpStatus.CREATED);
	    }
	}
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public ResponseEntity<List<POI>> getAllPOIs(){
		List <POI> listPOIs = poisService.findAll();
		return new ResponseEntity<List<POI>>(listPOIs, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findPOIs(
			@RequestParam(value="xh", required = true) @PathVariable("xh")int xh,
			@RequestParam(value="yh", required = true) @PathVariable("xh")int yh,
			@RequestParam(value="distance", required = true) @PathVariable("xh")int distance			
		){
		System.out.println(xh);
		System.out.println(yh);
		
		List <POI> nearbyPOIs = poisService.findNearbyPoints(xh, yh , distance);
		System.out.println(nearbyPOIs);
		for(POI poi : nearbyPOIs) {
			System.out.println(poi.getName());
		}
		if(nearbyPOIs.isEmpty()) {
			return new ResponseEntity<String>("Não foram encontrados pontos proximos.",HttpStatus.NO_CONTENT);
		}
	  	return new ResponseEntity<List<POI>>(nearbyPOIs, HttpStatus.OK);

	}
}
