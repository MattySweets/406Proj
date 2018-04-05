import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoggedIn extends JPanel {
    private JLabel searchLabel = new JLabel ("Search");
    private JTextField searchField = new JTextField();

    public LoggedIn(){
        setLayout(new GridLayout(3,3));
        add(searchLabel);
        add(searchField);
    }

    public void setActionListeners(ActionListener main){

    }
}
