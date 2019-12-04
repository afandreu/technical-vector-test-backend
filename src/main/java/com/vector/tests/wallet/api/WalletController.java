package com.vector.tests.wallet.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vector.tests.wallet.service.impl.ExternalPaymentService;
import com.vector.tests.wallet.service.impl.MonederoDto;
import com.vector.tests.wallet.service.impl.MonederoService;
import com.vector.tests.wallet.service.impl.ResponseDto;

@RestController
@RequestMapping("/wallet")
public class WalletController {
   
	@Autowired
	private  ExternalPaymentService externalPaymentService;
	
	@Autowired
    private MonederoService monederoService; 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MonederoDto> getOne(@PathVariable("id") final String id) {

		try {
			
			MonederoDto monederoDto = monederoService.monederoId(id);
			
			if(monederoDto.getIdentificador() != null) {
				return new ResponseEntity<>(monederoDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/cargo",method = RequestMethod.PUT)
	public ResponseEntity<ResponseDto> cargo(@RequestBody final MonederoDto monederoDto) {

		ResponseDto response = null;

		try {
			response = monederoService.cargo(monederoDto);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	

	@RequestMapping(value = "/reembolso",method = RequestMethod.PUT)
	public ResponseEntity<ResponseDto> reembolso(@RequestBody final MonederoDto monederoDto) {

		ResponseDto response = null;

		try {
			response = monederoService.reembolso(monederoDto);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/third_party",method = RequestMethod.PUT)
	public ResponseEntity<ResponseDto> thirdParty(@RequestBody final MonederoDto monederoDto) {

	    ResponseDto response = null;

		try {
			response = monederoService.thirdParty(monederoDto);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
			
		} catch (final Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
}
