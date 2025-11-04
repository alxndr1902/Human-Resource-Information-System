import controller.EmployeeController;
import view.MainMenuView;

public class Main {
    public static void main(String[] args) {
        EmployeeController.initData();
        MainMenuView.mainMenu();
    }
}