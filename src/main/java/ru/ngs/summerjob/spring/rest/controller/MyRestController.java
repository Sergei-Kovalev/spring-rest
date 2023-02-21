package ru.ngs.summerjob.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ngs.summerjob.spring.rest.entity.Employee;
import ru.ngs.summerjob.spring.rest.exception_handling.NoSuchEmployeeException;
import ru.ngs.summerjob.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " in Database!");
        }
        return employee;

    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee changeEmployee(@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new NoSuchEmployeeException("Employee with id " + id + " does not exist!");
        }

        employeeService.deleteEmployee(id);

        return "Employee with id " + id + " was deleted!";
    }

    //just test method...
    @RequestMapping("/")
    public String showStart() {
        return "start";
    }
}
