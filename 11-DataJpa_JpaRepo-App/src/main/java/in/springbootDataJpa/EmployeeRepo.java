package in.springbootDataJpa;

import org.springframework.data.jpa.repository.JpaRepository;

import in.springbootDataJpa.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
