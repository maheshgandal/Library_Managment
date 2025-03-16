public class Book 
{
    private int id;
    private String name;
    private String author;
    private String subject;
    private String isbn;  // international book number
    private Boolean status;

    public Book()
    {

    }
    
    public Book(int id, String name, String author, String subject, String isbn, Boolean status) 
    {
        this.id = id;
        this.name = name;
        this.author = author;
        this.subject = subject;
        this.isbn = isbn;
        this.status = status;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public void setSubject(String subject) 
    {
        this.subject = subject;
    }

    public void setIsbn(String isbn) 
    {
        this.isbn = isbn;
    }

    public void setStatus(Boolean status) 
    {
        this.status = status;
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public String getAuthor() 
    {
        return author;
    }

    public String getSubject() 
    {
        return subject;
    }

    public String getIsbn() 
    {
        return isbn;
    }

    public Boolean getStatus() 
    {
        return status;
    }    
}
