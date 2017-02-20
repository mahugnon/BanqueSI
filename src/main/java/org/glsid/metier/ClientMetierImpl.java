package org.glsid.metier;

import java.util.List;

import org.glsid.dao.JpaRepository.ClientRepository;
import org.glsid.dao.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientMetierImpl  implements ClientMetier{
	
	@Autowired
	private ClientRepository clientRepository; 

	@Override
	public Client saveClient(Client cl) {
		
		return clientRepository.save(cl);
	}

	@Override
	public List<Client> listClient() {
		return clientRepository.findAll();
	}

}
