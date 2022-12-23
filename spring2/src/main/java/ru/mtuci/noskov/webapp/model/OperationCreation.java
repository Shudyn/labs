package ru.mtuci.noskov.webapp.model;

import ru.mtuci.noskov.webapp.dto.Operation;

public class OperationCreation {

    private Long id;
    private String type;
    private Long contractNumber;
    private Long countOfItem;

    private Long barcode; // id Material Value
    private Long employeeId;

    public OperationCreation() {
    }

    public OperationCreation(Long id, String type, Long contractNumber, Long countOfItem, Long barcode, Long employeeId) {
        this.id = id;
        this.type = type;
        this.contractNumber = contractNumber;
        this.countOfItem = countOfItem;
        this.barcode = barcode;
        this.employeeId = employeeId;
    }

    public OperationCreation(Operation operation) {
        this.id = operation.getId();
        this.type = operation.getType();
        this.contractNumber = operation.getContractNumber();
        this.countOfItem = operation.getCountOfItem();
        this.barcode = operation.getMaterialValue().getBarcode();
        this.employeeId = operation.getResponsible().getId();
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

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }



}
