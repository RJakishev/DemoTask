package com.demotask.decathlon;

import com.demotask.decathlon.model.Event;
import com.demotask.decathlon.model.Result;
import com.demotask.decathlon.repository.EventRepository;
import com.demotask.decathlon.service.EventService;
import com.demotask.decathlon.service.ResultService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DecathlonApplicationTests {

	@Autowired
	private EventService eventService;

	@Autowired
	private ResultService resultService;

	@Test
	void testResultCalculationWithDistanceMeasurement(){
		Result result = new Result();
		Event event = eventService.getById(2);
		result.setEvent(event);
		result.setEventResult(321.0);

		int points = (int) resultService.getCalculatedResultPointsInEvent(result);

		Assertions.assertEquals(91, points);

	}

	@Test
	void testResultCalculationWithTimeMeasurement(){
		Result result = new Result();
		Event event = eventService.getById(1);
		result.setEvent(event);
		result.setEventResult(15.2);

		int points = (int) resultService.getCalculatedResultPointsInEvent(result);

		Assertions.assertEquals(163, points);

	}
}
