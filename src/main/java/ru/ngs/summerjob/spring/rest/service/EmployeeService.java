package ru.ngs.summerjob.spring.rest.service;


import ru.ngs.summerjob.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}
