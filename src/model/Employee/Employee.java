package model.Employee;

import model.Competency.ICompetency;
import model.Education.IEducation;
import model.Experience.IExperience;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Employee implements IEmployee {
    protected int employeeId;
    protected String firstName;
    protected String lastName;
    protected char gender;
    protected LocalDate birthDate;
    protected String birthPlace;
    protected String idCardNumber;
    protected LocalDate hireDate;
    protected List<IEducation> educations = new ArrayList<>();
    protected List<IExperience> experiences = new ArrayList<>();
    protected List<ICompetency> competencies = new ArrayList<>();

    public Employee(int employeeId, String firstName, String lastName, char gender, LocalDate birthDate, String birthPlace, String idCardNumber, LocalDate hireDate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.idCardNumber = idCardNumber;
        this.hireDate = hireDate;
    }

    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public List<IEducation> getEducations() {
        return educations;
    }

    @Override
    public List<IExperience> getExperiences() {
        return experiences;
    }

    @Override
    public List<ICompetency> getCompetencies() {
        return competencies;
    }

    @Override
    public void printEmployee() {
        System.out.printf("Employee Id: %d, Full Name: %s %s\n",
                this.employeeId, this.firstName, this.lastName);
    }

    @Override
    public void printEmployeeDetail() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Employee Id: %d\n", this.employeeId);
        System.out.printf("First Name: %s\n", this.firstName);
        System.out.printf("Last Name: %s\n", this.lastName);
        System.out.printf("Gender: %s\n", this.gender);
        System.out.printf("Birth Date: %s\n", this.birthDate.format(dateFormat));
        System.out.printf("Birth Place: %s\n", this.birthPlace);
        System.out.printf("ID Card Number: %s\n", this.idCardNumber);
        System.out.printf("Hire Date: %s\n", this.hireDate.format(dateFormat));
    }

    @Override
    public void addEducation(IEducation education) {
        educations.add(education);
    }

    @Override
    public void addExperience(IExperience experience) {
        experiences.add(experience);
    }

    @Override
    public void addCompetency(ICompetency competency) {
        competencies.add(competency);
    }
}
