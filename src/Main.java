import service.CompetencyService;
import service.EducationService;
import service.EmployeeService;
import service.ExperienceService;
import service.impl.CompetencyServiceImpl;
import service.impl.EducationServiceImpl;
import service.impl.EmployeeServiceImpl;
import service.impl.ExperienceServiceImpl;
import view.EmployeeView;
import view.MainView;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        ExperienceService experienceService = new ExperienceServiceImpl();
        EducationService educationService = new EducationServiceImpl();
        CompetencyService competencyService = new CompetencyServiceImpl();

        EmployeeView employeeView = new EmployeeView(employeeService, experienceService, educationService, competencyService);

        new MainView(employeeView).show();
    }
}