package ru.mtuci.noskov.webapp.model;

import ru.mtuci.noskov.webapp.dto.Employee;

public class EmployeeModel {


    private long id;
    private String name;
    private String passportId;
    private String phoneNumber;
    private String roleTitle;

    public EmployeeModel(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.passportId = employee.getPassportId();
        this.phoneNumber = employee.getPhoneNumber();
        this.roleTitle = employee.getRole().getTitle();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
}
