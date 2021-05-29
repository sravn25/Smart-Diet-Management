/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartdietmanagement;

// import java.io.FileReader;
// import java.io.File;
// import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import java.io.InputStream;

/**
 *
 * @author William Tan Yee Song
 */

public class Diet {

    public int dietPlan;

    /*
     * public String dietgoal(int currentDiet) {
     * 
     * switch (currentDiet) { case 1: dietPlan = "maintain"; return
     * ("You have chosen to " + dietPlan + " weight."); case 2: dietPlan = "gain";
     * return ("You have chosen to " + dietPlan + " weight."); case 3: dietPlan =
     * "lose"; return ("You have chosen to " + dietPlan + " weight."); default:
     * dietPlan = "maintain"; return ("Invalid diet plan."); } }
     */

    public int dietGoal(String dietgoal) {

        switch (dietgoal) {
            case "maintain":
                dietPlan = 1;
                break;
            case "gain":
                dietPlan = 2;
                break;
            case "lose":
                dietPlan = 3;
                break;
            default:
                dietPlan = 0;
        }
        return dietPlan;

    }

    public void recipe(int currentDiet) {

        int randRec = new Random().nextInt(3) + 1;

        if (currentDiet == 1) {
            // recipe = "Weight Maintain";
            switch (randRec) {
                case 1:
                    // try {
                    InputStream maintain1 = getClass().getResourceAsStream("/recipes/maintainRecipe1.txt");
                    Scanner maintainReader1 = new Scanner(maintain1);
                    while (maintainReader1.hasNextLine()) {
                        String data = maintainReader1.nextLine();
                        System.out.println(data);
                    }
                    maintainReader1.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
                case 2:
                    // try {
                    InputStream maintain2 = getClass().getResourceAsStream("/recipes/maintainRecipe2.txt");
                    Scanner maintainReader2 = new Scanner(maintain2);
                    while (maintainReader2.hasNextLine()) {
                        String data = maintainReader2.nextLine();
                        System.out.println(data);
                    }
                    maintainReader2.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
                default:
                    // try {
                    InputStream maintain3 = getClass().getResourceAsStream("/recipes/maintainRecipe3.txt");
                    Scanner maintainReader3 = new Scanner(maintain3);
                    while (maintainReader3.hasNextLine()) {
                        String data = maintainReader3.nextLine();
                        System.out.println(data);
                    }
                    maintainReader3.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
            }

        } else if (currentDiet == 2) {
            // recipe = "Weight Gain";
            switch (randRec) {
                case 1:
                    // try {
                    InputStream gain1 = getClass().getResourceAsStream("/recipes/gainRecipe1.txt");
                    Scanner gainReader1 = new Scanner(gain1);
                    while (gainReader1.hasNextLine()) {
                        String data = gainReader1.nextLine();
                        System.out.println(data);
                    }
                    gainReader1.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
                case 2:
                    // try {
                    InputStream gain2 = getClass().getResourceAsStream("/recipes/gainRecipe2.txt");
                    Scanner gainReader2 = new Scanner(gain2);
                    while (gainReader2.hasNextLine()) {
                        String data = gainReader2.nextLine();
                        System.out.println(data);
                    }
                    gainReader2.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
                default:
                    // try {
                    InputStream gain3 = getClass().getResourceAsStream("/recipes/gainRecipe3.txt");
                    Scanner gainReader3 = new Scanner(gain3);
                    while (gainReader3.hasNextLine()) {
                        String data = gainReader3.nextLine();
                        System.out.println(data);
                    }
                    gainReader3.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
            }

        } else if (currentDiet == 3) {
            // recipe = "Weight loss";
            switch (randRec) {
                case 1:
                    // try {
                    // File myObj = new File("src/recipes/lossRecipe1.txt");
                    InputStream lose1 = getClass().getResourceAsStream("/recipes/lossRecipe1.txt");
                    Scanner loseReader1 = new Scanner(lose1);
                    while (loseReader1.hasNextLine()) {
                        String data = loseReader1.nextLine();
                        System.out.println(data);
                    }
                    loseReader1.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
                case 2:
                    // try {
                    // File myObj = new File("src/recipes/lossRecipe2.txt");
                    InputStream lose2 = getClass().getResourceAsStream("/recipes/lossRecipe2.txt");
                    Scanner loseReader2 = new Scanner(lose2);
                    while (loseReader2.hasNextLine()) {
                        String data = loseReader2.nextLine();
                        System.out.println(data);
                    }
                    loseReader2.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
                    break;
                default:
                    // try {
                    // File myObj = new File("src/recipes/lossRecipe3.txt");
                    InputStream lose3 = getClass().getResourceAsStream("/recipes/lossRecipe3.txt");
                    Scanner loseReader3 = new Scanner(lose3);
                    while (loseReader3.hasNextLine()) {
                        String data = loseReader3.nextLine();
                        System.out.println(data);
                    }
                    loseReader3.close();
                    // } catch (FileNotFoundException e) {
                    // System.out.println("An error occurred.");
                    // e.printStackTrace();
                    // }
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