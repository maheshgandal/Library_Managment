import java.util.*;

public class LibrariManagmentApp 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);

        ValidateUser v=new ValidateUser();
        StudentRepository sr=new StudentRepository();
        LibrarianRepository lr=new LibrarianRepository();
        Librarian lib[]=new Librarian[2];
        Student stu[]=new Student[2];
        Book book[]=new Book[5];

        System.out.println("Enter Librarian details");
        for(int i=0;i<lib.length;i++)
        {
            System.out.println("Enter details for Librarian "+(i+1));

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

            System.out.println("Enter Designation");
            String designation=sc.nextLine();

            lib[i]=new Librarian(id, name, email, contact, userType, designation);
        }

        System.out.println("*******************************************");
        System.out.println("Enter Student details");
        for(int i=0;i<stu.length;i++)
        {
            System.out.println("Enter details for Student "+(i+1));

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

            Book b[]=new Book[book.length];

            stu[i]=new Student(id, name, email, contact, userType, d_name, year, b);
        }
        lr.setStudent(stu);

        System.out.println("*******************************************");
        System.out.println("Enter Book details");
        for(int i=0;i<book.length;i++)
        {
            System.out.println("Enter details for book "+(i+1));

            System.out.println("Enter book Id");
            int id=sc.nextInt();

            sc.nextLine();
            System.out.println("Enter book name");
            String name=sc.nextLine();

            System.out.println("Enter Book Auther");
            String auther=sc.nextLine();

            System.out.println("Enter Book Subject");
            String subject=sc.nextLine();

            System.out.println("Enter Book isbn");
            String isbn=sc.nextLine();

            book[i]=new Book(id, name, auther, subject, isbn, true);
        }
        lr.setBook(book);
        sr.setBooks(book);

        int ch1;
        do
        {
            System.out.println("-------------------------------------");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Librarian");
            System.out.println("3. Exit");
            System.out.println("--------------------------------------");

            System.out.println("Enter your choice");
            ch1=sc.nextInt();

            switch (ch1) 
            {
                case 1:
                    Student student=(Student)v.validateUser(stu);

                    if(student != null)
                    {
                        int ch;
                        do
                        {
                            System.out.println("----------------------------------------------------");
                            System.out.println("1. View all Book");
                            System.out.println("2. Issue book");
                            System.out.println("3. View Profile");
                            System.out.println("4. Edit Profile");
                            System.out.println("5. Show self-issued book list");
                            System.out.println("6. Show the total book count in library");
                            System.out.println("7. Show the available books student can issue");
                            System.out.println("8. Return book to library");
                            System.out.println("9. Logout");
                            System.out.println("----------------------------------------------------");

                            System.out.println("Enter your choice");
                            ch=sc.nextInt();

                            switch (ch) 
                            {
                                case 1:
                                    sr.viewAllBooks();
                                    break;
                            
                                case 2:
                                    System.out.println("Enter Book id");
                                    int id=sc.nextInt();

                                    sc.nextLine();
                                    System.out.println("Enter Book name");
                                    String name=sc.nextLine();

                                    Book b=sr.issueBook(name, id);

                                    if(b != null)
                                    {
                                        Book b2[]=student.getBook();

                                        for(int i=0;i<b2.length;i++)
                                        {
                                            if(b2[i] == null)
                                            {
                                                b2[i]=b;
                                                break;
                                            }
                                        }
                                    }
                                    break;

                                case 3:
                                    sr.viewProfile(student);
                                    break;

                                case 4:
                                    sr.editProfile(student);
                                    break;

                                case 5:
                                    sr.viewSelfIssuedBooks(student);
                                    break;

                                case 6:
                                    int count=sr.getTotalLibraryBookCount();
                                    System.out.println("Total books in library is "+count);
                                    break;

                                case 7:
                                    sr.viewAvailableBooks();
                                    break;

                                case 8:
                                    sr.returnBooks(student);
                                    break;

                                case 9:
                                    break;

                                default:
                                    System.out.println("Invalid Choice...");
                                    break;
                            }
                        }while(ch != 9);
                    }
                    break;
            
                case 2:
                    Librarian librarian=(Librarian)v.validateUser(lib);

                    if(librarian != null)
                    {
                        int ch;
                        do
                        {
                            System.out.println("------------------------------------------------------");
                            System.out.println("1. View all Students");
                            System.out.println("2. Search student by name or email");
                            System.out.println("3. View All Books");
                            System.out.println("4. Search books by id or name");
                            System.out.println("5. View issued book by student");
                            System.out.println("6. View student who issues minimum single book");
                            System.out.println("7. Show the total number of books in library");
                            System.out.println("8. Show the available book count in library");
                            System.out.println("9. Show the issued book count in library");
                            System.out.println("10. Logout");
                            System.out.println("------------------------------------------------------");

                            System.out.println("Enter your choice");
                            ch=sc.nextInt();

                            switch (ch) 
                            {
                                case 1:
                                    lr.viewAllStudents();
                                    break;
                            
                                case 2:
                                    System.out.println("------------------------------------------------------");
                                    System.out.println("1. Search student by name");
                                    System.out.println("2. search student by email");
                                    System.out.println("-------------------------------------------------------");

                                    System.out.println("Enter your choice");
                                    int choice=sc.nextInt();

                                    switch (choice) 
                                    {
                                        case 1:
                                            sc.nextLine();
                                            System.out.println("Enter name of student");
                                            String name=sc.nextLine();

                                            lr.searchStudentByName(name);
                                            break;
                                    
                                        case 2:
                                            sc.nextLine();
                                            System.out.println("Enter Email of student");
                                            String email=sc.nextLine();

                                            lr.searchStudentByEmail(email);
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                    break;

                                case 3:
                                    lr.viewAllBooks();
                                    break;

                                case 4:
                                    System.out.println("------------------------------------------------------");
                                    System.out.println("1. Search Book by id");
                                    System.out.println("2. search Book by name");
                                    System.out.println("-------------------------------------------------------");

                                    System.out.println("Enter your choice");
                                    int choice1=sc.nextInt();

                                    switch (choice1) 
                                    {
                                        case 1:
                                            System.out.println("Enter Book id");
                                            int id=sc.nextInt();

                                            lr.searchBookById(id);
                                            break;
                                    
                                        case 2:
                                            sc.nextLine();
                                            System.out.println("Enter Book name");
                                            String name=sc.nextLine();

                                            lr.searchBookByName(name);
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                    break;
                                
                                case 5:
                                    lr.viewAllIssuedBooks();
                                    break;

                                case 6:
                                    lr.viewStudentIssuSingleBook();
                                    break;

                                case 7:
                                    lr.viewTotalCountInLibrary();
                                    break;

                                case 8:
                                    lr.viewAvailableBookCount();
                                    break;

                                case 9:
                                    lr.viewIssuedBookCount();
                                    break;

                                case 10:
                                    break;

                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                        }while(ch != 10);
                    }
                    break;

                case 3:
                    System.out.println("Thank you");
                    break;
                    
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

        }while(ch1 != 3);
    }
}
