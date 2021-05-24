package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

// import java.util.Scanner;

public class Menu {

    public static LocalDateTime date = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static String formattedDate = date.format(formatter);

    public static String time;

    public static String mainOpt[] = { "Profile Data", "Fitness", "Diet", "Food Intake", "Exit" };

    public static void print(String text) {
        System.out.print(text);
    }

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

    public static void loginMenu() {
        System.out.printf("%-25s%-35s%n%n", "[1]", "Login");
        System.out.printf("%-25s%-35s%n%n", "[2]", "Register");
        System.out.printf("%-25s%-35s%n%n", "[3]", "Login as Guest");
    }

    public static int parseSelection(String selection) {
        try {
            int number =  Integer.parseInt(selection);
            return number;
        } catch (Exception e) {
            return -1;
        } 
    }

    /*
    public static int logginIn() {

        Scanner input = new Scanner(System.in);
        System.out.println("What is your username?");
        String username = input.nextLine();
        System.out.println("What is your password?");
        String password = input.nextLine();
        Account account = new Account(username, password);
        int id = account.validation();
        if (id != -1) {
            input.close();
            return id;
        }
        input.close();
        return -1;
    }
    */

    public static void mainMenu() {
        String no;
        for (int j = 1; j <= mainOpt.length; ++j) {
            no = "[" + j + "]";
            System.out.printf("%-25s%-35s%n%n", no, mainOpt[j - 1]);
        }
    }

}