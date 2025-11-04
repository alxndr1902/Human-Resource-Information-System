package view;

import controller.CompetencyController;
import controller.EmployeeController;
import model.Employee.IEmployee;
import model.Competency.ProficiencyType;
import util.InputUtil;

public class CompetencyMenuView {
    public static void inputCompetency(IEmployee employee) {
        EmployeeController.printEmployeeCompetency(employee);

        String name = InputUtil.getString("Input competency's name:");

        System.out.println("Proficiency type list:");
        System.out.println("Technical");
        System.out.println("Program");
        System.out.println("Accountant");
        System.out.println("Engineer");
        System.out.println("Analyst");
        ProficiencyType proficiencyType = InputUtil.getProficiencyType("Select proficiency Type:");

        int proficiencyLevel = InputUtil.getProficiencyLevel("Input proficiency level(0-100):");

        CompetencyController.inputCompetency(name, proficiencyType, proficiencyLevel, employee);

        String askAgain = InputUtil.getString("Do you want to add another competency to this employee? (Y/N)");
        if (askAgain.equalsIgnoreCase("Y")) {
            inputCompetency(employee);
        } else {
            EmployeeDetailMenuView.viewEmployeeDetailMenu(employee);
        }
    }
}
