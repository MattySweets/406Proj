import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class CoursesGUI extends JPanel
{
  
  JButton goToCreateCourseButton = new JButton("Create Course");
  JButton viewCoursesButton = new JButton("View Courses");
  JButton backButton = new JButton("Back");
  
  private void addAll(){
  this.add(goToCreateCourseButton);
  this.add(viewCoursesButton);
  this.add(backButton);
  }
  
  public void setActionListeners(ActionListener main){
    goToCreateCourseButton.addActionListener(main);
    viewCoursesButton.addActionListener(main);
    backButton.addActionListener(main);
  }
  
  public CoursesGUI(){
  this.setLayout(new GridLayout(3,1));
  addAll();
  }
  
}

class CourseMadeScreen extends JPanel
{
  JLabel doneLabel = new JLabel("Course Made");
  JButton backButton = new JButton("Back");
  
  public CourseMadeScreen(){
  this.setLayout(new BorderLayout());
  
  this.add(doneLabel, BorderLayout.NORTH);
  this.add(backButton, BorderLayout.CENTER);
  }
  
  public void setActionListeners(ActionListener main){
  backButton.addActionListener(main);
  }
}