package start.Java;
/**
 * Date: September 28
 * @author Joey
 * @version 1.0
 * Title: gamezone - allow user to input a number 1-3 and play the specified game or option
 */
import java.util.Random;
import java.util.Scanner;
public class gamezone {	
	public static Random rand = new Random();
	public static int printMenuAndGetChoice(Scanner sc) {
		int choice;
		do {
			try {
				System.out.println("***************************************"); //Intro
				System.out.println("*      Welcome to the Game Zone       *");
				System.out.println("***************************************");
				System.out.println("What would you like to play?");
				System.out.println("1. Twenty-one");
				System.out.println("2. Rock Paper Scissors");
				System.out.println("3. Neither - I'm done!");
				System.out.print("Please enter the number of your choice: "); //allowing user to select from menu
				choice = sc.nextInt();
				if (choice < 0 || choice > 3) { // choice must be 1 thru 3
					System.out.println("That is an invalid choice.");
				}
			} catch (Exception ex) {
				System.out.println("You must enter a number.");
				sc.nextLine(); // clears out input channel
				choice = 0;
			}
		} while (choice <= 0 || choice > 3);
		return choice;
	}
	/**
	 * Function: RPS (Rock, Paper, Scissors)
	 * Used to generate a random output of one of the 3
	 * @param user = the players random generator
	 * @param computer = the computers random generator
	 */
	public static void RPS(){ // function for rock paper scissors
		int user = rand.nextInt(3)+1;
		int computer = rand.nextInt(3)+1;// random generator to decide which of RPS is played
		System.out.println("You played" + result(user) +",and the computer played" + result(computer));
		
		if((user==2 && computer==1) || (user==3 && computer==2) || (user==1 && computer==3)){
			System.out.println("You won");
		}
		else if(user == computer) {
			System.out.println("It was a tie"); // showing results with win/loss
		}
		else {
			System.out.println("You lost");
		}
	}
	public static String result(int digit) { //function to represent the prior number as rock paper or scissors
		if(digit == 1) {
			return "Rock";
	//		System.out.println("Paper");
		}
		else if (digit == 2) {
			return "Paper";
	//		System.out.println("Rock");
		}
		return "Scissors";
	//		System.out.println("Scissors");
		/**
		 * @return
		 * this returns the result and deciding factor
		 */
	}
	/**
	 * Function: TO (Twentyone)
	 * Used to play a simple game of Twentyone
	 * @param user = starting value
	 * @param computer = starting value
	 * @param select = the character needed to proceed
	 * @param draw = randomized draw value
	 * @param computerDraw = randomized computer draw value
	 */
	public static void TO() { //Twenty one function
		int user = 0;
		int computer = 0; // assigning values
		char select = 'y';
		Scanner test = new Scanner(System.in);

		while (select == 'y' || select == 'Y') { //as long as Y is selected, it will loop
			int draw = rand.nextInt(11)+1;
			System.out.println("You draw " + draw);
			user = user + draw; //if Y is selected, these will be repeated
			System.out.println("Your current total is " + user);
			System.out.println("Do you want to draw another card?");
			select = test.next().charAt(0); //returns selection
		}
		int computerDraw = rand.nextInt(10)+12; //cpu instead of user
		computer = computer + computerDraw;
		System.out.println("Computer drew " + computer);
		if  (user == 21) {
				System.out.println("You won!");//if else statements to determine results
			}else if(user == 21 && computer == 21) {
				System.out.println("Its a tie");
			}else if (computer == 21 && user != 21) {
				System.out.println("You lose");
			}else if(user > computer) {
				System.out.println("You won");
				}else {
					System.out.println("You lose");

			}
	}
	/**
	 *
	 * @param args
	 * @param choice = used to obtain user input from menu
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Random = new Random();
		int choice;  //option select from menu
		do {
			choice = printMenuAndGetChoice(sc); //user input
			if (choice == 2) {
				RPS(); //function call
			} else if (choice == 1) {
				TO(); //function call
			}
		} while (choice != 3);
		System.out.println("Thank you for playing");
	}
}
