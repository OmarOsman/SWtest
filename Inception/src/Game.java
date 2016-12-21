import java.util.ArrayList;

public class Game {
	private String name;
	private String type;
	private int NumberOfQuestions;
	private ArrayList<Question> Questions = new ArrayList<Question>();
	
	Game(){
		name ="";
		NumberOfQuestions = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfQuestions() {
		return NumberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		NumberOfQuestions = numberOfQuestions;
	}

	public ArrayList<Question> getQuestions() {
		return Questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		Questions = questions;
	}
	
}
