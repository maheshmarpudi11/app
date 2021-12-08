package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

	public List<Employee> findByAddress(String address);

	@Query(value = "select e from Employee e where e.firstName= :name or e.lastName= :name")
	public List<Employee> findByEmpName(@Param("name") String name);

}
