package com.mcmath.servicetwo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component
public class S2InfoContributor implements InfoContributor {

	@Value("${spring.application.name}")
	String applicationName;
	
	@Override
	public void contribute(Info.Builder builder) {
		Map<String, String> statuses = new HashMap<>();
		statuses.put("appName", applicationName);
		statuses.put("disposition", "awesome");
		statuses.put("feelings", "strong");
        builder.withDetail("General Info", statuses);
        
//        builder.withDetail("General Info",
//                Collections.singletonMap("disposition", "radical"));
	}
}
