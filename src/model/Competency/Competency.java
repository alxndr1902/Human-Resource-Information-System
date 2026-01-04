package model.Competency;

import model.Employee.Employee;

public class Competency {
    private int id;
    private String name;
    private ProficiencyType proficiencyType;
    private int proficiencyLevel;
    private Employee employee;

    public Competency(int id, String name, ProficiencyType proficiencyType, int proficiencyLevel, Employee employee) {
        this.id = id;
        this.name = name;
        this.proficiencyType = proficiencyType;
        this.proficiencyLevel = proficiencyLevel;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProficiencyType getProficiencyType() {
        return proficiencyType;
    }

    public int getProficiencyLevel() {
        return proficiencyLevel;
    }

    public Employee getEmployee() {
        return employee;
    }
}
