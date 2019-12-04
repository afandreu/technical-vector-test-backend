package com.vector.tests.wallet.service.impl;

public class ResponseDto {
	
	private String status;
	private String message;
	private MonederoDto monedero;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MonederoDto getMonedero() {
		return monedero;
	}
	public void setMonedero(MonederoDto monedero) {
		this.monedero = monedero;
	}

}
