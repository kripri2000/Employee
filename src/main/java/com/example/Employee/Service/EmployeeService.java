package com.example.Employee.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Model.Employee;
import com.example.Employee.Repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository emprepo;
	
	public Employee createEmployee(Employee employee) {
		return emprepo.save(employee);
	}

	public List<Employee> createEmployees(List<Employee> employees) {
		return emprepo.saveAll(employees);
	}

	public Employee getEmployeeById(int id) {
		return emprepo.findById(id).orElse(null);
	}

	public List<Employee> getEmployees() {
		return emprepo.findAll();
	}

	public Employee updateEmployee(Employee employee) {
		Employee oldEmp = null; //existing employee
		Optional<Employee> optionalemp = emprepo.findById(employee.getId());
		if(optionalemp.isPresent())
		{
			oldEmp = optionalemp.get();
			oldEmp.setEmailid(employee.getEmailid());
			oldEmp.setAddress(employee.getAddress());
			oldEmp.setPhno(employee.getPhno());
			emprepo.save(oldEmp);
		}
		else
		{
			return new Employee();
		}
		return oldEmp;
	}

	public String deleteEmployeeById(int id) {
		emprepo.deleteById(id);
		return "User with id "+id+" deleted";
	}

}
