package model.Employee;

import model.Competency.ICompetency;
import model.Education.IEducation;
import model.Experience.IExperience;

import java.time.LocalDate;
import java.util.List;

public interface IEmployee {
    int getEmployeeId();
    LocalDate getBirthDate();
    LocalDate getHireDate();
    List<IEducation> getEducations();
    List<IExperience> getExperiences();
    List<ICompetency> getCompetencies();


    void printEmployee();
    void printEmployeeDetail();

    void addEducation(IEducation education);
    void addExperience(IExperience experience);
    void addCompetency(ICompetency competency);
}
