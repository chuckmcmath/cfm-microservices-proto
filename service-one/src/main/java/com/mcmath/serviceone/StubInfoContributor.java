package com.mcmath.serviceone;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class StubInfoContributor implements InfoContributor {

	@Override
	public void contribute(Info.Builder builder) {
		Map<String, String> statuses = new HashMap<>();
		statuses.put("disposition", "awesome");
		statuses.put("feelings", "strong");
        builder.withDetail("General Info", statuses);
        
//        builder.withDetail("General Info",
//                Collections.singletonMap("disposition", "radical"));
	}
}
