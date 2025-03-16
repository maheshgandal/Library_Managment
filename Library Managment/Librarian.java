public class Librarian extends User
{
    private String designation;

    public Librarian()
    {
        
    }
    
    public Librarian(int id, String name, String email, String contact, String userType, String designation) 
    {
        super(id, name, email, contact, userType);
        this.designation = designation;
    }

    public void setDesignation(String designation) 
    {
        this.designation = designation;
    }

    public String getDesignation() 
    {
        return designation;
    }    
}
