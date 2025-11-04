package model.Competency;

import model.Employee.IEmployee;

public class Competency implements ICompetency{
    protected int competencyId;
    protected String name;
    protected ProficiencyType type;
    protected int proficiencyLevel;
    protected IEmployee employees;

    public Competency(int competencyId, String name, ProficiencyType type, int proficiencyLevel, IEmployee employees) {
        this.competencyId = competencyId;
        this.name = name;
        this.type = type;
        this.proficiencyLevel = proficiencyLevel;
        this.employees = employees;
    }

    public void printCompetency() {
        System.out.printf("Competency name:%s, Proficiency type: %s, Level: %d\n",
                this.name, this.type, this.proficiencyLevel
        );
    }
}
