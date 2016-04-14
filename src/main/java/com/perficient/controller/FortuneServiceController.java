package com.perficient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.rep.FortuneServiceRep;
import com.perficient.service.FortuneService;

@RestController
@RequestMapping("/fortune")
public class FortuneServiceController {
	@Autowired
	FortuneService fortuneService;
	
	@RequestMapping(value="/quote",method = RequestMethod.GET)
	public FortuneServiceRep getFortuneServiceRep() {
		return fortuneService.getFortuneServiceRep();
	}
	
	@RequestMapping(value="/id", method = RequestMethod.GET)
	public String getFortuneServiceId() {
		return fortuneService.getFortuneServiceId();
	}
	
	@RequestMapping(value="/uri", method = RequestMethod.GET)
	public List<String> getFortuneServiceUri() {
		return fortuneService.getFortuneServiceUris();
	}
}
