package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean inMenu = true;
		int login = 0, id = 0;
		String username = "", password = "";

		while (inMenu) {
			login = -1;

			while (login == -1) {
				Menu.menu("Login Menu");
				Menu.loginMenu();
				Menu.footer("Would you like to Login or Register?");

				String selection = input.nextLine();
				int loginProceed = Menu.loginSelection(selection);

				if (loginProceed == 1) {
					Menu.cls();
					int tries = 5;
					while (tries > 0) {
						Menu.menu("Logging In");
						id = Menu.logginIn();
						if (id != -1) {
							Menu.footer("Login success! Press ENTER to continue");
							Menu.cls();
							login = 1;
							tries = 0;
							break;
						}
						tries--;
						Menu.footer("Invalid credentials! " + tries + " attempts left!");
						Menu.wait(1000);
						Menu.cls();
					}
					if (tries == 0) {
						Menu.menu("Login Menu");
						System.out.println("\nYou have used all 5 attempts!\n\nPress ENTER to return\n\n");
						input.nextLine();
						Menu.cls();
					}

				} else if (loginProceed == 2) {
					login = 2;
					input.nextLine();
					Menu.cls();
					break;
				} else {
					System.out.println("Invalid selection!\nPress ENTER to continue");
					input.nextLine();
					Menu.cls();
				}

			}

			input.close();
		}
	}
}