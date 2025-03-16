public class User
{
    private int id;
    private String name,email,contact,userType;

    public User()
    {

    }

    public User(int id, String name, String email, String contact, String userType) 
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.userType = userType;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }
    public void setUserType(String userType) 
    {
        this.userType = userType;
    }
    public int getId() 
    {
        return id;
    }
    public String getName() 
    {
        return name;
    }
    public String getEmail() 
    {
        return email;
    }
    public String getContact() 
    {
        return contact;
    }
    public String getUserType() 
    {
        return userType;
    }
}