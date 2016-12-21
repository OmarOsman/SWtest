import java.util.*;

public class User
{
	private Profile profile;
	private static ArrayList<Game> Games = new ArrayList<Game>(); //Games for all users
	
	public User()
	{
		profile = new Profile();
		
	}
	
	public String GetProfileName(){
		return (profile.getname());
	}
	public String GetProfileEmail(){
		return (profile.getemail());	
	}
	public boolean Is_Teacher(){ 
		return (profile.gettype());
		}
	
	public final void Fill_profile()
	{
		System.out.println("Enter name :");
		String a = new Scanner(System.in).nextLine();
		profile.setname(a);
		System.out.println("Enter password :");
		a = new Scanner(System.in).nextLine();
		profile.setpassword(a);
		System.out.println("Enter email :");
		a = new Scanner(System.in).nextLine();
		profile.setemail(a);
		System.out.println("Are you a Teacher (Y/N):");
		a = new Scanner(System.in).nextLine();
		boolean teach = false;
		if (a.equalsIgnoreCase("Y")) teach = true;
		profile.settype(teach);
		
		if (!profile.Check())
		{
			System.out.print("You mustn't leave any info please retype your profile\n");
			Fill_profile();
		}
	}
	public  boolean CheckNamePassword(String s, String t)
	{
		if (s.equals(profile.getname()) && (t.equals(profile.getpassword()) || t.equals("-1")))
		{
			return true;
		}
		return false;
	}
	public  void View_profile()
	{
		System.out.println("Name : " + profile.getname());
		System.out.println("Email : " + profile.getemail());
	}
	
	public  void Play_Game (){
		if (Games.size() == 0){System.out.println("Sorry there aren't any available ganes."); return;}
		int score = 0,c=0;
		System.out.println("Choose Game :" + "1-" + Games.size());
		for ( Game i : Games) System.out.println((++c) + " "  + i.getName());
		int num  = Integer.parseInt(new Scanner(System.in).nextLine());
		if (num<1 || num > Games.size()) {
			System.out.println("Please Enter a valid game number ");
			Play_Game();
		}
		Game g =  new Game();
		g = Games.get(num-1);
		
		if (g.getType().equalsIgnoreCase("MCQ")){
		for (int i=0;i<g.getNumberOfQuestions();i++){
			
			MCQQuestion q  = (MCQQuestion)g.getQuestions().get(i);
			System.out.println("choose correct answer : (1-4)");
			System.out.println(q.getLabel());
			System.out.println("1)" + q.getOne());
			System.out.println("2)" + q.getTwo());
			System.out.println("3)" + q.getThree());
			System.out.println("4)" + q.getFour());
			
			int choice = Integer.parseInt(new Scanner(System.in).nextLine());
			if (choice == 1 && q.getRightAnswer() == 1) { System.out.println("Correct Answer !");score++;}
			else if (choice == 2 && q.getRightAnswer() == 2) { System.out.println("Correct Answer !"); score++;}
			else if (choice == 3 && q.getRightAnswer() == 3) { System.out.println("Correct Answer !"); score++;}
			else if (choice == 4 && q.getRightAnswer() == 4) { System.out.println("Correct Answer !"); score++;}
			else {System.out.println("Wrong Answer ! Correct Answer is number " + q.getRightAnswer() );}
			}
		System.out.println("Your Score is :" + score);
		}
		
		else if (g.getType().equalsIgnoreCase("tf")) {
			for (int i=0;i<g.getNumberOfQuestions();i++){
				TFQuestion q  = (TFQuestion)g.getQuestions().get(i);
				System.out.println("Enter T or F :");
				System.out.println(q.getLabel());
				
				String decision  = new Scanner(System.in).nextLine();
				if (q.isTrue()){ 
					if (decision.equalsIgnoreCase("T")){System.out.println("Correct Answer !"); score++;}
					else  System.out.println("Wrong Answer !"); 
				}
				else{
					if (decision.equalsIgnoreCase("F"))  { System.out.println("Correct Answer !"); score++;}
					else  System.out.println("Wrong Answer !");
			}
		}
			System.out.println("Your Score is :" + score);
	}
		
		
	}
	public  void Create_Game (){
		System.out.println("Enter Game type : (MCQ/TF)");
		String type = new Scanner(System.in).nextLine();
		if (type.equalsIgnoreCase("MCQ")){
			System.out.println("Enter numebr of questions :");
			int num  = Integer.parseInt(new Scanner(System.in).nextLine());
			Game g = new Game();
			g.setNumberOfQuestions(num);
			g.setType("MCQ");
			System.out.println("Enter Game name :");
			g.setName(new Scanner(System.in).nextLine());
			for (int i=0;i<num;i++){
				MCQQuestion q = new MCQQuestion();
				System.out.println("Enter Question:");
				q.setLabel((new Scanner(System.in).nextLine()));
				System.out.println("Enter First choice:");
				q.setOne((new Scanner(System.in).nextLine()));
				System.out.println("Enter Second choice:");
				q.setTwo((new Scanner(System.in).nextLine()));
				System.out.println("Enter Third choice:");
				q.setThree((new Scanner(System.in).nextLine()));
				System.out.println("Enter Fourth choice:");
				q.setFour((new Scanner(System.in).nextLine()));
				System.out.println("Enter correct answer:");
				q.setRightAnswer(Integer.parseInt(new Scanner(System.in).nextLine()));
				g.getQuestions().add(q);
			}
			Games.add(g);
		}
		else if (type.equalsIgnoreCase("TF")) {
			System.out.println("Enter numebr of questions :");
			int num  = Integer.parseInt(new Scanner(System.in).nextLine());
			Game g = new Game();
			g.setNumberOfQuestions(num);
			g.setType("TF");
			System.out.println("Enter Game name :");
			g.setName(new Scanner(System.in).nextLine());
			for (int i=0;i<num;i++){
				TFQuestion q = new TFQuestion();
				System.out.println("Enter Question:");
				q.setLabel((new Scanner(System.in).nextLine()));
				System.out.println("Enter T or F:");
				String a = new Scanner(System.in).nextLine();
				q.setTrue(false);
				if (a.equalsIgnoreCase("T")) q.setTrue(true);
				g.getQuestions().add(q);
			}
			Games.add(g);
		}
		else{ System.out.println("Please Enter valid game type :"); Create_Game();}
			
	}
	
}

	

