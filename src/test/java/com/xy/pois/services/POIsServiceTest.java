package com.xy.pois.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.FixMethodOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.xy.pois.domain.POI;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class POIsServiceTest {

	@Autowired
	private POIsService poisService;
	
	private POI poi = new POI();
	
	@Test
	public void b_FindAllServiceTest() {
		List<POI> testList = poisService.findAll();
		assertThat(testList.contains(poi));
	}

	@Test
	public void c_findNearbyPointsServiceTest() {
		int x = 20;
		int y = 10;
		int dmax = 10;
		List<POI> testList = poisService.findNearbyPoints(x,y,dmax);
		assertThat(testList.contains(poi));
	}
	

}
