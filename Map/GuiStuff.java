import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class GuiStuff implements ActionListener{

    int _hp = 0;
    JPanel hitPanel, hpStatPanel, buttonPanel;
    JLabel hpLabel, hpStatLabel;
    JButton attack, examine;
	
    public JPanel createContentPane() {
	//Base Panel
	JPanel basePanel = new JPanel();
	basePanel.setLayout(null);
	
	//Panel to hold HP Label
	hitPanel = new JPanel();
	hitPanel.setLayout(null);
	hitPanel.setLocation(10, 0);
	hitPanel.setSize(250, 30);
	basePanel.add(hitPanel);
	
	//HP Label
	hpLabel = new JLabel ("Hit Points");
	hpLabel.setLocation(0, 0);
	hpLabel.setSize(100, 30);
	hpLabel.setHorizontalAlignment(0);
	hpLabel.setForeground(Color.blue);
	hitPanel.add(hpLabel);

	//Panel to hold HP Stat
	hpStatPanel = new JPanel();
	hpStatPanel.setLayout(null);
	hpStatPanel.setLocation(10, 40);
	hpStatPanel.setSize(260, 30);
	basePanel.add(hpStatPanel);

	//HP Stat Label
	hpStatLabel = new JLabel ("" + _hp);
	hpStatLabel.setLocation(0,0);
	hpStatLabel.setSize(120, 30);
	hpStatLabel.setHorizontalAlignment(0);
	hpStatPanel.add(hpStatLabel);

	//Button Panel
	buttonPanel = new JPanel();
	buttonPanel.setLayout(null);
	buttonPanel.setLocation(10, 80);
	buttonPanel.setSize(260, 70);
	basePanel.add(buttonPanel);

	//Buttons
	attack = new JButton("Attack");
	attack.setLocation(0,0);
	attack.setSize(120, 30);
	attack.addActionListener(this);
	buttonPanel.add(attack);
	
	return basePanel;
    }

    public void actionPerformed(ActionEvent bang) {
	Object source = bang.getSource();
	if (source == attack) {
	    System.out.println("bang!");
	}
    }

    private static void setup() {
	
        JFrame frame = new JFrame("Player UI");
	
	GuiStuff gui = new GuiStuff();
	frame.setContentPane(gui.createContentPane());
	
	frame.setSize(280, 190);
	frame.setResizable(false);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	setup();
    }

}

