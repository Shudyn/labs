package ru.mtuci.noskov.webapp.model;

import ru.mtuci.noskov.webapp.dto.Operation;

public class OperationModel {

    private Long id;
    private String type;
    private Long contractNumber;
    private Long countOfItem;
    private Double price;

    private Long barcode; // id Material Value
    private String employeeName;

    public OperationModel() {
    }

    public OperationModel(Operation operation) {
        this.id = operation.getId();
        this.type = operation.getType();
        this.contractNumber = operation.getContractNumber();
        this.countOfItem = operation.getCountOfItem();
        this.barcode = operation.getMaterialValue().getBarcode();
        this.employeeName = operation.getResponsible().getName();
        this.price = operation.getMaterialValue().getWorth() * operation.getCountOfItem();
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
