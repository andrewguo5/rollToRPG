import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class GuiStuff implements ActionListener{

    int _hp = 0;
    JPanel hitPanel, hpStatPanel, movebuttonPanel, lookbuttonPanel, movePanel, lookPanel;
    JLabel hpLabel, hpStatLabel, moveLabel, lookLabel;
    JButton attack, examine, moveup, movedown, moveleft, moveright,
	lookup, lookdown, lookleft, lookright;
	
    public JPanel createContentPane() {
	//Base Panel
	JPanel basePanel = new JPanel();
	basePanel.setLayout(null);
	
	//Panel to hold HP Label///////////////////////////PANEL
	hitPanel = new JPanel();
	hitPanel.setLayout(null);
	hitPanel.setLocation(70, 0);
	hitPanel.setSize(140, 20);
	basePanel.add(hitPanel);
	
	//HP Label
	hpLabel = new JLabel ("Hit Points");
	hpLabel.setLocation(0, 0);
	hpLabel.setSize(120, 20);
	hpLabel.setHorizontalAlignment(0);
	hpLabel.setForeground(Color.blue);
	hitPanel.add(hpLabel);

	//Panel to hold HP Stat///////////////////////////PANEL
	hpStatPanel = new JPanel();
	hpStatPanel.setLayout(null);
	hpStatPanel.setLocation(70, 20);
	hpStatPanel.setSize(140, 20);
	basePanel.add(hpStatPanel);

	//HP Stat Label
	hpStatLabel = new JLabel ("" + _hp);
	hpStatLabel.setLocation(0,0);
	hpStatLabel.setSize(120, 20);
	hpStatLabel.setHorizontalAlignment(0);
	hpStatPanel.add(hpStatLabel);	

	//Panel to hold Move Label///////////////////////////PANEL
	movePanel = new JPanel();
	movePanel.setLayout(null);
	movePanel.setLocation(70, 50);
	movePanel.setSize(140, 30);
	basePanel.add(movePanel);

	//Move Label
	moveLabel = new JLabel ("Move");
	moveLabel.setLocation(0,0);
	moveLabel.setSize(120, 30);
	moveLabel.setHorizontalAlignment(0);
	movePanel.add(moveLabel);

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

	//Panel to hold Look Label///////////////////////////PANEL
	lookPanel = new JPanel();
	lookPanel.setLayout(null);
	lookPanel.setLocation(70, 210);
	lookPanel.setSize(140, 30);
	basePanel.add(lookPanel);

	//Look Label
	lookLabel = new JLabel ("Look");
	lookLabel.setLocation(0,0);
	lookLabel.setSize(120, 30);
	lookLabel.setHorizontalAlignment(0);
	lookPanel.add(lookLabel);

	//LookButtons Panel/////////////////////////////////PANEL
	lookbuttonPanel = new JPanel();
	lookbuttonPanel.setLayout(null);
	lookbuttonPanel.setLocation(70, 240);
	lookbuttonPanel.setSize(280, 120);
	basePanel.add(lookbuttonPanel);

	//LookButtons
	lookup = new JButton("/L\\");
	lookup.setLocation(30,0);
	lookup.setSize(70, 30);
	lookup.addActionListener(this);
	lookbuttonPanel.add(lookup);

	lookdown = new JButton("\\L/");
	lookdown.setLocation(30,60);
	lookdown.setSize(70, 30);
	lookdown.addActionListener(this);
	lookbuttonPanel.add(lookdown);

	lookleft = new JButton("<-L");
	lookleft.setLocation(0,30);
	lookleft.setSize(70, 30);
	lookleft.addActionListener(this);
	lookbuttonPanel.add(lookleft);

	lookright = new JButton("L->");
	lookright.setLocation(60,30);
	lookright.setSize(70, 30);
	lookright.addActionListener(this);
	lookbuttonPanel.add(lookright);

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
	if (source == moveup) {
	    System.out.println ("Up" );
	}
	if (source == movedown) {
	    System.out.println ("Down" );
	}
	if (source == moveleft ) {
	    System.out.println ("Left");
	}
	if (source == moveright) {
	    System.out.println ( "Right");
	}
	if (source == lookup) {
	    System.out.println ("lookUp" );
	}
	if (source == lookdown) {
	    System.out.println ("lookDown" );
	}
	if (source == lookleft ) {
	    System.out.println ("lookLeft");
	}
	if (source == lookright) {
	    System.out.println ( "lookRight");
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

