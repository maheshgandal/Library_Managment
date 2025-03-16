public class Student extends User
{
    String deptName,year;
    Book book[];

    public Student()
    {

    }

    public Student(int id, String name, String email, String contact, String userType, String deptName, String year, Book ...book) 
    {
        super(id, name, email, contact, userType);
        this.deptName = deptName;
        this.year = year;
        this.book = book;
    }

    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public void setYear(String year) 
    {
        this.year = year;
    }

    public void setBooks(Book ...book)
    {
        this.book=book;
    }

    public String getDeptName() 
    {
        return deptName;
    }

    public String getYear() 
    {
        return year;
    }

    public Book[] getBook() 
    {
        return book;
    }
}
