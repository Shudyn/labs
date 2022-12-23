package ru.mtuci.noskov.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.noskov.webapp.dto.MaterialValue;
import ru.mtuci.noskov.webapp.repository.MaterialValueRepo;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
public class MaterialValueController {

    @Autowired
    private MaterialValueRepo repo;

    @PostMapping("material/value")
    public ResponseEntity<String> createMV(@RequestBody MaterialValue materialValue) {
        try {
            repo.save(materialValue);
            return new ResponseEntity<>(materialValue.getBarcode() + " material value is created", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("material/value/{barcode}")
    public ResponseEntity<MaterialValue> getMV(@PathVariable Long barcode) {
        try {
            Optional<MaterialValue> materialValue = repo.findById(barcode);
            if(materialValue.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(materialValue.get(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("material/value")
    public ResponseEntity<List<MaterialValue>> getAllMV() {
        try {
            List<MaterialValue> materialValue = repo.findAll();
            return new ResponseEntity<>(materialValue,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("material/value/{barcode}")
    public ResponseEntity<MaterialValue> updateMV(@PathVariable Long barcode, @RequestBody MaterialValue value) {
        try {
            Optional<MaterialValue> materialValue = repo.findById(barcode);
            if(materialValue.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            MaterialValue materialValue1 = materialValue.get();
            if(value.getWorth() != null || value.getWorth() != 0) materialValue1.setWorth(value.getWorth());
            if(!value.getTypeOfPackage().isEmpty()) materialValue1.setTypeOfPackage(value.getTypeOfPackage());
            repo.save(materialValue1);
            return new ResponseEntity<>(materialValue1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("material/value/{barcode}")
    public ResponseEntity<String> deleteMV(@PathVariable Long barcode) {
        try {
            Optional<MaterialValue> materialValue = repo.findById(barcode);
            if(materialValue.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            repo.delete(materialValue.get());
            return new ResponseEntity<>(materialValue.get().getBarcode() + " is deleted",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
