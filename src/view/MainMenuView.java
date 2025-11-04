package view;

import util.InputUtil;

public class MainMenuView {
    public static void mainMenu() {
        System.out.println("Please input one of the menu below:");
        System.out.println("1. View All Employees");
        System.out.println("2. Exit Application");

        String userChocie = InputUtil.getString("Select Menu:");

        switch (userChocie) {
            case "1" -> {
                EmployeeMenuView.viewAllEmployeesMenu();
            }
            case "2" -> {
                System.out.println("Good bye!");
            }
            default -> {
                System.out.println("Must input 1-2 only.");
                MainMenuView.mainMenu();
            }
        }
    }
}
