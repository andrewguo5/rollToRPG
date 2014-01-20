import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame extends JFrame implements ActionListener{

    JLabel answer = new JLabel("");
    JPanel pane = new JPanel();
    JButton buttonlol = new JButton("click this button lol");
    public TestFrame() {
	super("TestFrame Swag Oldmoney"); 
	setBounds(300, 200, 300, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container con = this.getContentPane();
	con.add(pane);
	buttonlol.setMnemonic('k');
	buttonlol.addActionListener(this);
	pane.add(answer);
	pane.add(buttonlol);
	//buttonlol.requestFocus();?
	setVisible(true);
    }
    
    public void actionPerformed(ActionEvent bang) {
	Object source = bang.getSource();
	if (source == buttonlol) {
	    answer.setText("This text magically appeared.");
	    JOptionPane.showMessageDialog(null, "You just clicked the button", "Congrats", JOptionPane.PLAIN_MESSAGE);
	    setVisible(true);
	}
    }
	    
    public static void main (String[] args) {
	new TestFrame();
    }
}
