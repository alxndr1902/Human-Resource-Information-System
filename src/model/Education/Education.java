package model.Education;

import model.Employee.Employee;

import java.time.LocalDate;

public class Education {
    private int id;
    private EducationLevel educationLevel;
    private String institutionName;
    private LocalDate startDate;
    private LocalDate endDate;
    private double finalScore;
    private Employee employee;

    public Education(int id, EducationLevel educationLevel, String institutionName, LocalDate startDate,
                     LocalDate endDate, double finalScore, Employee employee) {
        this.id = id;
        this.educationLevel = educationLevel;
        this.institutionName = institutionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalScore = finalScore;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public Employee getEmployee() {
        return employee;
    }
}
