package com.emp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.emp.model.Employee;
import com.emp.repository.EmployeeRepository;

@SpringBootApplication

public class EmpPortalApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmpPortalApplication.class, args);

	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			employeeRepository.save(new Employee(1, "Manish", "Pandey", "M", "10/09/89", "Middle Order"));
			employeeRepository.save(new Employee(2, "Mithali", "Raj", "F", "03/12/82", "Opener"));
			employeeRepository.save(new Employee(3, "Murali", "Vijay", "M", "01/04/84", "Opener"));
			employeeRepository.save(new Employee(4, "Harmanpreet", "Kaur", "F", "08/03/89", "Allrounder"));
			employeeRepository.save(new Employee(5, "Mayank", "Agarwal", "M", "16/02/91", "Opener"));
		};
	}

}
