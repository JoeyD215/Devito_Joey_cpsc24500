package start.Java;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QuizApp{
	
	/**
	 * @author Joey
	 * @param sc: scanner
	 * @return: gives information back
	 * function: showMenuAndGetChoice: gives user idea of program and allows input
	 */
	public static int showMenuAndGetChoice(Scanner sc) { //user selection menu
				
		System.out.println("Here are your choices:");
		System.out.println("1. Take a quiz. ");
		System.out.println("2. See questions and answers ");
		System.out.println("3. Exit ");
		System.out.println("Enter the number of your choice: ");
		int result = sc.nextInt(); //allowing choice
		sc.nextLine();
		return result;
	}
	/**
	 * 
	 * @param choice: allows for choosing option
	 * @param path: follows through the list every line
	 * @param questions: ArrayList
	 * @param givenAnswerString: goes through every line and gives answer back as string
	 */
	
	public static void main(String[] args) {
		ArrayList<Question> questions = new ArrayList<Question>();
		Scanner sc = new Scanner(System.in);
		int choice;
		String path;	
		QuestionReader qr = new QuestionReader();
		Quizzer quiz;
		
		System.out.println("*	What could possibly be more fun than this?	*");
		System.out.println("*************************************************");
		System.out.println("*    	OOP Theory and Concept Questions   		*");
		System.out.println("*************************************************");
		System.out.println("*	Nothing. Nothing at all. Nope. Nada. Nunca.	*");
		while (true) {
			System.out.println("Enter name of file:");
			path = sc.nextLine();
			
			questions = qr.readFromJSON(path);
			if (questions == null) {
				System.out.println("could not read questions");
			}else {
				System.out.println("Read questions");

				break;
			}
		}	
		/**
		 * @param stop: when program should acknowledge when to not proceed
		 *
		 */
		do {
			choice = showMenuAndGetChoice(sc);
			if (choice == 1) {
				quiz = new Quizzer(questions);
				boolean stop = false;
				
				System.out.println("How many questions would you like? ");
				quiz.counter = Integer.parseInt(sc.nextLine());
				quiz.number = quiz.counter;
				quiz.fixAmount();
				while (true) {
				Question q = quiz.getQuestion();
				if (q == null) {
					System.out.println("You have answered " + String.valueOf(quiz.correct)+ "/" + String.valueOf(quiz.number));
					stop = true;
					break;
				}
				if (stop){
					break;
				}
				System.out.println(q.getQuestion());
				char c = 97;
				for (int i = 0; i < q.getOptions().size(); i++) {
					System.out.println(c + ". " + q.getOptions().get(i));
					c++;
				}
				String givenAnswerString = "";
				givenAnswerString = sc.nextLine();
				quiz.checkAnswer(givenAnswerString, q);
				}	
			}else if (choice == 2) {
				QuestionPrinter printer = new QuestionPrinter();
				printer.printQuestions(questions);
			}
			
		
		} while (choice != 3);
		System.out.println("Thank you.");		
	}

}
