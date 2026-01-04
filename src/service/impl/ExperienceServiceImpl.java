package service.impl;

import model.Employee.Employee;
import model.Experience.Experience;
import service.ExperienceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExperienceServiceImpl implements ExperienceService {
    private static final List<Experience> experiences = new ArrayList<>();

    public boolean validateExperience(Employee employee, LocalDate startDate) {
        LocalDate employeeBirthDate = employee.getBirthDate();
        return !startDate.isBefore(employeeBirthDate);
    }

    @Override
    public boolean addNewExperience(String jobTitle, String position, String companyName, LocalDate startDate, LocalDate endDate, Employee employee) {
        int id= 1;
        Experience newExperience = new Experience(id, jobTitle, position,
                companyName, startDate, endDate, employee
        );
        id++;
        employee.getExperiences().add(newExperience);

        return experiences.add(newExperience);
    }
}
