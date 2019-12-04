package com.vector.tests.wallet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vector.tests.wallet.entities.Monedero;
import com.vector.tests.wallet.entities.MonederoRepository;
import com.vector.tests.wallet.service.PaymentServiceException;

@Service
public class MonederoService {
	
	@Autowired
    private MonederoRepository repository;
	
	@Autowired
    private ExternalPaymentService externalPaymentService;
	
	public MonederoDto monederoId(String identificador) {
		
       Monedero monedero = repository.findByIdentificador(identificador);
       
       MonederoDto monederoDto = new MonederoDto();
       if(monedero != null) {
          monederoDto.setIdentificador(monedero.getIdentificador());
          monederoDto.setSaldo(monedero.getSaldo());
       }
       
       return monederoDto;
    }

	public ResponseDto reembolso(MonederoDto monederoDto) {
	   
       Monedero monedero = repository.findByIdentificador(monederoDto.getIdentificador());
       ResponseDto response = new ResponseDto();
       response.setMonedero(monederoDto);
       
       if(monedero != null) {
          monedero.setSaldo(monedero.getSaldo().add(monederoDto.getSaldo()));
          monedero = repository.save(monedero);
	      response.setStatus("OK");
		  response.setMessage("accepted refund");
	   } else {
		  response.setStatus("KO");
		  response.setMessage("Could not refund");
       } 

       return response;
	}
	
	public ResponseDto cargo(MonederoDto monederoDto) {
		   
       Monedero monedero = repository.findByIdentificador(monederoDto.getIdentificador());
       ResponseDto response = new ResponseDto();
       response.setMonedero(monederoDto);
       
       if(monedero != null && monedero.getSaldo().subtract(monederoDto.getSaldo()).signum() > 0) {
          monedero.setSaldo(monedero.getSaldo().subtract(monederoDto.getSaldo()));
          monedero = repository.save(monedero);
		  response.setStatus("OK");
		  response.setMessage("accepted charge");

       } else {
	      response.setStatus("KO");
		  response.setMessage("Could not charge");
       } 

       return response;
	}
	
	public ResponseDto thirdParty(MonederoDto monederoDto) {
		   
	       Monedero monedero = repository.findByIdentificador(monederoDto.getIdentificador());
	       ResponseDto response = new ResponseDto();
	       response.setMonedero(monederoDto);
	       
	       try {
				externalPaymentService.charge(monederoDto.getSaldo());
		        if(monedero != null) {
		           monedero.setSaldo(monedero.getSaldo().add(monederoDto.getSaldo()));
		           monedero = repository.save(monedero);
		           monederoDto.setIdentificador(monedero.getIdentificador());
		           monederoDto.setSaldo(monedero.getSaldo());
                   
				   response.setStatus("OK");
				   response.setMessage("accepted charge");

		        } else {
		 	    	response.setStatus("KO");
					response.setMessage("Could not charge");
		        } 
				
			} catch (PaymentServiceException e) {
	 	    	response.setStatus("KO");
				response.setMessage("Could not charge");
			}
	       

	       return response;
	}
	
}
