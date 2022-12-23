package ru.mtuci.noskov.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtuci.noskov.webapp.dto.Role;

import java.util.List;

public interface RoleRepo extends CrudRepository<Role, Long> {

    List<Role> findAll();

}
