package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Menu {

    public static LocalDate date = LocalDate.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String formattedDate = date.format(formatter);

    public static String time;

    public static String mainOpt[] = { "Profile Data", "Fitness", "Diet", "Food Intake", "Exit" };

    public static void menu(String header) {
        for (int i = 0; i < 40; ++i) {
            System.out.print("#");
        }
        System.out.printf("%n%n%-20s%20s%n%n", header, formattedDate);
        for (int i = 0; i < 40; ++i) {
            System.out.print("#");
        }
        System.out.print("\n\n");
    }

    public static void footer() {
        for (int i = 0; i < 40; ++i) {
            System.out.print("#");
        }
    }

    public static void mainMenu() {
        for (int j = 1; j <= mainOpt.length; ++j) {
            System.out.printf("%-15d%-25s%n%n", j, mainOpt[j - 1]);
        }
    }

}