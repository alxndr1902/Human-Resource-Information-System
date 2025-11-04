package model.Education;

public enum EducationLevel {
    SHS("Senior High School"),
    BCH("Bachelor"),
    MST("Master"),
    PHD("Doctor of Philosophy");

    protected String description;

    EducationLevel(String description) {
        this.description = description;
    }
}
