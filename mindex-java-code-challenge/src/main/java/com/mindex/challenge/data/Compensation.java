package com.mindex.challenge.data;


import java.math.BigDecimal;
import java.time.Instant;

// Properties of employee, salary, and effective date.
// Chose to use BigDecimal for salary type
// Originally chose to use LocalDate fot effectiveDate property but changed to Instant
// because application was changing to Instant anyway
// Created getters and setters for properties
public class Compensation {

    private Employee employee;

    private BigDecimal salary;

    private Instant effectiveDate;

    public Compensation() {
    }

    public Employee getEmployee() {return this.employee;}

    public void setEmployee(Employee employee) {this.employee = employee;}

    public BigDecimal getSalary() {return this.salary;}

    public void setSalary(BigDecimal salary) {this.salary = salary;}

    public Instant getEffectiveDate() {return this.effectiveDate;}

    public void setEffectiveDate(Instant effectiveDate) {this.effectiveDate = effectiveDate;}
}
