package view;

import controller.EducationController;
import controller.EmployeeController;
import model.Education.EducationLevel;
import model.Employee.IEmployee;
import util.InputUtil;

import java.time.LocalDate;

public class EducationMenuView {
    public static void inputEducation(IEmployee employee) {
        EmployeeController.printEmployeeEducation(employee);

        EducationLevel selectedEducationLevel = null;
        while (selectedEducationLevel == null) {
            EducationLevel inputEducationLevel = InputUtil.getEducationLevel("Select Education Level (Senior High School, Bachelor, Master, PHD):");
            if (!EducationController.validateEducation(employee, inputEducationLevel)) {
                continue;
            }
            selectedEducationLevel = inputEducationLevel;
        }

        String institutionName = InputUtil.getString("Input institution name:");

        LocalDate startDate = null;
        while (startDate == null){
            LocalDate inputStartDate = InputUtil.getLocalDate("Input start sate (dd/MM/yyyy):");
            if (!EducationController.validateEducation(employee, inputStartDate)) {
                System.out.println("Start date cannot be before employee's birth date");
                continue;
            }

            if (!EducationController.validateEducation(employee, selectedEducationLevel, inputStartDate)) {
                System.out.println("Error: This education level must follow the correct hierarchy.");
                continue;
            }

            startDate = inputStartDate;
        }

        LocalDate endDate = InputUtil.getLocalDate("Input end date (dd/MM/yyyy):", startDate);

        double finalScore = InputUtil.getDouble("Input final score: ");

        EducationController.inputEducation(selectedEducationLevel, institutionName, startDate, endDate, finalScore, employee);

        String askAgain = InputUtil.getString("Do you want to add another education to this employee? (Y/N)");
        if (askAgain.equalsIgnoreCase("Y")) {
            inputEducation(employee);
        } else {
            EmployeeDetailMenuView.viewEmployeeDetailMenu(employee);
        }
    }
}
