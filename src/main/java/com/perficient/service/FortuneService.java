package com.perficient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.perficient.rep.Fortune;
import com.perficient.rep.FortuneServiceRep;

@Service
public class FortuneService {

	@Value("${my.service.fortune.name}")
	private String fortuneServiceName;

	@Autowired
	private DiscoveryClient discoveryClient;

	@HystrixCommand(fallbackMethod = "defaultQuotes")
	public FortuneServiceRep getFortuneServiceRep() {
		RestTemplate restTemplate = new RestTemplate();
		List<ServiceInstance> list = discoveryClient.getInstances(fortuneServiceName);
		if (list != null && list.size() > 0) {
			String uri = list.get(0).getUri().toString();
			Fortune fortune = restTemplate.getForObject(uri + "/random", Fortune.class);
			return new FortuneServiceRep(fortune, uri);
		}
		return null;
	}
	
	public FortuneServiceRep defaultQuotes() {
		Fortune fortune = new Fortune((long)9999, "It's not always rainbows and butterflies. It's compromise that moves us along");
        return new FortuneServiceRep(fortune, "http://localhost:8080");
    }

	public String getFortuneServiceId() {
		return discoveryClient.getInstances(fortuneServiceName).get(0).getServiceId();
	}

	public List<String> getFortuneServiceUris() {
		List<String> uriList = new ArrayList<String>();
		List<ServiceInstance> list = discoveryClient.getInstances(fortuneServiceName);
		for (ServiceInstance si : list) {
			uriList.add(si.getUri().toString());
		}
		return uriList;
	}

}
