import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

class ViewCoursesGUI extends JPanel
{
  LinkedList <Course>listOfCourses = new LinkedList<Course>();
  JButton backButton = new JButton("Back");
  
  public ViewCoursesGUI(String school){
  //!!!!!!!!!!!!!!READ FROM SCHOOL DIRECTORY ALL TEXT FILE NAMESSS
    File here = new File("./"+school);
        String schoolPath = here.getPath();
        
        File schoolDirectory = new File(schoolPath);
      //  String[] list = schoolDirectory.list();//
        System.out.print(schoolDirectory.list());
   /* try{
      
      //NEED TO READ EACH FILE AND ADD TO LIST
      
  FileReader reader = new FileReader(schoolPath);
      BufferedReader buffReader = new BufferedReader(reader);
     // FileWriter out = new FileWriter(path, true);
      //BufferedWriter bufferedWriter = new BufferedWriter(out);
      int lineNumber = 1;
      
      String instructorName = "";
      String courseName = "";
      String courseCode = "";
        String courseDescription = "";
        //String
      String line = "";
      while((line = buffReader.readLine()) != null){
        if(lineNumber == 1)
        {
          instructorName = line;
          //Instructor's name
        }
        else if (lineNumber == 2)
        {
          courseName = line;
          //Course Name
        }
        else if (lineNumber == 3)
        {
          courseCode = line;
          //Course Code
        }
        else if (lineNumber == 4)
        {
          courseDescription = line;
          //Course Description
        
          listOfCourses.add(new Course(courseName, courseCode, courseDescription, instructorName, "TEMP") );
          lineNumber = 1;
        
        
        }
      }  
      if(lineNumber != 1)
      {
        System.err.print("Incomplete data set detected");
      }
  }
  catch(FileNotFoundException noFile){
    try{
  FileWriter fileWriter = new FileWriter("courses.txt");
  fileWriter.close();
    }
    catch(Exception e){
    System.err.print("could not create file");
    }
  }
  catch(Exception e){
  System.err.print("Unknown error");
  }
  }
  */
       
        addAll();
  }
  
        
  public void addAll(){
    this.setLayout(new GridLayout(3,1));
    this.add(backButton);
  }      
  
  public void setActionListeners(ActionListener main){
    backButton.addActionListener(main);
  }
  
  
}