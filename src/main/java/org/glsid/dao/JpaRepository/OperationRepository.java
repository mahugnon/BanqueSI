package org.glsid.dao.JpaRepository;

import org.glsid.dao.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {

}
