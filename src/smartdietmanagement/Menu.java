package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

public class Menu {

    public static LocalDateTime date = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String formattedDate = date.format(formatter);

    public static String time;

    public static String mainOpt[] = { "Profile Data", "Fitness", "Diet", "Food Intake", "Exit" };

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void menu(String header) {
        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.printf("%n%n%-30s%30s%n%n", header, formattedDate);
        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.print("\n\n");
    }

    public static void footer(String ques) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        time = dtf.format(now);

        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.printf("%n%n%-40s%20s%n%n", ques, time);
        for (int i = 0; i < 60; ++i) {
            System.out.print("#");
        }
        System.out.println("\n");
    }

    public static void mainMenu() {
        String no;
        for (int j = 1; j <= mainOpt.length; ++j) {
            no = "[" + j + "]";
            System.out.printf("%-25s%-35s%n%n", no, mainOpt[j - 1]);
        }
    }

}