//Конечные точки запросов, т.е. при загрузке пользователем данных из формы spring создает объект, с которым можно работать

package ru.mtuci.noskov.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.noskov.webapp.dto.Employee;
import ru.mtuci.noskov.webapp.model.EmployeeCreation;
import ru.mtuci.noskov.webapp.model.EmployeeModel;
import ru.mtuci.noskov.webapp.repository.EmployeeRepo;
import ru.mtuci.noskov.webapp.repository.RoleRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("employee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeCreation creation) {
        try {
            Employee employee = new Employee(creation);
            employee.setRole(roleRepo.findById(employee.getRole().getId()).get());
            employeeRepo.save(employee);
            return new ResponseEntity<>(employee.getName() + " is created",HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("employee/{id}")
    public ResponseEntity<EmployeeModel> getEmployee(@PathVariable Long id) {
        try {
            Optional<Employee> employeeOpt = employeeRepo.findById(id);
            if(employeeOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(new EmployeeModel(employeeOpt.get()),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("employee")
    public ResponseEntity<List<EmployeeModel>> getAllEmployee() {
        try {
            List<EmployeeModel> list = employeeRepo.findAll()
                    .stream()
                    .map(e -> new EmployeeModel(e))
                    .toList();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        try {
            Optional<Employee> employeeOpt = employeeRepo.findById(id);
            if(employeeOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Employee employee1 = employeeOpt.get();
            if(!employee.getName().isEmpty()) employee1.setName(employee.getName());
            if(employee.getRole() != null) employee1.setRole(employee.getRole());
            if(!employee.getPassportId().isEmpty()) employee1.setPassportId(employee.getPassportId());
            if(!employee.getPhoneNumber().isEmpty()) employee1.setPhoneNumber(employee.getPhoneNumber());
            employeeRepo.save(employee1);
            return new ResponseEntity<>(employee1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        try {
            Optional<Employee> employeeOpt = employeeRepo.findById(id);
            if(employeeOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            employeeRepo.delete(employeeOpt.get());
            return new ResponseEntity<>(employeeOpt.get(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
