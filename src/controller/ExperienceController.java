package controller;

import model.Experience.Experience;
import model.Employee.IEmployee;
import model.Experience.IExperience;

import java.time.LocalDate;
import java.util.TreeMap;

public class ExperienceController {
    protected static final TreeMap<Integer, IExperience> experiences = new TreeMap<>();

    public static void inputExperience(String jobTitle, String position, String companyName, LocalDate startDate, LocalDate endDate, IEmployee employee) {
        int experienceIdCounter = 1;
        int experienceMapCounter = 1;
        IExperience newExperience = new Experience(experienceIdCounter++, jobTitle, position,
                companyName, startDate, endDate, employee
        );
        experiences.put(experienceMapCounter++, newExperience);

        employee.addExperience(newExperience);
    }

    public static boolean validateExperience(LocalDate startDate, IEmployee employee) {
        LocalDate employeeHireDate = employee.getHireDate();
        return !startDate.isAfter(employeeHireDate);
    }

    public static boolean validateExperience(IEmployee employee, LocalDate startDate) {
        LocalDate employeeBirthDate = employee.getBirthDate();
        return !startDate.isBefore(employeeBirthDate);
    }
}
