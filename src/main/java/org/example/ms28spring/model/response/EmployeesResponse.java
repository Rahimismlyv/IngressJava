package org.example.ms28spring.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeesResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String departmentName;
}
