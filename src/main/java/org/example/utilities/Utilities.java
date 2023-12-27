package org.example.utilities;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Utilities {
    public static String ValidatedUserString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input != null && !input.isEmpty()) return input;
            else System.out.println("Invalid string, please try again: ");
        }
    }
    public static int ValidatedUserInteger() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                   return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer, please try again: ");
            }
        }
    }
    public static LocalDate ValidatedUserDate() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                return LocalDate.parse(input, formatter);
            } catch (Exception e) {
                System.out.println("Invalid date, please insert date with format yyyy-mm-dd");
            }
        }
    }


}
