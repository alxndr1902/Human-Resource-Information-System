package controller;

import model.Competency.ICompetency;
import model.Education.IEducation;
import model.Employee.*;
import model.Experience.IExperience;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

public class EmployeeController {
    protected static final TreeMap<Integer, IEmployee> employees = new TreeMap<>();
    public static void initData() {
        IEmployee amos = new Employee(1, "Amos", "Pike",
                'M', LocalDate.of(1991, 2, 12),
                "Kokomo", "9187439271", LocalDate.of(2018, 11, 1)
        );
        employees.put(1, amos);

        IEmployee brenda = new Employee(2, "Brenda", "Cavin",
                'F', LocalDate.of(1951, 11, 28),
                "New York", "8231749873", LocalDate.of(2018, 11, 4)
        );
        employees.put(2, brenda);

        IEmployee billy = new Employee(3, "Billy", "Smith",
                'M', LocalDate.of(1966, 7, 18),
                "Red Mond", "1234913279 ", LocalDate.of(2018, 10, 10)
        );
        employees.put(3, billy);

        IEmployee joseph = new Employee(4, "Joseph", "Barnes",
                'M', LocalDate.of(1991, 1, 1),
                "New York", "1793741932", LocalDate.of(2018, 11, 4)
        );
        employees.put(4, joseph);

        IEmployee eloise = new Employee(5, "Eloise", "Stites",
                'F', LocalDate.of(1941, 7, 14),
                "Southfield", "2779348728", LocalDate.of(2018, 11, 1)
        );
        employees.put(5, eloise);

        IEmployee allie = new Employee(6, "Allie", "Gordon",
                'F', LocalDate.of(1974, 2, 12),
                "Southfield", "8934712934", LocalDate.of(2018, 11, 4)
        );
        employees.put(6, allie);

        IEmployee cynthia = new Employee(7, "Cynthia", "Thompson",
                'F', LocalDate.of(1987, 11, 22),
                "Chandler", "8927347778", LocalDate.of(2018, 11, 1)
        );
        employees.put(7, cynthia);
    }

    public static void printEmployees() {
        for (IEmployee employees : employees.values()) {
            employees.printEmployee();
        }
    }

    public static void printEmployeeDetail(IEmployee employee) {
        System.out.println("================================================");
        employee.printEmployeeDetail();
        System.out.println("================================================");
    }

    public static void printEmployeeEducation(IEmployee employee) {
        System.out.println("================================================");
        employee.printEmployeeDetail();
        System.out.println("Employee's education:");
        List<IEducation> educations = employee.getEducations();
        if (educations == null || educations.isEmpty()) {
            System.out.println("No education history");
        } else {
            for (IEducation education : educations) {
                education.printEducation();
            }
        }
        System.out.println("================================================");
    }

    public static void printEmployeeExperience(IEmployee employee) {
        System.out.println("================================================");
        employee.printEmployeeDetail();
        System.out.println("Employee's experience:");
        List<IExperience> experiences = employee.getExperiences();
        if (experiences == null || experiences.isEmpty()) {
            System.out.println("No experience history");
        } else {
            for (IExperience experience : employee.getExperiences()) {
                experience.printExperience();
            }
        }

        System.out.println("================================================");
    }

    public static void printEmployeeCompetency(IEmployee employee) {
        System.out.println("================================================");
        employee.printEmployeeDetail();
        System.out.println("Employee's competency:");
        List<ICompetency> competencies = employee.getCompetencies();
        if (competencies == null || competencies.isEmpty()) {
            System.out.println("No competency history");
        } else {
            for (ICompetency competency: employee.getCompetencies()) {
                competency.printCompetency();
            }
        }
        System.out.println("================================================");
    }

    public static void printEmployeeCV(IEmployee employee) {
        System.out.println("================================================");
        employee.printEmployeeDetail();
        System.out.println("================================================");

        System.out.println("Employee's experience:");
        List<IExperience> experiences = employee.getExperiences();
        if (experiences == null || experiences.isEmpty()) {
            System.out.println("No experience history");
        } else {
            for (IExperience experience : employee.getExperiences()) {
                experience.printExperience();
            }
        }
        System.out.println("================================================");

        System.out.println("Employee's competency:");
        List<ICompetency> competencies = employee.getCompetencies();
        if (competencies == null || competencies.isEmpty()) {
            System.out.println("No competency history");
        } else {
            for (ICompetency competency: employee.getCompetencies()) {
                competency.printCompetency();
            }
        }
        System.out.println("================================================");

        System.out.println("Employee's education:");
        List<IEducation> educations = employee.getEducations();
        if (educations == null || educations.isEmpty()) {
            System.out.println("No education History");
        } else {
            for (IEducation education : educations) {
                education.printEducation();
            }
        }
        System.out.println("================================================\n");

    }

    public static IEmployee validateEmployeeId(int selectedEmployeeId) {
        IEmployee selectedEmployee = null;
        for (IEmployee employee : employees.values()) {
            if (employee.getEmployeeId() == selectedEmployeeId) {
                selectedEmployee = employee;
                break;
            }
        }
        if (selectedEmployee == null) {
            System.out.printf("Employee with Id %d not found\n", selectedEmployeeId);
        }
        return selectedEmployee;
    }
}
