package com.mindex.challenge.service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

// Create abstract methods for reading reporting structure and getting the total number of reports
public interface ReportingStructureService {
    ReportingStructure read(String employeeId);

    int getTotalNumberReports(Employee employee);
}
