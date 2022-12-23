package ru.mtuci.noskov.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.noskov.webapp.dto.Role;
import ru.mtuci.noskov.webapp.repository.RoleRepo;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleRepo roleRepo;

    @PostMapping("role")
    public ResponseEntity<String> createRole(@RequestBody Role role) {
        try {
            roleRepo.save(role);
            return new ResponseEntity<>(role.getTitle() + " is created", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("role/{id}")
    public ResponseEntity<Role> getRole(@PathVariable Long id) {
        try {
            Optional<Role> roleOPt = roleRepo.findById(id);
            if(roleOPt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(roleOPt.get(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("role")
    public ResponseEntity<List<Role>> getAllRole() {
        try {
            return new ResponseEntity<>(roleRepo.findAll(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("role/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
        try {
            System.out.println(role);
            Optional<Role> roleOpt = roleRepo.findById(id);
            if(roleOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Role role1 = roleOpt.get();
            if(!role.getTitle().isEmpty()) role1.setTitle(role.getTitle());
            if(role.getSalary() != null || role.getSalary() != 0) role1.setSalary(role.getSalary());
            roleRepo.save(role1);
            return new ResponseEntity<>(role1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("role/{id}")
    public ResponseEntity<String> createRole(@PathVariable Long id) {
        try {
            Optional<Role> roleOpt = roleRepo.findById(id);
            if(roleOpt.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            roleRepo.delete(roleOpt.get());
            return new ResponseEntity<>(roleOpt.get().getTitle() + " is deleted",HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
