package com.vector.tests.wallet.entities;

import org.springframework.data.repository.CrudRepository;

public interface MonederoRepository extends CrudRepository<Monedero, String> {
	
	Monedero findByIdentificador(String identificador);

}
