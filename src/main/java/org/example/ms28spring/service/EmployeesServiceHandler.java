package org.example.ms28spring.service;

import lombok.RequiredArgsConstructor;
import org.example.ms28spring.dao.entity.EmployessEntity;
import org.example.ms28spring.dao.repository.EmployeesRepository;
import org.example.ms28spring.model.request.CreateEmployeesRequest;
import org.example.ms28spring.model.request.UpdateAmountRequest;
import org.example.ms28spring.model.request.UpdateSalaryRequest;
import org.example.ms28spring.model.response.EmployeesResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeesServiceHandler implements EmployeesService{

    private final EmployeesRepository employeesRepository;

    @Override
    public void saveEmployees(CreateEmployeesRequest employees) {
        employeesRepository.save(EmployessEntity.builder().age(employees.getAge())
                        .email(employees.getEmail())
                        .departmentName(employees.getDepartmentName())
                        .salary(employees.getSalary())
                        .firstName(employees.getFirstName())
                        .lastName(employees.getLastName())
                .build());
    }

    @Override
    public void updateSalary(Long id, UpdateSalaryRequest request) {
            var employess = employeesRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));

            employess.setSalary(request.getSalary());

            employeesRepository.save(employess);

    }

    @Override
    public EmployeesResponse getEmployees(Long id) {
            var employees = employeesRepository.findById(id).orElseThrow(()-> new RuntimeException("Employee not found"));

            return new EmployeesResponse(employees.getFirstName()
                    ,employees.getLastName(),employees.getEmail()
                    ,employees.getDepartmentName());

    }


}
