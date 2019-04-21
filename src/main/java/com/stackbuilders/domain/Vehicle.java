package com.stackbuilders.domain;

import com.stackbuilders.domain.enumeration.ServiceType;

public class Vehicle {

	private String placa;
	private ServiceType serviceType;
	
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public ServiceType getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}
}
