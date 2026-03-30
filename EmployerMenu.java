package studentjobapp;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sfundo
 */
public class EmployerMenu {
    private String name;
    private String email;
    private List<AdminMenu> jobs;
    
    public EmployerMenu(String name, String email){
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public List<AdminMenu> getJobs(){
        return jobs;
    }
}
