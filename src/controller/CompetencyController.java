package controller;

import model.Competency.Competency;
import model.Competency.ICompetency;
import model.Employee.IEmployee;
import model.Competency.ProficiencyType;

import java.util.TreeMap;

public class CompetencyController {
    protected static final TreeMap<Integer, ICompetency> competencies = new TreeMap<>();

    public static void inputCompetency(String name, ProficiencyType proficiencyType, int proficiencyLevel, IEmployee employee) {
        int competencyIdCounter = 1;
        int competencyMapCounter = 1;
        ICompetency newCompetency = new Competency(competencyIdCounter++, name, proficiencyType,
                proficiencyLevel, employee
        );
        competencies.put(competencyMapCounter++, newCompetency);

        employee.addCompetency(newCompetency);
    }
}
