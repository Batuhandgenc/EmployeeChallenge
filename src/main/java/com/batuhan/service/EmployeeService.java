package com.batuhan.service;

import com.batuhan.dto.request.UpdateEmployeeRequestDto;
import com.batuhan.exception.BatuhanException;
import com.batuhan.exception.ErrorType;
import com.batuhan.repository.IEmployeeRepository;
import com.batuhan.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;


    public Employee updateEmployee(UpdateEmployeeRequestDto employee){
        Employee dbEmployee = findEmployeeById(employee.getId());
        dbEmployee.setAge(employee.getAge());
        dbEmployee.setFirstName(employee.getFirstName());
        dbEmployee.setLastName(employee.getLastName());
        dbEmployee.setSalary(employee.getSalary());
        return employeeRepository.save(dbEmployee);
    }
    public String delete(long id){
        employeeRepository.deleteById(id);

        return "Çalışan bilgileri başarıyla silinmiştir";
    }

    public Employee findEmployeeById(long id){
        Optional<Employee> dbEmployee = employeeRepository.findById(id);
        if (dbEmployee.isEmpty()){
          throw new BatuhanException(ErrorType.CALISAN_BULUNAMADI);
        }
        return dbEmployee.get();
    }


}
