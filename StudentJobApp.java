package studentjobapp;
import java.util.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Sfundo
 */
public class StudentJobApp {
    static List<StudentMenu> students = new ArrayList<>();
    static List<EmployerMenu> employers = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] mainOptions = {"Student", "Employer", "Admin", "Back"};
        int choice = -1;
        
        while (choice != 3){
            choice = JOptionPane.showOptionDialog(null,
                    "Select user type: ",
                    "Student Job App",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    mainOptions,
                    mainOptions[0]);
            
            if (choice == 0){
                studentMenu();
                
            }else if (choice == 1){
                employerMenu();
                
            }else if (choice == 2){
                adminMenu();
            }
        }
        JOptionPane.showMessageDialog(null, "Existing Student Job App. Goodbye!!");
    
    }
    
    // ---------------- Student Menu ----------------
    public static void studentMenu() {
        String[] options = {"Create Profile", "Search Jobs", "Back"};
        int choice = JOptionPane.showOptionDialog(null,
                "Student Options",
                "Student Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        
        if (choice == 0) {
            String name = JOptionPane.showInputDialog("Enter your name: ");
            String email = JOptionPane.showInputDialog("Enter your email: ");
            String skills = JOptionPane.showInputDialog("Enter your skills (comma-separated): ");
            students.add(new StudentMenu(name, email, skills));
            JOptionPane.showMessageDialog(null,"Profile created successfully!!");
            
        } else if (choice == 1){
            String skill = JOptionPane.showInputDialog("Enter a skill to search for: ");
            String location = JOptionPane.showInputDialog("Enter the location you searching for: ");
            StringBuilder sb = new StringBuilder("Jobs Found:\n");
            for (EmployerMenu emp : employers){
                for (AdminMenu job : emp.getJobs()){
                    if (job.getSkillsRequired().toLowerCase().contains(skill.toLowerCase()) &&
                        job.getLocation().toLowerCase().contains(location.toLowerCase())) {
                        sb.append(job.getTitle())
                          .append(" at ")
                          .append(emp.getName())
                          .append("\n");
                    }
                }
            }
            if (sb.toString().equals("Jobs Found: \n")){
                sb.append("No jobs match your search.");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
    // ---------------- Student Menu ----------------
    public static void employerMenu() {
        String[] options = {"Create Acoount", "Post Job", "Back"};
        int choice = JOptionPane.showOptionDialog(null,
                "Employer Options",
                "Employer Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        
        if (choice == 0){
            String name = JOptionPane.showInputDialog("Enter company's name: ");
            String email = JOptionPane.showInputDialog("Enter company's email: ");
            employers.add(new EmployerMenu(name, email));
            JOptionPane.showMessageDialog(null, "Employer account created successfully!!");
            
        }else if (choice == 1){
            if (employers.isEmpty()){
                JOptionPane.showMessageDialog(null, "No employers registered yet!!");
                return;
        }
            String empEmail = JOptionPane.showInputDialog("Enter your company's email: ");
            EmployerMenu emp = null;
            for (EmployerMenu e : employers){
                if (e.getEmail().equalsIgnoreCase(empEmail)){
                    emp = e;
                    break;
                }
            }
            if (emp == null){
                JOptionPane.showMessageDialog(null, "Employer not Found!!");
                return;
                
            }
            String title = JOptionPane.showInputDialog("Enter job title: ");
            String location = JOptionPane.showInputDialog("Enter the job location: ");
            String skills = JOptionPane.showInputDialog("Enter skills required: ");
            emp.getJobs().add(new AdminMenu(title, location, skills));
            JOptionPane.showMessageDialog(null, "Job posted successfully!!");
        }
    }
    // ---------------- Admin Menu ----------------
    public static void adminMenu(){
        String[] options = {"View Students", "View Employers", "Back"};
        int choice = JOptionPane.showOptionDialog(null,
                "Admin Options",
                "Admin Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);
        
        if (choice == 0){
            if (students.isEmpty()){
                JOptionPane.showMessageDialog(null, "No Students registered yet!!");
                return;
                
            }
            StringBuilder sb = new StringBuilder("Students:\n");
            for (StudentMenu s : students){
                sb.append(s.getName())
                  .append(" - Skills: ")
                  .append(s.getSkills())
                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
            
        }else if (choice == 1){
            if (employers.isEmpty()){
                JOptionPane.showMessageDialog(null, "No employers registered yet!!");
                return;
            }
            StringBuilder sb = new StringBuilder("Employers:\n");
            for (EmployerMenu e : employers){
                sb.append(e.getName())
                  .append(" - Jobs posted: ")
                  .append(e.getJobs().size())
                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
        
    }
}
