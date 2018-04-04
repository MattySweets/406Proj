import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class StudentFrame extends JFrame{

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 550;
	
	private static final int INFO_ROWS = 10;
	private static final int INFO_COLUMNS = 30;
	
	//string array of school names
	String[] school = new String[] {"Ryerson University", "Humber College", "University of Toronto", "Seneca College"};
	JComboBox<String> schoolList;
	JTextField courseCodeField;
	
	static JTextArea infoArea;
	
	
	//temp lists for arraylist of student courses
	ArrayList<String> courses = new ArrayList<String>();
	JList<String> courseList;
	
	
	
	public StudentFrame(){
		
		courseList = new JList(courses.toArray());
		
		infoArea = new JTextArea(INFO_ROWS,INFO_COLUMNS);
		
		this.setLayout(new BorderLayout());
		
		add(createNorthPanel(), BorderLayout.NORTH);
		add(createCenterPanel(), BorderLayout.CENTER);
		infoArea.setEditable(false);
		add(new JScrollPane(infoArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		
		
		
		
		setSize(FRAME_WIDTH,FRAME_HEIGHT);
	}
	
	public JPanel createNorthPanel(){
		
		schoolList = new JComboBox<>(school);
		
		JLabel courseCodeLabel = new JLabel("Course Code:");
		JLabel schoolLabel = new JLabel("School:");
		
		courseCodeField = new JTextField(4);


		JPanel northPanel = new JPanel();
		northPanel.setBorder(BorderFactory.createTitledBorder("Search Courses"));
		
		northPanel.setLayout(new GridLayout(0,1));
		northPanel.add(schoolLabel);
		northPanel.add(schoolList);
		northPanel.add(courseCodeLabel);
		northPanel.add(courseCodeField);
		JButton searchButton = new JButton("Search");
		JButton joinCourseButton = new JButton("Join Course");
		northPanel.add(searchButton);
		northPanel.add(joinCourseButton);
		
		ActionListener searchListener = new SearchListener();
	    searchButton.addActionListener(searchListener);
	    
	    ActionListener joinCourseListener = new JoinCourseListener();
	    joinCourseButton.addActionListener(joinCourseListener);
		
		return northPanel;
	}
	
	public JPanel createCenterPanel(){
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBorder(BorderFactory.createTitledBorder("Active Courses"));
		
		centerPanel.setLayout(new GridLayout(1,2));
		JPanel centerSubPanel = new JPanel();
		
		courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		centerPanel.add(new JScrollPane(courseList));
		
		centerSubPanel.setLayout(new GridLayout(2,1));

		centerPanel.add(centerSubPanel);
		
		JButton voteButton = new JButton("Start Vote");
		JButton tempButton = new JButton("temp button");
		centerSubPanel.add(voteButton);
		centerSubPanel.add(tempButton);
		
		ActionListener voteListener = new VoteListener();
	    voteButton.addActionListener(voteListener);
		
		return centerPanel;
	}
	
	
	class SearchListener implements ActionListener{
		public void actionPerformed(ActionEvent click) {
			//resets info text area
			infoArea.setText("");
			
			//APPEND SCHOOL TO END OF PATH IN FUTURE
			//temp path until connecting to instructor classes
			File folder = new File("C:\\Users\\Jonathan\\workspace");
			String schoolName = (String) schoolList.getSelectedItem();
			String courseCode = courseCodeField.getText();
			//checks if course search field is empty
			if (courseCode.isEmpty()){
				infoArea.setText("Please enter a valid search field");
				return;
			}
			courseCode = courseCode + ".txt";
			folder = new File(folder + "\\" + schoolName);
			File courseFile = new File(folder + "\\" + courseCode);
			
			
			String line = null;
			try {
				FileReader readFile = new FileReader(courseFile);
				BufferedReader bufferedReadFile = new BufferedReader(readFile);
				while((line = bufferedReadFile.readLine()) != null){
					infoArea.append(line + "\n");
				}
				bufferedReadFile.close();
			}
			catch(FileNotFoundException ex){
				infoArea.setText("Course not found!");
			}
			catch(IOException ex){
				infoArea.setText("ERROR READING FILE");
			}
		
		}
	}
	
	class JoinCourseListener implements ActionListener{
		public void actionPerformed(ActionEvent click) {
			
			//APPEND SCHOOL TO END OF PATH IN FUTURE
			File folder = new File("C:\\Users\\Jonathan\\workspace\\courses");
			File[] fileNames = folder.listFiles();
			String courseCode = courseCodeField.getText();
			//checks if course search field is empty or if already enrolled in course
			if (courseCode.isEmpty()){
				infoArea.setText("Please enter a valid search field");
				return;
			} else if (courses.contains(courseCode)){
				infoArea.setText("Already enrolled in course!");
				return;
			}
			courseCode = courseCode + ".txt";
			
			for (int i = 0; i < fileNames.length; i++){
				if(fileNames[i].getName().compareTo(courseCode) == 0){
					courses.add(courseCodeField.getText());
					DefaultListModel<String> listModel = new DefaultListModel<>();
					for(i = 0; i < courses.size(); i++)
						listModel.addElement(courses.get(i));
					courseList.setModel(listModel);
					return;
				}
			}
			
			infoArea.setText("Course not found!");
			
			
		}
	}
	
	class VoteListener implements ActionListener{
		public void actionPerformed(ActionEvent click) {
			if (courseList.getSelectedValue() == null){
				infoArea.setText("Please select a course");
				return;
			}
			String courseVote = courseList.getSelectedValue();
			//temp code
			infoArea.setText(courseVote);
			JFrame temp = new StudentFrame();
		      temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      temp.setTitle("Login");
		      temp.setVisible(true); 
			
			
		}
	}
	
}
