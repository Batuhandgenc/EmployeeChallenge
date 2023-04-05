package com.batuhan.service;

import com.batuhan.dto.request.CreateCompanyRequestDto;
import com.batuhan.dto.request.CreateEmployeeRequestDto;
import com.batuhan.dto.request.UpdateCompanyRequestDto;
import com.batuhan.exception.BatuhanException;
import com.batuhan.exception.ErrorType;
import com.batuhan.repository.ICompanyRepository;
import com.batuhan.repository.IEmployeeRepository;
import com.batuhan.repository.entity.Company;
import com.batuhan.repository.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final ICompanyRepository companyRepository;
    private final IEmployeeRepository employeeRepository;


    public Company saveCompany(CreateCompanyRequestDto company) {
        Company dbCompany = Company.builder()
                .name(company.getName())
                .description(company.getDescription())
                .build();
        return companyRepository.save(dbCompany);
    }

    public Company updateCompany(UpdateCompanyRequestDto company) {
        Company dbCompany = findCompanyById(company.getId());
        dbCompany.setName(company.getName());
        dbCompany.setDescription(company.getDescription());

        return companyRepository.save(dbCompany);

    }
    public String delete(long id) {
        companyRepository.deleteById(id);
        return "Şirket bilgileri silinmiştir";
    }

    public Company findCompanyById(long id){
        Optional<Company>dBCompany=companyRepository.findById(id);
        if(dBCompany.isEmpty()){
            throw new BatuhanException(ErrorType.FIRMA_BULUNAMADI);
        }
        return dBCompany.get();
    }
    public String addNewEmployee (long id, CreateEmployeeRequestDto dto){
        Company company = companyRepository.findById(id).get();
        Employee employee = Employee.builder()
                .age(dto.getAge())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .salary(dto.getSalary())
                .build();
        employee.setCompany(company);
        company.getEmployeeList().add(employee);
        employeeRepository.save(employee);
        return "Şirkete yeni bir çalışan başarıyla eklendi.";
    }

    public List<Employee> listAllEmployees (long id){
        Company company = companyRepository.findById(id).get();
        return company.getEmployeeList();
    }

    public List<Company> listAllCompany(){
        return companyRepository.findAll();
    }



}
