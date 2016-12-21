import java.util.*;

public class Run
{
	private ArrayList<User> Users = new ArrayList<User>();
	private String user_name;
	private String password;
	private int index; //index of current Active user in Arraylist
	private int choice; 
	public Run()
	{
		Main_page();
	}
	public final void Sign_in()
	{
		System.out.print("Enter User Name : ");
		user_name = new Scanner(System.in).nextLine();
		System.out.print("Enter Password : ");
		password = new Scanner(System.in).nextLine();
		for (int i = 0; i < 100; ++i) System.out.println(); //clearscreen
		if ((index = ValidateUser(0)) != -1) //index = check (user id in array list)
		{
			Menu_page();
		}
		System.out.print("You enter an invalid user name or password\n");
	}
	public  void Sign_up(){
			User user = new User();
			user.Fill_profile();
			for (User i : Users){
				if (user.GetProfileName().equals(i.GetProfileName())) {
					System.out.println("User Name Already exists, Please Enter Another name :");
					Sign_up();
				}
				if (user.GetProfileEmail().equals(i.GetProfileEmail())) {
					System.out.println("User Email Already exists, Please Enter Another Email :");
					Sign_up();
				}
				
			}
			Users.add(user);
			index = Users.size() - 1;
			Menu_page();
		}
	
	public  int ValidateUser(int cnt)
	{
		if (cnt == Users.size()) // base case
		{
			return -1;
		}
		if (Users.get(cnt).CheckNamePassword(user_name, password))
		{
			return cnt; //return index of current user
		}
		return ValidateUser(cnt + 1);
	}
	public  void Main_page()
	{
		System.out.print("**Enter the number of your choice\nChoose one of the following:" + "\n1.Sign in\n2.Sign up\n3.Exit\n");
		choice = Integer.parseInt(new Scanner(System.in).nextLine());
		for (int i = 0; i < 100; ++i) System.out.println();
		switch (choice)
		{
			case 1:
				Sign_in();
				break;
			case 2:
				Sign_up();
				break;
			case 3:
				return; 
			default:
				System.out.print("You entered an invalid number please enter a valid one\n\n");
		}
		Main_page();
	}
	public  void Menu_page()
	{
		
		for (int i = 0; i < 100; ++i) System.out.println();
		boolean teacher = Users.get(index).Is_Teacher();
		if (teacher){
			System.out.print("**Enter the desired feature:\n1.View profile\n2.CreateGame\n3.Play Game" + "\n4.Sign out\n");
			choice = Integer.parseInt(new Scanner(System.in).nextLine());
		switch (choice)
		{
			case 1:
				Users.get(index).View_profile();
				break;
	
			case 2:
				Users.get(index).Create_Game();
				break;
			case 3:
				Users.get(index).Play_Game();
				break;
			case 4:
				Main_page();
			default:
				System.out.print("You entered an invalid number please enter a valid one\n\n");
		}
		Menu_page();
	}
		else {
			System.out.print("**Enter the desired feature:\n1.View profile\n2.Play Game" + "\n3.Sign out\n");
			choice = Integer.parseInt(new Scanner(System.in).nextLine());
		switch (choice)
		{
			case 1:
				Users.get(index).View_profile();
				break;
	
			case 2:
				Users.get(index).Play_Game();
				break;
			case 3:
				Main_page();
			default:
				System.out.print("You entered an invalid number please enter a valid one\n\n");
		}
		Menu_page();
	}
		
	}
	public static void main(String args[]){
		Run r = new Run() ;
		
	}
}