package com.xy.pois.services;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.xy.pois.domain.POI;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class POIsServiceTest {

	@Autowired
	private POIsService poisService;

	@Test
	public void findAllServiceTest() {
		List<POI> testList = poisService.findAll();
		assertThat(testList.size()).isEqualTo(7);
	}

	@Test
	public void findNearbyPointsServiceTest() {
		int xh = 20;
		int yh = 10;
		int distance = 10;
		List<POI> testList = poisService.findNearbyPoints(xh,yh,distance);
		assertThat(testList.size()).isEqualTo(4);
	}


}
