package service.impl;

import model.Education.Education;
import model.Education.EducationLevel;
import model.Employee.Employee;
import service.EducationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EducationServiceImpl implements EducationService {
    private static final List<Education> educations = new ArrayList<>();

    private boolean validateEducation(Employee employee, EducationLevel selectedEducationLevel) {
        boolean hasSHS = false;
        boolean hasBCH = false;
        boolean hasMST = false;

        for (Education educations : employee.getEducations()) {
            if (educations.getEducationLevel().equals(EducationLevel.SHS)) {
                hasSHS = true;
            } else if (educations.getEducationLevel().equals(EducationLevel.BCH)) {
                hasBCH = true;
            } else if (educations.getEducationLevel().equals(EducationLevel.MST)) {
                hasMST = true;
            }
        }

        switch (selectedEducationLevel) {
            case BCH -> {
                if (!hasSHS) {
                    return false;
                }
            }
            case MST -> {
                if (!hasBCH) {
                    return false;
                }
            }
            case PHD -> {
                if (!hasMST) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validateEducation(Employee employee, EducationLevel selectedEducationLevel, LocalDate startDate)  {
        for (Education educations : employee.getEducations()) {
            if (educations.getEducationLevel() == EducationLevel.SHS){
                if (selectedEducationLevel == EducationLevel.BCH ||
                        selectedEducationLevel == EducationLevel.MST ||
                        selectedEducationLevel == EducationLevel.PHD) {
                    if (startDate.isBefore(educations.getEndDate())) {
                        return false;
                    }
                }
            }

            if (educations.getEducationLevel() == EducationLevel.BCH) {
                if (selectedEducationLevel == EducationLevel.MST ||
                        selectedEducationLevel == EducationLevel.PHD) {
                    if (startDate.isBefore(educations.getEndDate())) {
                        return false;
                    }
                }
            }

            if (educations.getEducationLevel() == EducationLevel.MST) {
                if (selectedEducationLevel == EducationLevel.PHD) {
                    if (startDate.isBefore(educations.getEndDate())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public List<EducationLevel> getEducationLevels() {
        return List.of(EducationLevel.PHD, EducationLevel.MST, EducationLevel.BCH, EducationLevel.SHS);
    }

    @Override
    public boolean addEducation(EducationLevel educationLevel, String institutionName, LocalDate startDate,
                                LocalDate endDate, double finalScore, Employee employee) {
        int id = 1;

        Education newEducation = new Education(id, educationLevel, institutionName, startDate, endDate, finalScore,
                    employee);

        employee.getEducations().add(newEducation);

        return educations.add(newEducation);
    }
}
