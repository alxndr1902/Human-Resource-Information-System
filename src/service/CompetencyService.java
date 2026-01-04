package service;

import model.Competency.ProficiencyType;
import model.Employee.Employee;

import java.util.List;

public interface CompetencyService {
    boolean addCompetency(String name, ProficiencyType proficiencyType, int proficiencyLevel, Employee employee);

    List<ProficiencyType> getProficiencyTypes();
}
