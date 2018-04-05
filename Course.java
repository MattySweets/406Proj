import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.io.PrintWriter;
import java.io.*;

public class Course {
  //String[] answers;
  String courseName;
  String courseCode;
  String courseDescription;
  String instructor;
  LinkedList questions;
  String schoolName;
  
  public Course(String name, String code, String description, String instructorName, String school){
    this.courseName = name;
    this.courseCode = code;
    this.courseDescription = description;
    this.instructor = instructorName;
    this.schoolName = school;
    this.questions = new LinkedList<Question>();
    
    writeCourse();
  }
  public void createQuestionAnswers(String aCourseCode, String[] ar, int correct){
    //courses.put(aCourseCode, new Question(   ));
  }
  
  public void createQuestionAnswers(){
    
  }
  
  public void writeCourse(){
    File here = new File("./"+schoolName);
        String path = here.getPath();
    
    try{
      //WHERE
      /*
       * SCHOOL
       */
      FileReader reader = new FileReader(path + "\\" + courseCode + ".txt");
      BufferedReader buffReader = new BufferedReader(reader);
      FileWriter out = new FileWriter(path + "\\" + courseCode + ".txt", true);
      BufferedWriter bufferedWriter = new BufferedWriter(out);
      
      bufferedWriter.write(this.instructor);
      bufferedWriter.newLine();
      bufferedWriter.write(this.courseName);
      bufferedWriter.newLine();
      bufferedWriter.write(this.courseCode);
      bufferedWriter.newLine();
      bufferedWriter.write(this.courseDescription);
      bufferedWriter.newLine();
      
      bufferedWriter.flush();
      bufferedWriter.close();
      
    }
    catch(FileNotFoundException noCourseFile){
      try{
        FileWriter write = new FileWriter(path + "\\" + courseCode+ ".txt");
        write.close();
        writeCourse();
      }
      
      catch (Exception e){
        System.out.println("wat");
      }
    }
    catch(Exception e){
      System.out.print("nah"); 
    } 
  }  
  
}
