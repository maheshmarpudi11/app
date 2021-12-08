package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.RecordNotFoundException;
import com.app.entity.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping
	public void errorPath() {
		throw new RuntimeException("path is incorrect..");
	}
	
	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee emp) {
	
		empService.createEmployee(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getEmployeeList() {
		
		List<Employee> empDtoList = empService.getEmployeeList();
		
		return new ResponseEntity<List<Employee>>(empDtoList,HttpStatus.OK);
	}
	
	
	@GetMapping("/byId/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
		
		 Employee emp = empService.getEmployeeById(id);
		
		 if(emp == null) {
			 throw new RecordNotFoundException("Invalid employee id : " + id);
		 }
		 
		return  new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	

	@PutMapping
	public ResponseEntity<Employee> updateEmpDetails(Employee emp) {

		Employee resObj = empService.updateEmpDetails(emp);
		return new ResponseEntity<Employee>(resObj,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		empService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee is deleted with emp-id :"+id ,HttpStatus.OK);
	}
	
	
	@GetMapping("/{address}")
	public ResponseEntity<List<Employee>> searchByAddress(@PathVariable("address") String address) {
		
		List<Employee> empListByName = empService.searchByAddress(address);
		return new ResponseEntity<List<Employee>>(empListByName, HttpStatus.OK);
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<List<Employee>> findByEmpName(@PathVariable("name") String name) {
		
		empService.findByEmpName(name);
		
		
		return null;
	}
	
	
	
}
