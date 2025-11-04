package model.Education;

import java.time.LocalDate;

public interface IEducation {
    void printEducation();
    LocalDate getEndDate();
    EducationLevel getLevel();
}
