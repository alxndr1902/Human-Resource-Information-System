package view;

import listener.OnBackListener;
import model.Competency.Competency;
import model.Competency.ProficiencyType;
import model.Education.Education;
import model.Education.EducationLevel;
import model.Employee.Employee;
import model.Experience.Experience;
import service.CompetencyService;
import service.EducationService;
import service.EmployeeService;
import service.ExperienceService;
import service.impl.EmployeeServiceImpl;
import util.InputUtil;

import java.time.LocalDate;
import java.util.List;

public class EmployeeView {
    private final EmployeeService employeeService;
    private final ExperienceService experienceService;
    private final EducationService educationService;
    private final CompetencyService competencyService;

    private OnBackListener globalListener;

    public EmployeeView(EmployeeService employeeService, ExperienceService experienceService, EducationService educationService, CompetencyService competencyService) {
        this.employeeService = employeeService;
        this.experienceService = experienceService;
        this.educationService = educationService;
        this.competencyService = competencyService;
    }

    void show(OnBackListener listener) {
        this.globalListener = listener;
        List<Employee> employees = employeeService.getAllEmployees();

        printAllEmployees(employees);
        System.out.println("0. Back");

        Employee selectedEmployee = employees.get(InputUtil.scanInt("Select Employee: ", 1, employees.size()) - 1);

        employeeDetailMenu(selectedEmployee);

        listener.onBackListener();
    }

    private void employeeDetailMenu(Employee selectedEmployee) {
        printEmployeeDetails(selectedEmployee);
        System.out.println("""
                \n1. Input new Experience
                2. Input new Education
                3. Input new Competency
                4. View CV
                5. Back
                """);
        int choice = InputUtil.scanInt("Choose menu (1-5): ", 1, 5);
        if (choice == 1) {
            inputExperience(selectedEmployee);
        } else if (choice == 2) {
            inputEducation(selectedEmployee);
        } else if (choice == 3) {
            inputCompetency(selectedEmployee);
        } else if (choice == 4) {
            viewCv(selectedEmployee);
        } else if (choice == 5) {
            show(globalListener);
        }
    }

    private void inputExperience(Employee selectedEmployee) {
        printEmployeeExperience(selectedEmployee);

        String jobTitle = InputUtil.scanString("Input Job Title: ");
        String position = InputUtil.scanString("Input Position: ");
        String companyName = InputUtil.scanString("Input Company Name: ");

        LocalDate startDate = InputUtil.scanLocalDate("Input Start Date (dd/MM/yyyy): ");
        LocalDate endDate = InputUtil.scanLocalDate("Input End Date (dd/MM/yyyy): ", startDate);

        if (!experienceService.addNewExperience(jobTitle, position, companyName, startDate, endDate, selectedEmployee)) {
            System.out.println("Error adding experience");
            inputExperience(selectedEmployee);
        }
        show(globalListener);
    }

    private void inputEducation(Employee selectedEmployee) {
        printEmployeeEducations(selectedEmployee);

        List<EducationLevel> educationLevels = educationService.getEducationLevels();
        printEducationLevels(educationLevels);
        EducationLevel selectedEducationLevel = educationLevels.get(InputUtil.scanInt(
                "Select Education Level: ", 1, educationLevels.size()) -1);

        String institutionName = InputUtil.scanString("Input Institution Name: ");

        LocalDate startDate = InputUtil.scanLocalDate("Input Start Date (dd/MM/yyyy): ");

        LocalDate endDate = InputUtil.scanLocalDate("Input End Date (dd/MM/yyyy): ", startDate);

        double finalScore = InputUtil.scanDouble("Input Final Score: ");

        if (!educationService.addEducation(selectedEducationLevel, institutionName, startDate, endDate,
                finalScore, selectedEmployee)) {
            System.out.println("Error adding education");
            inputEducation(selectedEmployee);
        }
        show(globalListener);
    }

