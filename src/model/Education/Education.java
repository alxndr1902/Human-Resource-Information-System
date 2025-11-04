package model.Education;

import model.Employee.IEmployee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Education implements IEducation {
    protected int educationId;
    protected EducationLevel level;
    protected String institutionName;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected double finalScore;
    protected IEmployee employees;

    public Education(int educationId, EducationLevel level, String institutionName, LocalDate startDate, LocalDate endDate, double finalScore, IEmployee employees) {
        this.educationId = educationId;
        this.level = level;
        this.institutionName = institutionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.finalScore = finalScore;
        this.employees = employees;
    }

    public void printEducation() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Level: %s, Instituion Name: %s, Start Date: %s, End Date: %s, Final Score: %.2f\n",
                this.level, this.institutionName, this.startDate.format(dateFormat), this.endDate.format(dateFormat), this.finalScore
        );
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public EducationLevel getLevel() {
        return level;
    }
}
