package org.ibs.service.domains;

import org.ibs.service.domains.entity.Departament;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends CrudRepository<Departament,Long> {

}
