package org.example.ms28spring.model.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeesRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Long age;
    private BigDecimal salary;
    private String departmentName;
}
