package model.Experience;

import model.Employee.IEmployee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Experience implements IExperience{
    protected int experienceId;
    protected String jobTitle;
    protected String position;
    protected String companyName;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected IEmployee employee;

    public Experience(int experienceId, String jobTitle, String position, String companyName, LocalDate startDate, LocalDate endDate, IEmployee employee) {
        this.experienceId = experienceId;
        this.jobTitle = jobTitle;
        this.position = position;
        this.companyName = companyName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public void printExperience() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Title: %s, Position: %s, Company Name: %s, Start Date: %s, End Date: %s\n",
                this.jobTitle, this.position, this.companyName, this.startDate.format(dateFormat), this.endDate.format(dateFormat)
        );
    }
}
