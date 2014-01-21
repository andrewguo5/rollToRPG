import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class GuiStuff implements ActionListener{

    int _hp = 0;
    JPanel hitPanel, hpStatPanel, movebuttonPanel;
    JLabel hpLabel, hpStatLabel; 
    JButton attack, examine, moveup, movedown, moveleft, moveright;
	
    public JPanel createContentPane() {
	//Base Panel
	JPanel basePanel = new JPanel();
	basePanel.setLayout(null);
	
	//Panel to hold HP Label///////////////////////////PANEL
	hitPanel = new JPanel();
	hitPanel.setLayout(null);
	hitPanel.setLocation(70, 0);
	hitPanel.setSize(140, 30);
	basePanel.add(hitPanel);
	
	//HP Label
	hpLabel = new JLabel ("Hit Points");
	hpLabel.setLocation(0, 0);
	hpLabel.setSize(120, 30);
	hpLabel.setHorizontalAlignment(0);
	hpLabel.setForeground(Color.blue);
	hitPanel.add(hpLabel);

	//Panel to hold HP Stat///////////////////////////PANEL
	hpStatPanel = new JPanel();
	hpStatPanel.setLayout(null);
	hpStatPanel.setLocation(70, 40);
	hpStatPanel.setSize(140, 30);
	basePanel.add(hpStatPanel);

	//HP Stat Label
	hpStatLabel = new JLabel ("" + _hp);
	hpStatLabel.setLocation(0,0);
	hpStatLabel.setSize(120, 30);
	hpStatLabel.setHorizontalAlignment(0);
	hpStatPanel.add(hpStatLabel);

	//MoveButton Panel///////////////////////////PANEL
	movebuttonPanel = new JPanel();
	movebuttonPanel.setLayout(null);
	movebuttonPanel.setLocation(70, 80);
	movebuttonPanel.setSize(280, 120);
	basePanel.add(movebuttonPanel);

	//MoveButtons
	moveup = new JButton("Up");
	moveup.setLocation(30,0);
	moveup.setSize(70, 30);
	moveup.addActionListener(this);
	movebuttonPanel.add(moveup);

	movedown = new JButton("Down");
	movedown.setLocation(30,60);
	movedown.setSize(70, 30);
	movedown.addActionListener(this);
	movebuttonPanel.add(movedown);

	moveleft = new JButton("Left");
	moveleft.setLocation(0,30);
	moveleft.setSize(70, 30);
	moveleft.addActionListener(this);
	movebuttonPanel.add(moveleft);

	moveright = new JButton("Right");
	moveright.setLocation(60,30);
	moveright.setSize(70, 30);
	moveright.addActionListener(this);
	movebuttonPanel.add(moveright);

	//AttackButton
	attack = new JButton("Attack");
	attack.setLocation(0,0);
	attack.setSize(120, 30);
	attack.addActionListener(this);
	//buttonPanel.add(attack);
	
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
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
	frame.setSize(280, 420);
	frame.setResizable(false);
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	setup();
    }

}

