package ru.mtuci.noskov.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.noskov.webapp.dto.Employee;
import ru.mtuci.noskov.webapp.dto.MaterialValue;
import ru.mtuci.noskov.webapp.dto.Operation;
import ru.mtuci.noskov.webapp.model.OperationCreation;
import ru.mtuci.noskov.webapp.model.OperationModel;
import ru.mtuci.noskov.webapp.repository.EmployeeRepo;
import ru.mtuci.noskov.webapp.repository.MaterialValueRepo;
import ru.mtuci.noskov.webapp.repository.OperationRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@CrossOrigin
public class OperationController {

    @Autowired
    private OperationRepo operationRepo;

    @Autowired
    private MaterialValueRepo materialValueRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("operation")
    public ResponseEntity<String> createOperation(@RequestBody OperationCreation operationCreation) {
        try {
            Operation operation = new Operation(operationCreation);
            Optional<Employee> employee = employeeRepo.findById(operationCreation.getEmployeeId());
            if (employee.isEmpty()) return new ResponseEntity<>("employee value not found", HttpStatus.NOT_FOUND);
            operation.setResponsible(employee.get());
            Optional<MaterialValue> materialValue = materialValueRepo.findById(operationCreation.getBarcode());
            if (materialValue.isEmpty()) return new ResponseEntity<>("material value not found", HttpStatus.NOT_FOUND);
            operation.setMaterialValue(materialValue.get());
            System.out.println(operation);

            operationRepo.save(operation);
            return new ResponseEntity<>(operation.getId() + " id operation is created", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("operation/{id}")
    public ResponseEntity<OperationModel> getOperation(@PathVariable Long id) {
        try {
            Optional<Operation> operation = operationRepo.findById(id);
            if (operation.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            OperationModel model = new OperationModel(operation.get());
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("operation")
    public ResponseEntity<List<OperationModel>> getAllOperation() {
        try {
            List<OperationModel> operationList = operationRepo.findAll()
                    .stream()
                    .map(o -> new OperationModel(o))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(operationList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("operation/{id}")
    public ResponseEntity<OperationModel> updateOperation(@PathVariable Long id, @RequestBody OperationCreation operationCreation) {
        try {
            Optional<Operation> oldOperationOpt = operationRepo.findById(id);
            if (oldOperationOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Operation oldOperation = oldOperationOpt.get();
            if (operationCreation.getCountOfItem() != null || operationCreation.getCountOfItem() != 0) oldOperation.setCountOfItem(operationCreation.getCountOfItem());
            if (operationCreation.getEmployeeId() != null || operationCreation.getEmployeeId() != 0) {
                Optional<Employee> employee = employeeRepo.findById(operationCreation.getEmployeeId());
                if (employee.isPresent()) oldOperation.setResponsible(employee.get());
            }
            if(operationCreation.getBarcode() != null || operationCreation.getEmployeeId() != 0) {
                Optional<MaterialValue> materialValue = materialValueRepo.findById(operationCreation.getBarcode());
                if (materialValue.isPresent()) oldOperation.setMaterialValue(materialValue.get());
            }
            operationRepo.save(oldOperation);
            OperationModel model = new OperationModel(oldOperation);
            return new ResponseEntity<>(model, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("operation/{id}")
    public ResponseEntity<String> deleteOperation(@PathVariable Long id) {
        try {
            Optional<Operation> operation = operationRepo.findById(id);
            if (operation.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            operationRepo.delete(operation.get());
            return new ResponseEntity<>(operation.get().getId() + " is deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
