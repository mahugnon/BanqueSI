package org.glsid.metier;

import java.util.List;

import org.glsid.dao.entities.Client;

public interface ClientMetier {

	public Client saveClient(Client cl);
	public List<Client> listClient();
}