    private void inputCompetency(Employee selectedEmployee) {
        printEmployeeCompentencies(selectedEmployee);

        String name = InputUtil.scanString("Input Competency's Name: ");

        List<ProficiencyType> proficiencyTypes = competencyService.getProficiencyTypes();
        printProficiencyTypes(proficiencyTypes);
        ProficiencyType selectedProficiencyType = proficiencyTypes.get(
                InputUtil.scanInt("Select Proficiency Type: ", 1, proficiencyTypes.size()) -1);

        int proficiencyLevel = InputUtil.scanInt("Input Proficiency Level (1-100): ", 1, 100);

        if (!competencyService.addCompetency(name, selectedProficiencyType, proficiencyLevel, selectedEmployee)) {
            System.out.println("Error adding competency");
            inputCompetency(selectedEmployee);
        }
        show(globalListener);
    }

    private void viewCv(Employee selectedEmployee) {
        System.out.println("First Name: "   + selectedEmployee.getFirstName());
        System.out.println("Last Name: " + selectedEmployee.getLastName());
        System.out.println("Gender: " +  selectedEmployee.getGender());
        System.out.println("Birth Date: " + selectedEmployee.getBirthPlace() + ", " +  selectedEmployee.getBirthDate());
        System.out.println("ID Card Number: " + selectedEmployee.getIdCardNumber());
        System.out.println("Hire Date: "  + selectedEmployee.getHireDate());
        printEmployeeExperience(selectedEmployee);
        printEmployeeEducations(selectedEmployee);
        printEmployeeCompentencies(selectedEmployee);
        employeeDetailMenu(selectedEmployee);
    }

    private void printEducationLevels(List<EducationLevel> educationLevels) {
        for (int i = 0; i < educationLevels.size(); i++) {
            System.out.println((i + 1) + ". " +  educationLevels.get(i).getDescription());
        }
    }

    private void printProficiencyTypes(List<ProficiencyType>  proficiencyTypes) {
        for (int i = 0; i < proficiencyTypes.size(); i++) {
            System.out.println((i + 1) + ". " + proficiencyTypes.get(i).name());
        }
    }

    private void printAllEmployees(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". " + employees.get(i).getFirstName() + " " + employees.get(i).getLastName() +
                    ", Gender: " + employees.get(i).getGender());
        }
    }

    private void printEmployeeDetails(Employee selectedEmployee) {
        System.out.println("Full Name: "   + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName());
        System.out.println("Gender: " +  selectedEmployee.getGender());
        System.out.println("Hire Date: "  + selectedEmployee.getHireDate());
        printEmployeeExperience(selectedEmployee);
        printEmployeeEducations(selectedEmployee);
    }

    private void printEmployeeEducations(Employee selectedEmployee) {
        List<Education> educations = selectedEmployee.getEducations();
        System.out.println("Employee Educations:" );
        if (educations.isEmpty()) {
            System.out.println("No Educations");
            return;
        }
        for (int i = 0; i < educations.size(); i++) {
            System.out.println((i + 1) + ". " + educations.get(i).getEducationLevel().getDescription() +
                    ", Final Score: " + educations.get(i).getFinalScore());
        }
    }

    private void printEmployeeCompentencies(Employee selectedEmployee) {
        List<Competency> competencies = selectedEmployee.getCompetencies();
        System.out.println("Employee Competencies:" );
        if (competencies.isEmpty()) {
            System.out.println("No Competencies");
            return;
        }
        for (int i = 0; i < competencies.size(); i++) {
            System.out.println((i + 1) + ". " + competencies.get(i).getName() +
                    ", Type: " + competencies.get(i).getProficiencyType().name() +
                    ", Level: " + competencies.get(i).getProficiencyLevel());
        }
    }

    private void printEmployeeExperience(Employee selectedEmployee) {
        List<Experience> experiences =  selectedEmployee.getExperiences();
        System.out.println("Employee Experience:" );
        if (experiences.isEmpty()) {
            System.out.println("No Experiences");
            return;
        }
        for (int i = 0; i < experiences.size(); i++) {
            System.out.println((i + 1) + ". " + experiences.get(i).getCompanyName() +
                    " - " + experiences.get(i).getPosition() +
                    "(" + experiences.get(i).getStartDate() +
                    " - " + experiences.get(i).getEndDate() + ")");
        }
    }
}
