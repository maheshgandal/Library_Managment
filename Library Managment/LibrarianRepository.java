public class LibrarianRepository 
{
    Book book[];
    Student student[];
    
    public void setBook(Book ...book) 
    {
        this.book = book;
    }

    public void setStudent(Student ...student) 
    {
        this.student = student;
    }

    // View all students
    public void viewAllStudents()
    {
        System.out.println("===============================================================================");
        System.out.println("Id\tName\tEmail\tContact\tD_name\tYear\tUser Type");
        for(int i=0;i<student.length;i++)
        {
            System.out.println(student[i].getId()+"\t"+student[i].getName()+"\t"+student[i].getEmail()+"\t"+student[i].getContact()+"\t"+student[i].getDeptName()+"\t"+student[i].getYear()+"\t"+student[i].getUserType());
        }
        System.out.println("===============================================================================");
    }

    // Search student by name
    public void searchStudentByName(String name)
    {
        boolean flag=true;
        System.out.println("===============================================================================");
        System.out.println("Id\tName\tEmail\tContact\tD_name\tYear\tUser Type");
        for(int i=0;i<student.length;i++)
        {
            if(student[i].getName().equals(name))
            {
                System.out.println(student[i].getId()+"\t"+student[i].getName()+"\t"+student[i].getEmail()+"\t"+student[i].getContact()+"\t"+student[i].getDeptName()+"\t"+student[i].getYear()+"\t"+student[i].getUserType());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Student not found");
        System.out.println("===============================================================================");
    }

    // =========================================================================================================

    // Search student by Email
    public void searchStudentByEmail(String email)
    {
        boolean flag=true;
        System.out.println("===============================================================================");
        System.out.println("Id\tName\tEmail\tContact\tD_name\tYear\tUser Type");
        for(int i=0;i<student.length;i++)
        {
            if(student[i].getEmail().equals(email))
            {
                System.out.println(student[i].getId()+"\t"+student[i].getName()+"\t"+student[i].getEmail()+"\t"+student[i].getContact()+"\t"+student[i].getDeptName()+"\t"+student[i].getYear()+"\t"+student[i].getUserType());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Student not found");
        System.out.println("===============================================================================");
    }

    // View all Books
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

    // ======================================================================================================================================

    // Search book by id
    public void searchBookById(int id)
    {
        boolean flag=true;
        System.out.println("===================================================================");
        System.out.println("Id\tName\tAuther\tSubject\tIsbn\tStatus");
        for(int i=0;i<book.length;i++)
        {
            if(book[i].getId() == id)
            {
                System.out.println(book[i].getId()+"\t"+book[i].getName()+"\t"+book[i].getAuthor()+"\t"+book[i].getSubject()+"\t"+book[i].getIsbn()+"\t"+book[i].getStatus());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Book not found");
        System.out.println("=====================================================================");
    }

    // Search book by name
    public void searchBookByName(String name)
    {
        boolean flag=true;
        System.out.println("===================================================================");
        System.out.println("Id\tName\tAuther\tSubject\tIsbn\tStatus");
        for(int i=0;i<book.length;i++)
        {
            if(book[i].getName().equals(name))
            {
                System.out.println(book[i].getId()+"\t"+book[i].getName()+"\t"+book[i].getAuthor()+"\t"+book[i].getSubject()+"\t"+book[i].getIsbn()+"\t"+book[i].getStatus());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Book not found");
        System.out.println("=====================================================================");
    }

    // =========================================================================================================

    // View issued book by students
    public void viewAllIssuedBooks()
    {
        boolean flag=true;
        System.out.println("===================================================================");
        System.out.println("Id\tName\tAuther\tSubject\tIsbn\tStatus");
        for(int i=0;i<book.length;i++)
        {
            if(!book[i].getStatus())
            {
                System.out.println(book[i].getId()+"\t"+book[i].getName()+"\t"+book[i].getAuthor()+"\t"+book[i].getSubject()+"\t"+book[i].getIsbn()+"\t"+book[i].getStatus());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Books are not issued");
        System.out.println("=====================================================================");
    }

    // View student who issues minimum single book 
    public void viewStudentIssuSingleBook()
    {
        boolean flag=true;
        System.out.println("===============================================================================");
        System.out.println("Id\tName\tEmail\tContact\tD_name\tYear\tUser Type");
        for(int i=0;i<student.length;i++)
        {
            int c=0;
            Book b[]=student[i].getBook();
            for(int j=0;j<b.length;j++)
            {
                if(b[j] != null)
                    c++;
            }
            if(c==1)
            {
                System.out.println(student[i].getId()+"\t"+student[i].getName()+"\t"+student[i].getEmail()+"\t"+student[i].getContact()+"\t"+student[i].getDeptName()+"\t"+student[i].getYear()+"\t"+student[i].getUserType());
                flag=false;
            }
        }
        if(flag)
            System.out.println("Student not found who issues minimum single book");
        System.out.println("===============================================================================");
    }

    // view total book count in library
    public void viewTotalCountInLibrary()
    {
        System.out.println("Total Books in Library is :"+book.length);
    }

    // View available book count in library
    public void viewAvailableBookCount()
    {
        int c=0;

        for(int i=0;i<book.length;i++)
        {
            if(book[i].getStatus())
                c++;
        }
        System.out.println("Available book count in library is :"+c);
    }

    // Show the issued book count in library
    public void viewIssuedBookCount()
    {
        int c=0;

        for(int i=0;i<book.length;i++)
        {
            if(!book[i].getStatus())
                c++;
        }
        System.out.println("Issued book count in library is :"+c);
    }
}