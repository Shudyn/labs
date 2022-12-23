package ru.mtuci.noskov.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtuci.noskov.webapp.dto.Operation;

import java.util.List;

public interface OperationRepo extends CrudRepository<Operation, Long> {

    List<Operation> findAll();

}
