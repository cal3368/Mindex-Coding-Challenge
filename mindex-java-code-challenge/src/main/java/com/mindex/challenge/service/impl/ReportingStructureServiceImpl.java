package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ReportingStructureService reportingStructureService;

    // Reads employee from employeeId and calculates number of reports from getTotalNumberReports method
    // Returns reporting structure
    public ReportingStructure read(String employeeId) {
        LOG.debug("Reading reporting structure for employee with employeeId: [{}]", employeeId);
        Employee employee = employeeService.read(employeeId);
        int numberOfReports = reportingStructureService.getTotalNumberReports(employee);

        return new ReportingStructure(employee, numberOfReports);
    }

    // Method to recursively calculate number of reports by getting direct reports and getting total
    // number of reports of of direct reports
    public int getTotalNumberReports(Employee employee) {
        int total = 0;

        if (employee == null) {
            throw new RuntimeException("null employee");
        }
        List<Employee> directReports = employee.getDirectReports();

        if (directReports != null) {
            for (Employee report : directReports) {
                total += 1 + getTotalNumberReports(employeeService.read(report.getEmployeeId()));
            }
        }
        return total;
    }
}
