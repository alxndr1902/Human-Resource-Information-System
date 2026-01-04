package view;

import util.InputUtil;

public class MainView {
    private final EmployeeView employeeView;

    public MainView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public void show() {
        System.out.println("""
                === HRIS ===
                1. View All Employees
                2. Exit Application
                """);

        String userChoice = InputUtil.scanString("Select Menu: ");

        switch (userChoice) {
            case "1" -> employeeView.show(this::show);
            case "2" -> System.out.println("Good bye!");
            default -> {
                System.out.println("Must input 1-2 only.");
                this.show();
            }
        }
    }
}
