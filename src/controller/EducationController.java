package controller;

import model.Education.Education;
import model.Education.EducationLevel;
import model.Education.IEducation;
import model.Employee.IEmployee;

import java.time.LocalDate;
import java.util.TreeMap;

public class EducationController {
    protected static final TreeMap<Integer, IEducation> educations = new TreeMap<>();

    public static void inputEducation(EducationLevel selectedEducationLevel, String institutionName, LocalDate startDate, LocalDate endDate, double finalScore, IEmployee employee) {
        int educationIdCounter = 1;
        int educationMapCounter = 1;

        IEducation newEducation = new Education(educationIdCounter++, selectedEducationLevel, institutionName,
                startDate, endDate, finalScore, employee
        );
        educations.put(educationMapCounter++, newEducation);

        employee.addEducation(newEducation);
    }

    public static boolean validateEducation(IEmployee employee, LocalDate startDate) {
        LocalDate employeeBirthDate = employee.getBirthDate();
        return !startDate.isBefore(employeeBirthDate);
    }

    public static boolean validateEducation(IEmployee employee, EducationLevel selectedEducationLevel) {
        boolean hasSHS = false;
        boolean hasBCH = false;
        boolean hasMST = false;

        for (IEducation educations : employee.getEducations()) {
            if (educations.getLevel() == EducationLevel.SHS) {
                hasSHS = true;
            } else if (educations.getLevel() == EducationLevel.BCH) {
                hasBCH = true;
            } else if (educations.getLevel() == EducationLevel.MST) {
                hasMST = true;
            }
        }

        switch (selectedEducationLevel) {
            case BCH -> {
                if (!hasSHS) {
                    System.out.println("You must input the employee's Senior High School Degree first");
                    return false;
                }
                break;
            }
            case MST -> {
                if (!hasBCH) {
                    System.out.println("You must input the employee's bachelor degree first");
                    return false;
                }
                break;
            }
            case PHD -> {
                if (!hasMST) {
                    System.out.println("You must input the employee's master degree first");
                    return false;
                }
                break;
            }
        }
        return true;
    }

    public static boolean validateEducation(IEmployee employee, EducationLevel selectedEducationLevel, LocalDate startDate) {
        for (IEducation educations : employee.getEducations()) {
            if (educations.getLevel() == EducationLevel.SHS){
                if (selectedEducationLevel == EducationLevel.BCH ||
                        selectedEducationLevel == EducationLevel.MST ||
                        selectedEducationLevel == EducationLevel.PHD) {
                    if (startDate.isBefore(educations.getEndDate())) {
                        System.out.println("This education level must be after Senior High School.");
                        return false;
                    }
                }
            }

            if (educations.getLevel() == EducationLevel.BCH) {
                if (selectedEducationLevel == EducationLevel.MST ||
                        selectedEducationLevel == EducationLevel.PHD) {
                    if (startDate.isBefore(educations.getEndDate())) {
                        System.out.println("This education level must be after Bachelor");
                        return false;
                    }
                }
            }

            if (educations.getLevel() == EducationLevel.MST) {
                if (selectedEducationLevel == EducationLevel.PHD) {
                    if (startDate.isBefore(educations.getEndDate())) {
                        System.out.println("This education level must be after Master");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
