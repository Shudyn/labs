//Интерфейс для взаимодействия с бд.

package ru.mtuci.noskov.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtuci.noskov.webapp.dto.Employee;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {

    List<Employee> findAll();

}
