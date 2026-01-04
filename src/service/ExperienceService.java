package service;

import model.Employee.Employee;

import java.time.LocalDate;

public interface ExperienceService {
    boolean addNewExperience(String jobTitle, String position, String CompanyName, LocalDate startDate,
                             LocalDate endDate, Employee employee);
}
