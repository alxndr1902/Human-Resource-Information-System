package model.Education;

public enum EducationLevel {
    SHS("Senior High School"),
    BCH("Bachelor"),
    MST("Master"),
    PHD("Doctor of Philosophy");

    private String description;

    EducationLevel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
