package model.Experience;

import model.Employee.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Experience{
    protected int experienceId;
    protected String jobTitle;
    protected String position;
    protected String companyName;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected Employee employee;

    public Experience(int experienceId, String jobTitle, String position, String companyName,
                      LocalDate startDate, LocalDate endDate, Employee employee) {
        this.experienceId = experienceId;
        this.jobTitle = jobTitle;
        this.position = position;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public int getExperienceId() {
        return experienceId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPosition() {
        return position;
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Employee getEmployee() {
        return employee;
    }
}
