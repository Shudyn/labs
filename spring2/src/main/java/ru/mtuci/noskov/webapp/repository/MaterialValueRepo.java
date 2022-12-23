package ru.mtuci.noskov.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.mtuci.noskov.webapp.dto.MaterialValue;

import java.util.List;

public interface MaterialValueRepo extends CrudRepository<MaterialValue, Long> {

    List<MaterialValue> findAll();

}
