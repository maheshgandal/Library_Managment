import java.util.*;

public class StudentRepository 
{
    Scanner sc=new Scanner(System.in);
    Book book[];

    public void setBooks(Book ...book)
    {
        this.book=book;
    }

    // View all books in library 
    public void viewAllBooks()
    {
        System.out.println("===================================================================");
        System.out.println("Id\tName\tAuther\tSubject\tIsbn\tStatus");
        for(int i=0;i<book.length;i++)
        {
            System.out.println(book[i].getId()+"\t"+book[i].getName()+"\t"+book[i].getAuthor()+"\t"+book[i].getSubject()+"\t"+book[i].getIsbn()+"\t"+book[i].getStatus());
        }
        System.out.println("=====================================================================");
    }

    // Issue book but if book already issue then show the message book is already issued
    public Book issueBook(String name,int id) 
    {
        Book b=null;
        
        for(int i=0;i<book.length;i++)
        {
            if(book[i].getName().equals(name) && book[i].getId() == id)
            {
                if(book[i].getStatus())
                {
                    book[i].setStatus(false);
                    b=book[i];
                    System.out.println("Book issued successfully...");
                    break;
                }
                else
                {
                    System.out.println("Book is already issued...");
                }
            }
        }
        if(b==null)
            System.out.println("Book not found");
        return b;
    }

    // View Profile
    public void viewProfile(Student s) 
    {
        System.out.println("===================================================");
        System.out.println("Id :"+s.getId());
        System.out.println("Name :"+s.getName());
        System.out.println("Email :"+s.getEmail());
        System.out.println("Contact :"+s.getContact());
        System.out.println("Department name :"+s.getDeptName());
        System.out.println("Year :"+s.getYear());
        System.out.println("User Type :"+s.getUserType());
        System.out.println("===================================================");
    }

    // Edit Profile
    public void editProfile(Student s) 
    {
        System.out.println("Enter Id");
        int id=sc.nextInt();

        sc.nextLine();
        System.out.println("Enter name");
        String name=sc.nextLine();

        System.out.println("Enter Email");
        String email=sc.nextLine();

        System.out.println("Enter Contact");
        String contact=sc.nextLine();

        System.out.println("Enter User type");
        String userType=sc.nextLine();

        System.out.println("Enter deparment name");
        String d_name=sc.nextLine();

        System.out.println("Enter Year");
        String year=sc.nextLine();

        s.setId(id);
        s.setName(name);
        s.setEmail(email);
        s.setContact(contact);
        s.setUserType(userType);
        s.setDeptName(d_name);
        s.setYear(year);

        System.out.println("Profile Update successfully...");
    }

    // View self issued Books
    public void viewSelfIssuedBooks(Student s)  
    {
        Book b[]=s.getBook();
        boolean flag=true;

        System.out.println("===================================================================");
        System.out.println("Id\tName\tAuther\tSubject\tIsbn\tStatus");
        for(int i=0;i<b.length;i++)
        {
            if(b[i] != null)
            {
                System.out.println(b[i].getId()+"\t"+b[i].getName()+"\t"+b[i].getAuthor()+"\t"+b[i].getSubject()+"\t"+b[i].getIsbn()+"\t"+b[i].getStatus());
                flag=false;
            }
        }
        if (flag) 
            System.out.println("Not issued Book");
        System.out.println("=====================================================================");
    }

    // this method can return total book count which is present in library
    public int getTotalLibraryBookCount()  
    {
        return book.length;
    }

    // this method show total available book which Student can issue
    public void viewAvailableBooks() 
    {
        boolean flag=true;
        System.out.println("===================================================================");
        System.out.println("Id\tName\tAuther\tSubject\tIsbn\tStatus");
        for(int i=0;i<book.length;i++)
        {
            if(book[i].getStatus())
            {
                System.out.println(book[i].getId()+"\t"+book[i].getName()+"\t"+book[i].getAuthor()+"\t"+book[i].getSubject()+"\t"+book[i].getIsbn()+"\t"+book[i].getStatus());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Books not available in library which student can issue");
        System.out.println("=====================================================================");
    }

    // return issued books to library
    public void returnBooks(Student s)
    {
        Book b[]=s.getBook();

        for(int i=0;i<b.length;i++)
        {
            if(b[i] != null)
            {
                for(int j=0;j<book.length;j++)
                {
                    if(b[i].getId() == book[j].getId())
                    {
                        b[i]=null;
                        book[j].setStatus(true);
                        break;
                    }
                }
            }
        }
        System.out.println("Book return successfully...");
    }
}
