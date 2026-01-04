package service.impl;

import model.Competency.Competency;
import model.Competency.ProficiencyType;
import model.Employee.Employee;
import service.CompetencyService;

import java.util.ArrayList;
import java.util.List;

public class CompetencyServiceImpl implements CompetencyService {
    private static final List<Competency> competencies = new ArrayList<>();


    @Override
    public boolean addCompetency(String name, ProficiencyType proficiencyType, int proficiencyLevel, Employee employee) {
        int id = 1;

        Competency newCompetency = new Competency(id, name, proficiencyType, proficiencyLevel, employee);
        employee.getCompetencies().add(newCompetency);
        id++;
        return competencies.add(newCompetency);
    }

    @Override
    public List<ProficiencyType> getProficiencyTypes() {
        return List.of(ProficiencyType.ACCOUNTANT, ProficiencyType.PROGRAM, ProficiencyType.ENGINEER,
                ProficiencyType.ANALYST, ProficiencyType.ANALYST);
    }
}
