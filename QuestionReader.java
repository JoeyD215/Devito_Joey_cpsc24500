package start.Java;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class QuestionReader {
/**
 * 
 * @param fname: file insertion
 * @return: gives back information 
 * @variables a-d: assigned to options
 * @question_str: questions as string
 * 
 */
	public ArrayList<Question> readFromJSON(String fname) {
		ArrayList<Question> questions = new ArrayList<Question>();
		try {
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator();
			JSONObject questionObject;
			String question_str, a, b, c, d, answer_str;		
			while (itr.hasNext()) {
				questionObject = (JSONObject)itr.next();
				question_str = questionObject.get("question").toString();;
				answer_str = questionObject.get("answer").toString();
				a = questionObject.get("a").toString();
				b = questionObject.get("b").toString();
				c = questionObject.get("c").toString();
				d = questionObject.get("d").toString();
				
				ArrayList<String> temp2 = new ArrayList<String>();
				temp2.add(a);
				temp2.add(b);
				temp2.add(c);
				temp2.add(d);
				
				
				Question temp = new Question();
				temp.setAnswer(answer_str);
				temp.setQuestion(question_str);
				temp.setOptions(temp2);
				questions.add(temp);
				
			}
			reader.close();
			return questions;
		}catch (Exception ex) {
			return null;
	}
	}
}
