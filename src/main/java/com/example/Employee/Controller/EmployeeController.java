package com.example.Employee.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Model.Employee;
import com.example.Employee.Service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class EmployeeController {
	@Autowired	
	private EmployeeService empservice;
	
	@PostMapping("/addEmployee")
	
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return empservice.createEmployee(employee);
	}
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> employees)
	{
		return empservice.createEmployees(employees);
	}
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployeeById(@PathVariable int id)
	{
		return empservice.getEmployeeById(id);
	}
	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees()
	{
		return empservice.getEmployees();	
	}
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		return empservice.updateEmployee(employee);
	}
	@DeleteMapping ("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable int id)
	{
		return empservice.deleteEmployeeById(id);
	}
}
