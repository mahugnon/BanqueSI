package org.glsid.service;

import org.glsid.metier.OperationMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationService {
	@Autowired
	private OperationMetierImpl operationMetierImpl;
	
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public boolean verser(@RequestParam String code,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		return operationMetierImpl.verser(code, montant, codeEmp);
	}
	@RequestMapping(value="/retirer",method=RequestMethod.PUT)
	public boolean retirer(@RequestParam String code,
			@RequestParam double montant,
			@RequestParam Long codeEmp) {
		return operationMetierImpl.retirer(code, montant, codeEmp);
	}

	@RequestMapping(value="/virements",method=RequestMethod.PUT)
	public boolean virement(@RequestParam String cp1,
			@RequestParam String cp2,
			@RequestParam double montant, 
			@RequestParam Long codeEmp) {
		return operationMetierImpl.virement(cp1, cp2, montant, codeEmp);
	}
	
}
