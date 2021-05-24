package smartdietmanagement;

/**
 *
 * @author Victor Wong
 */

import java.util.Scanner;

public class Main {

	/* !!! Please do not spam the input !!! */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		boolean inMenu = true;
		int id = -1;
		String username = "", password = "";

		// Stays inside menu until QUIT command is executed
		while (inMenu) {

			while (id == -1) {
				// Login Menu interface
				Menu.menu("Login Menu");
				Menu.loginMenu();
				Menu.footer("What would you like to do?");

				String selection = input.nextLine();
				int loginProceed = Menu.parseSelection(selection);

				// Login option
				if (loginProceed == 1) {
					Menu.cls();
					int tries = 5; // attempts given to try login
					while (tries > 0) {
						Menu.menu("Logging In");
						System.out.println("\nWhat is your username?");
						username = input.nextLine();
						System.out.println("\nWhat is your password?");
						password = input.nextLine();
						Menu.print("\n");
						Account account = new Account(username, password);
						id = account.validation(); // validates entered username and password
						if (id != -1) {
							Menu.footer("Login success!");
							Menu.cls();
							tries = -1;
							break;
						}
						tries--;
						Menu.footer("Invalid credentials! " + tries + " attempts left!");
						Menu.wait(500);
						Menu.cls();
					}
					if (tries == 0) {
						Menu.menu("Login Menu");
						System.out.println("\nYou have used all 5 attempts!\n\nPress ENTER to return\n\n");
						input.nextLine();
						Menu.cls();
					}

					// Register Option
				} else if (loginProceed == 2) {

					boolean validUsername = false, validPassword = false;

					while (!validUsername) {

						Menu.cls();
						Menu.menu("Register an account");
						System.out.println("Enter your Username (At least 4 characters): ");
						username = input.nextLine();
						validUsername = Account.validity(username, "username");
						if (validUsername) {
							while (!validPassword) {
								System.out.println("Enter your Password (At least 6 characters): ");
								password = input.nextLine();
								if (Account.validity(password, "password")) {
									validPassword = true;
								} else {
									Menu.print("Invalid format!\n\n");
								}
							}
						} else {
							Menu.print("Invalid format!\nPress ENTER to try again!");
							input.nextLine();
						}

						Menu.print("\n");

						Account account = new Account(username, password);
						id = account.register(username, password);
					}
					Menu.footer("Account registered!");
					Menu.print("\n\nPress ENTER to continue\n");
					input.nextLine();
					Menu.cls();

					// login as Guest
				} else if (loginProceed == 3) {
					Menu.cls();
					Menu.menu("Login Menu");
					Menu.print("\nLogged in with Guest account!");
					Menu.footer("");
					Menu.print("\n\nPress ENTER to continue");
					input.nextLine();
					Menu.cls();
					id = 4;

				} else {
					System.out.println("Invalid selection!\nPress ENTER to continue");
					input.nextLine();
					Menu.cls();
				}

			}

			Menu.menu("Main Menu");
			Menu.mainMenu();
			Menu.footer("What would you like to do?");

			String selection = input.nextLine();
			int menuProceed = Menu.parseSelection(selection);

			switch (menuProceed) {
				case 1:
					// Profile Data
					break;
				case 2:
					// Fitness
					break;
				case 3:
					// Diet
					break;
				case 4:
					// Food Intake
					break;
				case 5:
					// Exit
					input.close();
					Menu.cls();
					Menu.print("\t\t\n\nGoodbye!");
					Menu.wait(2000);
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Selection!\nPress ENTER to continue");
					input.nextLine();
					Menu.cls();
			}

			input.close();
		}
	}
}