package com.vector.tests.wallet.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Monedero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    @Column(name = "identificador", nullable = false)
    private String identificador;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
}
