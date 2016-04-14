package com.perficient.rep;

public class FortuneServiceRep {
	private Fortune fortune;
	private String serviceUri;
	
	public FortuneServiceRep() {
		super();
	}
	
	public FortuneServiceRep(Fortune fortune, String serviceUri) {
		super();
		this.fortune = fortune;
		this.serviceUri = serviceUri;
	}
	
	public Fortune getFortune() {
		return fortune;
	}
	public void setFortune(Fortune fortune) {
		this.fortune = fortune;
	}
	public String getServiceUri() {
		return serviceUri;
	}
	public void setServiceUri(String serviceUri) {
		this.serviceUri = serviceUri;
	}
	
	
}
