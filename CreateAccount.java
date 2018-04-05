import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.*;

public class CreateAccount extends JPanel {
  private JLabel nameLabel = new JLabel("Full Name"),
    IDLabel = new JLabel("Student ID"),
    passLabel = new JLabel ("Password"),
    accTypeLabel = new JLabel ("Account Type");
  
  private JTextField nameField = new JTextField(),
    IDField = new JTextField(),
    passField = new JTextField();
  
  public JRadioButton student = new JRadioButton("Student"),
    instructor = new JRadioButton ("Instructor");
  
  public JButton cancel = new JButton("Cancel"),
    create = new JButton ("Create");
  
  private JPanel fieldPanel = new JPanel(), buttonPanel = new JPanel(), accTypePanel = new JPanel();
  
  public CreateAccount(){
    fieldPanel.setLayout (new GridLayout(3,2));
    fieldPanel.add (nameLabel);
    fieldPanel.add (nameField);
    fieldPanel.add (passLabel);
    fieldPanel.add (passField);
    fieldPanel.add (IDLabel);
    fieldPanel.add (IDField);
    
    accTypePanel.setLayout(new GridLayout(2,1));
    accTypePanel.add(student);
    accTypePanel.add(instructor);
    
    buttonPanel.setLayout(new GridLayout(2,2));
    buttonPanel.add(accTypeLabel);
    buttonPanel.add(accTypePanel);
    buttonPanel.add(cancel);
    buttonPanel.add(create);
    setLayout(new GridLayout(2,1));
    add(fieldPanel);
    add(buttonPanel);
  }
  
  public void setActionListeners(ActionListener main){
    cancel.addActionListener(main);
    create.addActionListener(main);
    student.addActionListener(main);
    instructor.addActionListener(main);
  }
  
  /*public void createUser(User[] users){
   PrintWriter out = new PrintWriter ("accounts.txt");
   out.println(""+users.length);
   for (int i = 0; i < users.length; i++){
   User u = users[i];
   if (u instanceof Student){
   
   }else{
   
   }
   }
   }*/
}
