package studentjobapp;

/**
 *
 * @author Sfundo
 */
public class StudentMenu {
    private String name;
    private String email;
    private String skills;
    
    public StudentMenu(String name, String email, String skills){
        this.name = name;
        this.email = email;
        this.skills = skills;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getSkills(){
        return skills;
    }
    
}
