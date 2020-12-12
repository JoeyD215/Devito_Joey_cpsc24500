package start.Java;

import java.util.ArrayList;
/**
 * 
 * @function for displaying correct list of questions/answers
 *
 */
public class QuestionPrinter {
	public void printQuestions(ArrayList<Question> questions) {
		char c = 97;
		for (Question question : questions) {
			System.out.println(question.getQuestion());		
			for (int i = 0; i < question.getOptions().size(); i++) {
				System.out.println(c + ". " + question.getOptions().get(i));
				c++;
			}
			System.out.println("Answer: " + question.getAnswer());
			c = 97;
		}
	}

}
