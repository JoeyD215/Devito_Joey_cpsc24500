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

/**
 * 
 * @question: string
 * @answer: given as string
 *These functions are used for setting/getting answers throughout the program
 */
public class Question {
	private String question;
	private String answer;
	private ArrayList<String> Options;
	public ArrayList<String> getOptions() {
		return Options;
	}
	public void setOptions(ArrayList<String> input) {
		Options = input;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String setquestion) {
		question = setquestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String setanswer) {
		answer = setanswer;
	}
	public Question() {
		question = "none";
		answer = "none";
	}
	public Question(String question, String answer) {
	}
	@Override
	public String toString() {
		return String.format("%s\n%s",question, answer);
	}
}
