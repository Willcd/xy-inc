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
			@RequestParam(value="x", required = true) @PathVariable("x")int x,
			@RequestParam(value="y", required = true) @PathVariable("y")int y,
			@RequestParam(value="d-max", required = true) @PathVariable("dmax")int dmax			
		){
		List <POI> nearbyPOIs = poisService.findNearbyPoints(x, y , dmax);
		for(POI poi : nearbyPOIs) {
			System.out.println(poi.getName());
		}
		if(nearbyPOIs.isEmpty()) {
			String noPois = "Não foi encontrado pontos proximos.";
			return new ResponseEntity<String>(noPois, HttpStatus.OK);
		}
	  	return new ResponseEntity<List<POI>>(nearbyPOIs, HttpStatus.OK);
	}
	
}
