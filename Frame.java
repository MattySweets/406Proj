import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Frame extends JFrame implements ActionListener {

    private final int ACC_TYPE = 0, ID_NUM = 1, PASSWORD = 2, FULL_NAME = 3, SCHOOL_NAME = 4;
    private User[] users;
    private int numUsers;
    public User currentUser;////////////NOW PUBLIC

    Login login = new Login();
    LoggedIn loggedIn = new LoggedIn();
    CreateAccount createAcc = new CreateAccount();
/**/InstructorGUI instructorGUI = new InstructorGUI();
/**/CoursesGUI coursesGUI = new CoursesGUI();
/**/CreateCourseGUI createCourseGUI = new CreateCourseGUI();
/**/CourseMadeScreen courseMade = new CourseMadeScreen();
    ViewCoursesGUI viewCoursesGUI;// = new ViewCoursesGUI(currentUser.getSchool());

    public Frame() {
        setTitle("CLEEKER APP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation (300,300);
        setResizable(false);
        setVisible(true);

        switchGUITo(login);

        setActionListeners();

        try {
            getUsers();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        
        //logging in
        if (src == login.login){
            currentUser = login.checkLogin(users);
            if (currentUser == null){
                System.out.println("doesn't work");
            } else{///////////////////////////////////////////////////////////////////////////
              if(currentUser.getClass().equals( (new Student()).getClass()))
                switchGUITo(loggedIn);
              else 
               if(currentUser.getClass().equals( (new Instructor()).getClass()))
                switchGUITo(instructorGUI);
            }
        }
        //create account
        else if (src == login.createAcc){
            switchGUITo(createAcc);
        }
        else if (src == createAcc.student)
            createAcc.instructor.setSelected(false);

        else if (src == createAcc.instructor)
            createAcc.student.setSelected(false);
        else if (src == createAcc.cancel){
            switchGUITo(login);
        }
        //instructorGUI to courses GUI//////////////////////
        else if(src == instructorGUI.goToCoursesButton)
          switchGUITo(coursesGUI);
        //coursesGUI to create coursesGUI///////
        else if(src == coursesGUI.goToCreateCourseButton)
          switchGUITo(createCourseGUI);
        //coursesGUI to instructorGUI//////////////
        else if(src == coursesGUI.backButton)
          switchGUITo(instructorGUI);
        //createCourseGUI to coursesGUI
        else if(src == createCourseGUI.cancelButton)
          switchGUITo(coursesGUI);
        //createCourseGUI to course made screen
        else if(src == createCourseGUI.createCourseButton){
          new Course(createCourseGUI.courseNameField.getText(),
                     createCourseGUI.courseCodeField.getText(),
                     createCourseGUI.courseDescriptionArea.getText(),
                     currentUser.getName(),
                     currentUser.getSchool()
                    );
          
          switchGUITo(courseMade);
        }
        //course made screen to coursesGUI
        else if(src == courseMade.backButton)
          switchGUITo(coursesGUI);
        //coursesGUI to viewcoursesGUI
        else if(src == coursesGUI.viewCoursesButton)
        {
          viewCoursesGUI = new ViewCoursesGUI(currentUser.getSchool());
          viewCoursesGUI.setActionListeners(this);
          switchGUITo(viewCoursesGUI);
        }
        //viewcoursesGUI to coursesgui
        else if(src == viewCoursesGUI.backButton)
          switchGUITo(coursesGUI);
        
        //log out////////////////////////////////
        else if(src == instructorGUI.logoutButton)
          switchGUITo(login);
        
    }

    public void setActionListeners(){
        login.setActionListeners(this);
        createAcc.setActionListeners(this);
        loggedIn.setActionListeners(this);
        instructorGUI.setActionListeners(this);////////////////
        coursesGUI.setActionListeners(this);//////////////
        createCourseGUI.setActionListeners(this);///////////////
        courseMade.setActionListeners(this);///////////////////////
        //viewCoursesGUI.setActionListeners(this);
    }

    public void switchGUITo(JPanel pane){
        setContentPane(pane);
        pack();
        setSize(300,300);
    }

    public void getUsers() throws FileNotFoundException{

        Scanner in = new Scanner(new File("accounts.txt"));
        numUsers = Integer.parseInt(in.nextLine());
        users = new User[numUsers];
        String[] args = new String[5];//////////////////////////////////////////////
        for (int i = 0; i < numUsers; i++){
            args[ACC_TYPE] = in.nextLine();
            args[ID_NUM] = in.nextLine();
            args[PASSWORD] = in.nextLine();
            args[FULL_NAME] = in.nextLine();
            args[SCHOOL_NAME] = in.nextLine();//////////////////////////////////////
            if (args[ACC_TYPE].equals("S")){
                users[i] = new Student (args[FULL_NAME], args[ID_NUM], args[PASSWORD], args[SCHOOL_NAME]);
            }
            else if(args[ACC_TYPE].equals("I")){/////////////////////////////////////////////////////////////////////////////////
            users[i] = new Instructor(args[FULL_NAME], args[ID_NUM], args[PASSWORD], args[SCHOOL_NAME]);
            }
            }
    }
}
