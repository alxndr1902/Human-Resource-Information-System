package util;

import model.Education.EducationLevel;
import model.Competency.ProficiencyType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    private InputUtil() {}

    public static String getString(String message) {
        System.out.println(message);
        return scanner.nextLine().trim();
    }

    public static int getInt(String message) {
        while (true) {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer, try again.");
            }
        }
    }

    public static double getDouble(String message) {
        while (true) {
            System.out.println(message);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input must be decimal, try again.");
            }
        }
    }

    public static LocalDate getLocalDate(String message) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.println(message);
            try {
                return LocalDate.parse(scanner.nextLine().trim(), dateFormat);
            } catch (DateTimeParseException e) {
                System.out.println("Date input does not match (dd/MM/yyyy) format, please try again.");
            }
        }
    }

    public static LocalDate getLocalDate(String message, LocalDate startDate) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate endDate;
        while (true) {
            System.out.println(message);
            try {
                LocalDate inputEndDate = LocalDate.parse(scanner.nextLine().trim(), dateFormat);
                if (inputEndDate.isBefore(startDate)) {
                    System.out.println("End date cannot be before start date");
                    continue;
                }
                endDate = inputEndDate;
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Date input does not match (dd/MM/yyyy) format, please try again.");
            }
        }
        return endDate;
    }

    public static EducationLevel getEducationLevel(String message) {
        EducationLevel selectedEducationLevel = null;

        while (selectedEducationLevel == null){
            System.out.println(message);
            String inputEducationLevel = scanner.nextLine().trim();
            if (inputEducationLevel.equalsIgnoreCase("Senior High School")) {
                selectedEducationLevel = EducationLevel.SHS;
            } else if (inputEducationLevel.equalsIgnoreCase("Bachelor")) {
                selectedEducationLevel = EducationLevel.BCH;
            } else if (inputEducationLevel.equalsIgnoreCase("Master")) {
                selectedEducationLevel = EducationLevel.MST;
            } else if (inputEducationLevel.equalsIgnoreCase("PHD")) {
                selectedEducationLevel = EducationLevel.PHD;
            } else {
                System.out.println("Invalid input");
            }
        }

        return selectedEducationLevel;
    }

    public static ProficiencyType getProficiencyType(String message) {
        System.out.println(message);
        ProficiencyType selectedProficiencyType = null;
        String inputProficiencyType = scanner.nextLine().trim().toLowerCase();
        switch (inputProficiencyType) {
            case "technical" -> {
                selectedProficiencyType = ProficiencyType.TECHNICAL;
            }
            case "program" -> {
                selectedProficiencyType = ProficiencyType.PROGRAM;
            }
            case "accountant" -> {
                selectedProficiencyType = ProficiencyType.ACCOUNTANT;
            }
            case "engineer" -> {
                selectedProficiencyType = ProficiencyType.ENGINEER;
            }
            case "analyst" -> {
                selectedProficiencyType = ProficiencyType.ANALYST;
            }
        }
        return selectedProficiencyType;
    }

    public static int getProficiencyLevel(String message) {
        int selectedProficiencyLevel = 0;
        while (true) {
            System.out.println(message);
            try {
                int inputProficiencyLevel = Integer.parseInt(scanner.nextLine().trim());
                if (inputProficiencyLevel < 0 || inputProficiencyLevel > 100) {
                    System.out.println("Proficiency level must be in between 0 and 100");
                    continue;
                }
                selectedProficiencyLevel = inputProficiencyLevel;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be integer, try again.");
            }
        }
        return selectedProficiencyLevel;
    }
}
