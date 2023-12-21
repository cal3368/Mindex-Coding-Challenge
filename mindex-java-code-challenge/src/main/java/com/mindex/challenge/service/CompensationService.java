package com.mindex.challenge.service;

import com.mindex.challenge.data.Compensation;

// Create abstract methods for creating and reading compensations
public interface CompensationService {
    Compensation create(Compensation compensation);
    Compensation read(String employeeId);
}
