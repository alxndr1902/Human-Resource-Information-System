package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {

    public static String scanString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public static int scanInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        try {
            int value = scanner.nextInt();
            if (value < min || value > max) {
                System.out.println("Input out of range, try again.");
                return scanInt(message, min, max);
            }
            return value;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            return scanInt(message, min, max);
        }
    }

    public static double scanDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            return scanDouble(message);
        }
    }

    public static LocalDate scanLocalDate(String message) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print(message);
        try {
            return LocalDate.parse(scanner.nextLine().trim(), dateFormat);
        } catch (InputMismatchException | DateTimeParseException e) {
            System.out.println("Date input does not match (dd/MM/yyyy) format, please try again.");
            return scanLocalDate(message);
        }
    }

    public static LocalDate scanLocalDate(String message, LocalDate startDate) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print(message);
        try {
            LocalDate inputEndDate = LocalDate.parse(scanner.nextLine().trim(), dateFormat);
            if (inputEndDate.isBefore(startDate)) {
                System.out.println("End date must be after start date");
                return scanLocalDate(message, startDate);
            }
            return inputEndDate;
        } catch (InputMismatchException | DateTimeParseException e) {
            System.out.println("Date input does not match (dd/MM/yyyy) format, please try again.");
            return scanLocalDate(message);
        }
    }
}
