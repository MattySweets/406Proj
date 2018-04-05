public class User {
    private String name, ID, pass, school;

    public User(){}

    public User(String name, String ID, String pass, String school){
        this.name = name;
        this.ID = ID;
        this.pass = pass;
        this.school = school;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setID (String ID){
        this.ID = ID;
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return ID;
    }
    public String getPass() {
        return pass;
    }
    
    public String getSchool(){
      return school;
    }

}
