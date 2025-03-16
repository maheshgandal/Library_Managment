import java.util.*;

public class ValidateUser 
{
    Scanner sc=new Scanner(System.in);

    public User validateUser(User ...user)
    {

        boolean flag=false;
        int i;
        System.out.println("Enter User Name (email)");
        String username=sc.nextLine();

        System.out.println("Enter Password (Contact)");
        String pass=sc.nextLine();

        for(i=0;i<user.length;i++)
        {
            if(user[i].getEmail().equals(username) && user[i].getContact().equals(pass))
            {
                flag=true;
                break;
            }
        }

        if(flag)
        {
            System.out.println("Login successfully...");
            return user[i];
        }
        else
        {
            System.out.println("Invalid Username and Password...");
            return null;
        }
    }
}
