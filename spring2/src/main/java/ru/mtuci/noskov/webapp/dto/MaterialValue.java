package ru.mtuci.noskov.webapp.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MaterialValue {

    @Id
    private Long barcode;
    private String typeOfPackage;
    private Double worth;

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long id) {
        this.barcode = id;
    }

    public String getTypeOfPackage() {
        return typeOfPackage;
    }

    public void setTypeOfPackage(String typeOfPackage) {
        this.typeOfPackage = typeOfPackage;
    }

    public Double getWorth() {
        return worth;
    }

    public void setWorth(Double worth) {
        this.worth = worth;
    }

    @Override
    public String toString() {
        return "MaterialValue{" +
                "barcode=" + barcode +
                ", typeOfPackage='" + typeOfPackage + '\'' +
                ", worth=" + worth +
                '}';
    }
}
