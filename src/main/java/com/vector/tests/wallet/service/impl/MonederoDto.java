package com.vector.tests.wallet.service.impl;

import java.math.BigDecimal;

public class MonederoDto {

    private String identificador;
    private BigDecimal saldo;
    private String thirdParty;
    
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getThirdParty() {
		return thirdParty;
	}
	public void setThirdParty(String thirdParty) {
		this.thirdParty = thirdParty;
	}

}
