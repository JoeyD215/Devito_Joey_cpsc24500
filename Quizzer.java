package start.Java;
 
import java.util.ArrayList;
import java.util.Random;
public class Quizzer {
private ArrayList<Question> options;	
private Random rand = new Random();
public int counter = 0;
public int number = 0;
public int correct = 0;

/**
 * @options: shows menu options to user
 * @counter: keeps track of questions and answers
 * @param q: variable for question
 */
	public Quizzer(ArrayList<Question> q) {
		options = q;
	}
	public void fixAmount() {
		if (counter >= options.size()) {
			counter = options.size();
			number = options.size();
		}
	}
	
	public Question getQuestion() {
		if (options.size() == 0 || counter == 0) {
			return null;
		}
		int index = rand.nextInt(options.size());
		Question Ret = options.get(index);
		options.remove(Ret);
		counter--;
		return Ret;
	}
	
	public boolean checkAnswer(String response, Question input) {
		if (response.equals(input.getAnswer())) {
			correct++;
		}
		return response.equals(input.getAnswer());
	}

}
