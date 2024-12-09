package org.example.ms28spring.service;

import org.example.ms28spring.model.request.CreateEmployeesRequest;
import org.example.ms28spring.model.request.UpdateAmountRequest;
import org.example.ms28spring.model.request.UpdateSalaryRequest;
import org.example.ms28spring.model.response.EmployeesResponse;

public interface EmployeesService {
    void saveEmployees(CreateEmployeesRequest employees);

    void updateSalary(Long id, UpdateSalaryRequest request);

    EmployeesResponse getEmployees(Long id);

}
