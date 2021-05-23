/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartdietmanagement;

// import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author William Tan Yee Song
 */

public class Diet {

    public String dietPlan;

    public String dietgoal(int currentDiet) {

        switch (currentDiet) {
            case 1:
                dietPlan = "maintain";
                return ("You have chosen to " + dietPlan + " weight.");
            case 2:
                dietPlan = "gain";
                return ("You have chosen to " + dietPlan + " weight.");
            case 3:
                dietPlan = "lose";
                return ("You have chosen to " + dietPlan + " weight.");
            default:
                dietPlan = "maintain";
                return ("Invalid diet plan.");
        }
    }

    public void recipe(int allowRecipe, int currentDiet) {

        int randRec = new Random().nextInt(3) + 1;

        if ((allowRecipe == 1) & (currentDiet == 1)) {
            // recipe = "Weight Maintain";
            switch (randRec) {
                case 1:
                    try {
                        File myObj = new File("../recipes/maintainRecipe1.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        File myObj = new File("../recipes/maintainRecipe2.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        File myObj = new File("../recipes/maintainRecipe3.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
            }

        } else if ((allowRecipe == 1) & (currentDiet == 2)) {
            // recipe = "Weight Gain";
            switch (randRec) {
                case 1:
                    try {
                        File myObj = new File("../recipes/gainRecipe1.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        File myObj = new File("../recipes/gainRecipe2.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        File myObj = new File("../recipes/gainRecipe3.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
            }

        } else if ((allowRecipe == 1) & (currentDiet == 3)) {
            // recipe = "Weight loss";
            switch (randRec) {
                case 1:
                    try {
                        File myObj = new File("../recipes/lossRecipe1.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        File myObj = new File("../recipes/lossRecipe2.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
                default:
                    try {
                        File myObj = new File("../recipes/lossRecipe3.txt");
                        Scanner myReader = new Scanner(myObj);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    break;
            }

        }

        else {
            // recipe = "Weight Gain";
            System.out.println("Thank you for your usage");
        }

    }
}

/*
 * 
 * public static void main(String[] args) {
 * 
 * Scanner keyboard = new Scanner(System.in);
 * 
 * Diet dietClass = new Diet();
 * 
 * System.out.print("1: maintain weight\n");
 * 
 * System.out.print("2: gain weight\n");
 * 
 * System.out.print("3: lose weight\n");
 * 
 * System.out.print("Enter a goal:\n");
 * 
 * int currentDiet = keyboard.nextInt();
 * 
 * String test = dietClass.dietgoal(currentDiet); System.out.print(test);
 * 
 * System.out.print("Do you want recipe recomendations(1=yes,0=no)\n"); int
 * allowRecipe = keyboard.nextInt();
 * 
 * dietClass.recipe(allowRecipe, currentDiet); }
 * 
 */