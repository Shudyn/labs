package ru.mtuci.noskov.webapp.dto;

import jakarta.persistence.*;
import ru.mtuci.noskov.webapp.model.OperationCreation;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Long contractNumber;
    private Long countOfItem;

    @ManyToOne
    @JoinColumn(name = "responsible_id", nullable = false)
    private Employee responsible;

    @ManyToOne
    @JoinColumn(name = "barcode", nullable = false)
    private MaterialValue materialValue;

    public Operation() {
    }

    public Operation(OperationCreation operationCreation) {
        this.id = operationCreation.getId();
        this.type = operationCreation.getType();
        this.contractNumber = operationCreation.getContractNumber();
        this.countOfItem = operationCreation.getCountOfItem();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Long getCountOfItem() {
        return countOfItem;
    }

    public void setCountOfItem(Long countOfItem) {
        this.countOfItem = countOfItem;
    }

    public Employee getResponsible() {
        return responsible;
    }

    public void setResponsible(Employee responsible) {
        this.responsible = responsible;
    }

    public MaterialValue getMaterialValue() {
        return materialValue;
    }

    public void setMaterialValue(MaterialValue materialValue) {
        this.materialValue = materialValue;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", contractNumber=" + contractNumber +
                ", countOfItem=" + countOfItem +
                ", responsible=" + responsible +
                ", materialValue=" + materialValue +
                '}';
    }
}
