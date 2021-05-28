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
		Diet diet = new Diet();

		boolean inMenu = true, first = true;
		int id = -1, calories = 0;
		String username = "", password = "";
		ProfileData profile1 = new ProfileData();

		// Stays inside menu until QUIT command is executed
		while (inMenu) {

			Calories caloriesConst = new Calories(profile1.weight, profile1.height, profile1.age);

			if (id == -1) {
				profile1.setHeight(0.0);
				profile1.setWeight(0.0);
				profile1.setAge(0);
				profile1.setGoal("");
				calories = 0;
				caloriesConst.sex = 'x';
			}

			while (id == -1) {
				// Login Menu interface
				Menu.menu("Login Menu");
				Menu.mainMenu("login");
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
					Menu.print("\nLogged in with Guest account!\n\n\n");
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
			if (first) {
				Menu.cls();
				Menu.footer("Welcome " + Account.displayUser(id));
				Menu.wait(1000);
				first = false;
			}

			Menu.cls();
			Menu.menu("Main Menu");
			Menu.mainMenu("main");
			Menu.footer("What would you like to do?");

			String selection = input.nextLine();
			int menuProceed = Menu.parseSelection(selection);

			switch (menuProceed) {
				case 1:
					// Profile Data
					boolean inProfile = true;
					while (inProfile) {
						Menu.cls();
						Menu.menu("Profile Data");
						Menu.mainMenu("profile");
						Menu.footer("What would you like to do?");
						selection = input.nextLine();
						int profileProceed = Menu.parseSelection(selection);

						// display user data
						if (profileProceed == 1) {
							Menu.cls();
							Menu.menu("Display User Data");
							profile1.displayData();
							Menu.footer("Press ENTER to continue");
							input.nextLine();

							// update user data
						} else if (profileProceed == 2) {
							boolean updatingData = true;
							boolean updated = false;
							while (updatingData) {
								Menu.cls();
								Menu.menu("Update User Data");
								profile1.displayData();
								Menu.footer("Select one to update, (x) to return");
								selection = input.nextLine();
								if (selection.equalsIgnoreCase("x")) {
									updatingData = false;
									break;
								}
								int type = Menu.parseSelection(selection);
								if (type > 0 && type < 5) {
									Menu.print(type == 4 ? "Enter your goal (gain / lose / maintain): "
											: type == 3 ? "Enter your age: "
													: type == 2 ? "Enter your weight (in kg) : "
															: "Enter your height (in m): ");
									String updateValue = input.nextLine();
									updated = profile1.update(type, updateValue);
									System.out.println(updated ? "Data Updated\nPress ENTER to continue"
											: "Data Not Updated\nPress ENTER to continue");
									input.nextLine();
								} else if (type == 5) {
									Menu.print("BMI is updated automatically!\nPress ENTER to continue");
									input.nextLine();
								} else {
									Menu.print("Invalid selection!\nPress ENTER to continue");
									input.nextLine();
								}
							}

							// bmi calculator
						} else if (profileProceed == 3) {

							boolean calculateBmi = true;
							while (calculateBmi) {
								Menu.cls();
								Menu.menu("BMI Calculator");
								double bmi = profile1.BMICalc();
								System.out.printf("%-20s%-20s%-20f%n%n", "[1]", "My BMI", bmi);
								System.out.printf("%-20s%-20s%-20s%n%n", "[2]", "BMI Status", profile1.BMIScale(bmi));
								Menu.footer("[1] to calculate BMI, [2] to Return");
								selection = input.nextLine();
								int bmiProceed = Menu.parseSelection(selection);
								if (bmiProceed == 1) {

									Menu.cls();
									Menu.menu("BMI Calculator");
									double newHeight, newWeight;
									System.out.print("Enter height (in  m) to be calculated: ");
									newHeight = Double.parseDouble(input.nextLine());
									System.out.print("Enter weight (in kg) to be calculated: ");
									newWeight = Double.parseDouble(input.nextLine());
									Menu.print("\n");

									Menu.footer("BMI: " + profile1.BMICalculator(newHeight, newWeight));

									System.out.println("Press ENTER to continue");
									input.nextLine();

								} else if (bmiProceed == 2) {
									calculateBmi = false;
									break;
								} else {
									System.out.println("Invalid Selection\nPress ENTER to continue");
									input.nextLine();
								}
							}

							// logout
						} else if (profileProceed == 4) {
							id = -1;
							first = true;
							break;

						} else if (profileProceed == 5) {
							inProfile = false;
							break;
						} else {
							System.out.println("Invalid Selection\nPress ENTER to continue");
							input.nextLine();
						}

					}

					break;
				case 2:
					// Fitness

					if (profile1.weight != 0.0 && profile1.height != 0.0 && profile1.age != 0) {
						caloriesConst.updateCalories(profile1.weight, profile1.height, profile1.age);
					}

					boolean inFitness = true;
					while (inFitness) {
						Menu.cls();
						Menu.menu("Fitness");
						Menu.mainMenu("fitness");
						Menu.footer("What would you like to do?");

						selection = input.nextLine();
						int fitnessProceed = Menu.parseSelection(selection);
						switch (fitnessProceed) {
							case 1: // Calories data

								while (caloriesConst.sex == 'x') {
									Menu.cls();
									Menu.mainMenu("Survey");
									Menu.print("\nEnter [M] for Male\nEnter[F] for Female\n\n");
									Menu.footer("Are you Male or Female?");
									String sex = input.nextLine();
									boolean correctInput = caloriesConst.updateSex(sex);
									if (!correctInput) {
										System.out.println("Invalid option!\nPress ENTER to continue");
										input.nextLine();
									}
								}

								Menu.cls();
								Menu.menu("Calories Data");
								caloriesConst.displayData();
								calories = caloriesConst.bmrCalc();
								Menu.footer("Press ENTER to continue");
								input.nextLine();

								break;

							case 2: // Exercise Schedule
								Menu.cls();
								Menu.menu("Exercise Schedule");
								Exercise.exerciseSchedule();
								Menu.footer("Press ENTER to continue");
								input.nextLine();

								break;

							case 3: // Update Exercise Schedule
								boolean updatingSchedule = true;
								while (updatingSchedule) {
									Menu.cls();
									Menu.menu("Update Exercise Schedule");
									Exercise.exerciseList();
									Menu.footer("");
									System.out.print("Choose a number to edit\nEnter 'x' to return\n");
									selection = input.nextLine();
									if (selection.equalsIgnoreCase("X")) {
										updatingSchedule = false;
										break;
									}
									int dayToUpdate = Menu.parseSelection(selection);
									if (dayToUpdate > 0 && dayToUpdate < 8) {
										System.out.print("New Exercise : ");
										String newExercise = input.nextLine();
										boolean check = true;
										while (check) {
											System.out.print("\nNew Exercise's Duration (in s) : ");
											String newDuration = input.nextLine();
											if (Exercise.durationIntCheck(newDuration)) {
												Exercise.updateExercise(dayToUpdate, newExercise, newDuration);
												check = false;
											} else {
												System.out.println("Please input the duration in seconds");
											}
										}
										System.out.println("Shedule Updated!\nPress ENTER to continue");
										input.nextLine();
									} else {
										System.out.println("Invalid selection\nPress ENTER to continue");
										input.nextLine();
									}

								}

								break;

							case 4: // Start Exercising
								boolean exercising = true;
								while (exercising) {
									Menu.cls();
									Menu.menu("Time to Exercise");
									Exercise.exerciseDetail();
									Menu.footer("What would you like to do?");
									selection = input.nextLine();
									if (selection.equals("1")) {
										// For testing purposes, durations are halved
										Exercise reminder = new Exercise(Exercise.exerciseDuration());
										System.out.println("\nPress ENTER to continue");
										input.nextLine();
									} else if (selection.equals("2")) {
										exercising = false;
									} else {
										System.out.println("Invalid selection\nPress ENTER to continue");
										input.nextLine();
									}
								}

								break;

							case 5: // return
								inFitness = false;
								break;

							default:
								System.out.println("Invalid Selection\nPress ENTER to continue");
								input.nextLine();
						}
					}
					break;

				case 3:
					// Diet
					boolean inDiet = true;
					while (inDiet) {
						Menu.cls();
						Menu.menu("Diet Menu");
						Menu.mainMenu("diet");
						Menu.footer("What would you like to do");

						selection = input.nextLine();
						int dietProceed = Menu.parseSelection(selection);
						// generate recipe
						if (dietProceed == 1) {
							Menu.cls();
							System.out.print("Processing");
							for (int i = 0; i < 11; i += 2) {
								System.out.print(".");
								Menu.wait(100);
							}
							Menu.cls();
							int dietPlan = diet.dietGoal(profile1.goal);
							if (dietPlan == 0) {
								Menu.menu("Recipe");
								System.out.println("Insufficient data to generate recipe");
								System.out.println("Please update your profile data");
								Menu.footer("Press ENTER to return");
								input.nextLine();

							} else {
								Menu.menu("Recipe");
								diet.recipe(dietPlan);
								Menu.footer("Press ENTER to continue");
								input.nextLine();
							}

						} else if (dietProceed == 2) {
							inDiet = false;
						} else {
							System.out.println("Invalid selection\nPress ENTER to continue");
							input.nextLine();
						}

					}
					break;

				case 4:
					// Food Intake
					Menu.cls();
					FoodIntake.foodIntake();
					input.nextLine();
					break;

				case 5:
					// Exit
					input.close();
					Menu.exit();
					break;
				default:
					System.out.println("Invalid Selection!\nPress ENTER to continue");
					input.nextLine();
					Menu.cls();
			}

		}
		input.close();
	}
}