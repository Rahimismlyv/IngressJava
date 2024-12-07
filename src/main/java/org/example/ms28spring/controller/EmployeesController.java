package org.example.ms28spring.controller;


import lombok.RequiredArgsConstructor;
import org.example.ms28spring.model.request.CreateEmployeesRequest;
import org.example.ms28spring.model.request.UpdateSalaryRequest;
import org.example.ms28spring.model.response.EmployeesResponse;
import org.example.ms28spring.service.EmployeesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/employees")
@RequiredArgsConstructor
public class EmployeesController {
    private final EmployeesService employeesService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployees(@RequestBody CreateEmployeesRequest employees) {
        employeesService.saveEmployees(employees);
    }

    @PatchMapping("/{id}/salary")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateSalary(
            @PathVariable Long id,
            @RequestBody UpdateSalaryRequest salary){
        employeesService.updateSalary(id, salary);
    }

    @GetMapping("/{id}")
    public EmployeesResponse getEmployees(@PathVariable Long id){
        return employeesService.getEmployees(id);
    }
}
