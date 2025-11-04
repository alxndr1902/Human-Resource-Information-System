package view;

import controller.EmployeeController;
import controller.ExperienceController;
import model.Employee.IEmployee;
import util.InputUtil;

import java.time.LocalDate;

public class ExperienceMenuView {
    public static void inputExperience(IEmployee employee) {
        EmployeeController.printEmployeeExperience(employee);

        String jobTitle = InputUtil.getString("Input job title:");

        String position = InputUtil.getString("Input position");

        String companyName = InputUtil.getString("Input company name:");

        LocalDate startDate = null;
        while (startDate == null) {
            LocalDate inputStartDate = InputUtil.getLocalDate("Input start date (dd/MM/yyyy):");
            if (!ExperienceController.validateExperience(inputStartDate, employee)) {
                System.out.println("Start date cannot be after employee's hire date");
                continue;
            }

            if (!ExperienceController.validateExperience(employee, inputStartDate)) {
                System.out.println("Start date cannot be before employee's birth date");
                continue;
            }
            startDate = inputStartDate;
        }

        LocalDate endDate = InputUtil.getLocalDate("Input end date (dd/MM/yyyy):", startDate);

        ExperienceController.inputExperience(jobTitle, position, companyName, startDate, endDate, employee);

        String askAgain = InputUtil.getString("Do you want to add another experience to this employee? (Y/N)");
        if (askAgain.equalsIgnoreCase("Y")) {
            inputExperience(employee);
        } else {
            EmployeeDetailMenuView.viewEmployeeDetailMenu(employee);
        }
    }
}
