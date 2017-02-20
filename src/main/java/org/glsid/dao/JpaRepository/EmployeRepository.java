package org.glsid.dao.JpaRepository;

import org.glsid.dao.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
