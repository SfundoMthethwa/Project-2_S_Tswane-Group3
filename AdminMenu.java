package studentjobapp;

/**
 *
 * @author Sfundo
 */
public class AdminMenu {
    private String title;
    private String location;
    private String skillsRequired;
    
    public AdminMenu(String title, String location, String skillsRequired){
        this.title = title;
        this.location = location;
        this.skillsRequired = skillsRequired;
    }
    
    public String getTitle() {
        return title;
    }
    public String getLocation(){
        return location;
    }
    public String getSkillsRequired(){
        return skillsRequired;
    }
    
}
