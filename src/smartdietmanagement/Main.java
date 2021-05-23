package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Menu.menu("Login Menu");
		Menu.mainMenu();
		Menu.footer("What would you like to do?");

		boolean inMenu = true;
		while (inMenu) {

		}

		input.close();
	}

}
