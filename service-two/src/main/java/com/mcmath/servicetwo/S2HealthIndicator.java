package com.mcmath.servicetwo;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.health.Health;

@Component
public class S2HealthIndicator implements HealthIndicator {

//	@Override
//	protected void doHealthCheck(Builder builder) throws Exception {
//		builder.up();
//		builder.status("MicroStub lookin' good");
//		builder.withDetail("description", "hopping");
//	}

	@Override
	public Health health() {
		return Health.up().build();
	}

}
