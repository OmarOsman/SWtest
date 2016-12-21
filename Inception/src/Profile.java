import java.util.*;

public class Profile
{
		private String Name;
		private String Email;
		private String Password;
		private Boolean IsTeacher;
		public Profile()
		{

		}
		public Profile(String a, String b, String c,Boolean d)
		{
			Name = a;
			Email = b;
			Password = c;
			IsTeacher = d;
			
		}
		public Profile(Profile p)
		{
			Name = p.Name;
			Email = p.Email;
			Password = p.Password;
			IsTeacher = p.IsTeacher;
		}

		public final void setname(String a)
		{
			Name = a;
		}
		public final String getname()
		{
			return Name;
		}
		public final void setemail(String b)
		{
			Email = b;
		}

		public final String getemail()
		{
			return Email;
		}
		public final void setpassword(String c)
		{
			Password = c;
		}

		public final String getpassword()
		{
			return Password;
		}
		
		public final void settype(boolean c)
		{
			IsTeacher = c;
		}

		public final Boolean gettype()
		{
			return IsTeacher;
		}

		public final boolean Check()
		{
			if (Name.equals("") || Email.equals("") || Password.equals(""))
			{
				return false;
			}
			return true;
		}
		
}