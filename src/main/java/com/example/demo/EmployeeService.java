package com.example.demo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getEmployee_id())) {
            throw new IllegalArgumentException("Employee ID already exists");
        }
        return employeeRepository.save(employee);
    }
    
    public TaxResponse calculateTax(int employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        LocalDate doj = employee.getDoj();
        LocalDate currentDate = LocalDate.now();

        long monthsWorked = ChronoUnit.MONTHS.between(doj.withDayOfMonth(1), currentDate.withDayOfMonth(1));
        double yearlySalary = employee.getSalary() * Math.max(0, monthsWorked);

        double tax = 0;
        if (yearlySalary > 250000) {
            if (yearlySalary <= 500000) {
                tax = (yearlySalary - 250000) * 0.05;
            } else if (yearlySalary <= 1000000) {
                tax = 12500 + (yearlySalary - 500000) * 0.10;
            } else {
                tax = 62500 + (yearlySalary - 1000000) * 0.20;
            }
        }

        double cess = yearlySalary > 2500000 ? (yearlySalary - 2500000) * 0.02 : 0.0;

        TaxResponse response = new TaxResponse(
                employee.getEmployee_id(),
                employee.getFirstName(),
                employee.getLastName(),
                yearlySalary,
                tax,
                cess
        );
        System.out.println(response);

        return response;
    }
    
    
}
