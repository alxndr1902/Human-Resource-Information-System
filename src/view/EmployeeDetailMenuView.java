package view;

import controller.EmployeeController;
import model.Employee.IEmployee;
import util.InputUtil;

public class EmployeeDetailMenuView {
    public static void viewEmployeeDetailMenu(IEmployee selectedEmployee) {
        EmployeeController.printEmployeeDetail(selectedEmployee);
        System.out.println("Select one menu below:");
        System.out.println("1. Input new employee's education");
        System.out.println("2. Input new employee's experience");
        System.out.println("3. Input new employee's competency");
        System.out.println("4. View CV");
        System.out.println("5. Back");
        String userChoice = InputUtil.getString("Select menu:");
        switch (userChoice) {
            case "1" -> EducationMenuView.inputEducation(selectedEmployee);
            case "2" -> ExperienceMenuView.inputExperience(selectedEmployee);
            case "3" -> CompetencyMenuView.inputCompetency(selectedEmployee);
            case "4" -> {
                EmployeeController.printEmployeeCV(selectedEmployee);
                EmployeeDetailMenuView.viewEmployeeDetailMenu(selectedEmployee);
            }
            case "5" -> {
                EmployeeMenuView.viewAllEmployeesMenu();
            }
            default -> {
                System.out.println("Must input 1-4 only.");
                EmployeeMenuView.viewAllEmployeesMenu();
            }
        }
    }
}
