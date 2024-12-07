package org.example.ms28spring.dao.repository;

import org.example.ms28spring.dao.entity.EmployessEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<EmployessEntity,Long> {
}
