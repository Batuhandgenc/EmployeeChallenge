package com.batuhan.controller;

import com.batuhan.dto.request.UpdateEmployeeRequestDto;
import com.batuhan.dto.response.GetEmployeeResponseDto;
import com.batuhan.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PutMapping("/update")
    public ResponseEntity<GetEmployeeResponseDto> updateEmployee(@RequestBody UpdateEmployeeRequestDto employeeDto){
        return ResponseEntity.ok(new GetEmployeeResponseDto(employeeService.updateEmployee(employeeDto)));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id){
        return ResponseEntity.ok(employeeService.delete(id));
    }
}
