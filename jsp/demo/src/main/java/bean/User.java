package bean;

public class User {  
    private int id;  
    private String name,password,email,sex,country;  
    
    public User(){}
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String n){
        password=n;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String n){
        email=n;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String n){
        sex=n;
    }
    public String getCountry(){
        return country;
    }
    public void setCountry(String n){
        country=n;
    }
    public String getName(){
        return name;
    }
    public void setName(String n){
        name=n;
    }
}  