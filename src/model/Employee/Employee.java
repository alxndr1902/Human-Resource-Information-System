package model.Employee;

import model.Competency.Competency;
import model.Education.Education;
import model.Experience.Experience;

import java.time.LocalDate;
import java.util.List;

public class Employee {
    private final int employeeId;
    private final String firstName;
    private final String lastName;
    private final char gender;
    private final LocalDate birthDate;
    private final String birthPlace;
    private final String idCardNumber;
    private final LocalDate hireDate;
    private final List<Education> educations;
    private final List<Experience> experiences;
    private final List<Competency> competencies;

    public Employee(int employeeId, String firstName, String lastName, char gender,
                    LocalDate birthDate, String birthPlace, String idCardNumber,
                    LocalDate hireDate, List<Education> educations, List<Experience> experiences, List<Competency> competencies) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.idCardNumber = idCardNumber;
        this.hireDate = hireDate;
        this.educations = educations;
        this.experiences = experiences;
        this.competencies = competencies;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Competency> getCompetencies() {
        return competencies;
    }
}
