package com.mcmath.servicetwo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class S2Controller {
	@Value("${spring.application.name}")
	String applicationName;
	
	@Autowired
	DiscoveryClient discoveryClient;

	@RequestMapping("/my-instances")
	public List<ServiceInstance> serviceInstancesByApplicationName() {
		return discoveryClient.getInstances(applicationName);
	}
	
	@RequestMapping("/data")
	public String getVersion() {
		return "service two provides this data";
	}
}
