package com.xy.pois.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xy.pois.domain.POI;
import com.xy.pois.repositories.POIsRepository;

@Service
public class POIsService {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	private POIsRepository poisRepository;
	
	public POI insert(POI poi) {
		return poisRepository.save(poi);
	}
	
	public List<POI> findAll(){
		return poisRepository.findAll();
	}
	
	public List<POI> findNearbyPoints(int x, int y, int dmax){
		
		String comand = "SELECT * FROM poi p where ( "
				+ " SELECT ST_Distance( "
				+ " point(p.x, p.y), "
				+ " point(" + x + "," + y + ") "
				+ " )) <= " + dmax + " ; ";
		
		Query query = entityManager.createNativeQuery(comand, POI.class);
		
		@SuppressWarnings("unchecked")
		List<POI> nearbyPoints = query.getResultList();
		return nearbyPoints;
	}
}
