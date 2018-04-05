import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class CreateCourseGUI extends JPanel
{
  JLabel courseNameLabel = new JLabel("Course Name");
  JTextField courseNameField = new JTextField();
  JLabel courseCodeLabel = new JLabel("Course Code");
  JTextField courseCodeField = new JTextField();
  JLabel courseDescriptionLabel = new JLabel("Decription");
  JTextArea courseDescriptionArea = new JTextArea("");
  
  JButton createCourseButton = new JButton("Create Course");
  JButton cancelButton = new JButton("Cancel");
  
  public void addAll(){
    
    JPanel top = new JPanel();
    top.setLayout(new GridLayout(6,1));
    top.add(courseNameLabel);
    top.add(courseNameField);
    top.add(courseCodeLabel);
    top.add(courseCodeField);
    top.add(courseDescriptionLabel);
    top.add(courseDescriptionArea);
    
    JPanel bottom = new JPanel();
    bottom.setLayout( new BorderLayout());
    bottom.add(cancelButton, BorderLayout.LINE_START);
    bottom.add(createCourseButton, BorderLayout.LINE_END);
    
    this.add(top);
    this.add(bottom);
  }
  
  public CreateCourseGUI(){
  this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
  addAll();
  }

public void setActionListeners(ActionListener main){
  createCourseButton.addActionListener(main);
  cancelButton.addActionListener(main);
  
  
}

}