package view;

import controller.EmployeeController;
import model.Employee.IEmployee;
import util.InputUtil;

public class EmployeeMenuView {
    public static void viewAllEmployeesMenu() {
        EmployeeController.printEmployees();
        System.out.println("0. Back");

        IEmployee selectedEmployee = null;
        while (selectedEmployee == null) {
            int selectedEmployeeId = InputUtil.getInt("Select one employee Id:");
            if (selectedEmployeeId == 0) {
                MainMenuView.mainMenu();
            }
            selectedEmployee = EmployeeController.validateEmployeeId(selectedEmployeeId);
        }
        EmployeeDetailMenuView.viewEmployeeDetailMenu(selectedEmployee);

    }
}
