package com.gab.employee.service;

import com.gab.employee.domain.Employee;
import com.gab.employee.exception.DataNotFoundException;
import com.gab.employee.repository.EmployeeRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeRepository repository;


    /**
     * {@inheritDoc}
     */
    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee update(Employee employee, String id) {

        Optional<Employee> employeeOptional = repository.findById(id);
        if (employeeOptional.isPresent()) {
            employeeOptional.get().setFirstName(employee.getFirstName());
            employeeOptional.get().setLastName(employee.getLastName());
            employeeOptional.get().setEmail(employee.getEmail());
            employeeOptional.get().setNumber(employee.getNumber());
            employeeOptional.get().setDepartment(employee.getDepartment());

            return repository.save(employeeOptional.get());
        }
        throw new DataNotFoundException("Employee Id not found");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Employee> getById(String id) {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> getAll() {
        return (List<Employee>) repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
