package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Employee;
import com.app.repository.EmployeeRepo;

@Service
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EmployeeRepo empRepo;
	
	public List<Employee> getEmployeeList() {
		
		List empList  = empRepo.findAll();
		/*
		 * List empDtoList = new ArrayList<>();
		 * 
		 * empList.stream().forEach(emp -> empDtoList.add(emp) );
		 */
		
		logger.info("emp list :: "+empList);
		return empList;
	}

	public Employee createEmployee(Employee emp) {
		logger.info("emp obj ::" +emp);
		return empRepo.save(emp);
		
	}

	public Employee getEmployeeById(Long id) {
		
		return empRepo.findById(id).orElse(null);
	}

	public Employee updateEmpDetails(Employee emp) {
		 return empRepo.save(emp);
		
	}

	public void deleteEmployee(Long id) {
		
		empRepo.deleteById(id);
		
	}

	public List<Employee> searchByAddress(String address) {
		return empRepo.findByAddress(address);
		
	}
	
	
	public List<Employee> findByEmpName(String name){
		return empRepo.findByEmpName(name);
 	}

}
