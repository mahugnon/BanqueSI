package org.glsid.dao.JpaRepository;

import org.glsid.dao.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository  extends JpaRepository<Compte, String>{

}
