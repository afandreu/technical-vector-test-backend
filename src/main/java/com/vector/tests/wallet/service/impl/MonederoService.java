package com.vector.tests.wallet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.tests.wallet.entities.Monedero;
import com.vector.tests.wallet.entities.MonederoRepository;

@Service
public class MonederoService {
	
	@Autowired
    private MonederoRepository repository;
	
	public MonederoDto monederoId(String identificador) {
		
       Monedero monedero = repository.findByIdentificador(identificador);
       
       MonederoDto monederoDto = new MonederoDto();
       if(monedero != null) {
          monederoDto.setIdentificador(monedero.getIdentificador());
          monederoDto.setSaldo(monedero.getSaldo());
       }
       
       return monederoDto;
    }

	public MonederoDto cargo(MonederoDto monederoDto) {
	   
       Monedero monedero = repository.findByIdentificador(monederoDto.getIdentificador());
       
       if(monedero != null) {
          monedero.setSaldo(monedero.getSaldo() + monederoDto.getSaldo());
          monedero = repository.save(monedero);
          monederoDto.setIdentificador(monedero.getIdentificador());
          monederoDto.setSaldo(monedero.getSaldo());
	   } else {
	          monederoDto.setIdentificador(null);
	          monederoDto.setSaldo(null);
       } 

       return monederoDto;
	}
	
	public MonederoDto reembolso(MonederoDto monederoDto) {
		   
       Monedero monedero = repository.findByIdentificador(monederoDto.getIdentificador());
       
       if(monedero != null && monedero.getSaldo() - monederoDto.getSaldo() >= 0) {
          monedero.setSaldo(monedero.getSaldo() - monederoDto.getSaldo());
          monedero = repository.save(monedero);
          monederoDto.setIdentificador(monedero.getIdentificador());
          monederoDto.setSaldo(monedero.getSaldo());
	   } else {
          monederoDto.setIdentificador(null);
          monederoDto.setSaldo(null);
       } 

       return monederoDto;
	}
}
