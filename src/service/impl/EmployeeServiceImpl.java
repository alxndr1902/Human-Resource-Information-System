package service.impl;

import model.Employee.*;
import service.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = initData();

    private List<Employee> initData() {
        Employee amos = new Employee(1, "Amos", "Pike",
                'M', LocalDate.of(1991, 2, 12),
                "Kokomo", "9187439271", LocalDate.of(2018, 11, 1),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Employee brenda = new Employee(2, "Brenda", "Cavin",
                'F', LocalDate.of(1951, 11, 28),
                "New York", "8231749873", LocalDate.of(2018, 11, 4),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Employee billy = new Employee(3, "Billy", "Smith",
                'M', LocalDate.of(1966, 7, 18),
                "Red Mond", "1234913279 ", LocalDate.of(2018, 10, 10),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Employee joseph = new Employee(4, "Joseph", "Barnes",
                'M', LocalDate.of(1991, 1, 1),
                "New York", "1793741932", LocalDate.of(2018, 11, 4),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Employee eloise = new Employee(5, "Eloise", "Stites",
                'F', LocalDate.of(1941, 7, 14),
                "Southfield", "2779348728", LocalDate.of(2018, 11, 1),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Employee allie = new Employee(6, "Allie", "Gordon",
                'F', LocalDate.of(1974, 2, 12),
                "Southfield", "8934712934", LocalDate.of(2018, 11, 4),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        Employee cynthia = new Employee(7, "Cynthia", "Thompson",
                'F', LocalDate.of(1987, 11, 22),
                "Chandler", "8927347778", LocalDate.of(2018, 11, 1),
                new ArrayList<>(), new ArrayList<>(), new ArrayList<>()
        );

        return List.of(amos, brenda, billy, joseph, eloise, allie, cynthia);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
