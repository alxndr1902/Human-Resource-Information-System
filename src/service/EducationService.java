package service;

import model.Education.EducationLevel;
import model.Employee.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EducationService {
    List<EducationLevel> getEducationLevels();

    boolean addEducation(EducationLevel educationLevel, String institutionName, LocalDate startDate,
                         LocalDate endDate, double finalScore, Employee employee);
}
