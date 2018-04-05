import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class InstructorGUI extends JPanel
{
  
  JButton goToCoursesButton = new JButton("Courses");
  JButton goToResultsButton= new JButton("View Results");
  JButton logoutButton = new JButton("Logout");
  
  private void addAll(){
  this.add(goToCoursesButton);
  this.add(goToResultsButton);
  this.add(logoutButton);
}
public void setActionListeners(ActionListener main){
  goToCoursesButton.addActionListener(main);
  goToResultsButton.addActionListener(main);
  logoutButton.addActionListener(main);
}
 
  public InstructorGUI(){
  //this.setTitle("Instructor");//"Hello " + Instructor.getName();
  this.setLayout(new GridLayout(3,1));
  addAll();
  }
  
}