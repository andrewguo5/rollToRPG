import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class GuiStuff implements ActionListener{

    //private Player caller;
    // private int xcor;
    // private int ycor;
    int _hp = 0;
    JPanel hitPanel, hpStatPanel, buttonPanel, movePanel, expPanel, explanationsPanel; 
    JLabel hpLabel, hpStatLabel, moveLabel, exclamationLabel;
    JButton attack, examine, move, map, harvest,
	lookafar;
	
    public GuiStuff(int _temp) {
	_hp = _temp;
    }

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
       
	//Panel to hold Instructions Label///////////////////////////PANEL
	movePanel = new JPanel();
	movePanel.setLayout(null);
	movePanel.setLocation(70, 50);
	movePanel.setSize(140, 30);
	basePanel.add(movePanel);

	//Move Label
	moveLabel = new JLabel ("Instructions");
	moveLabel.setLocation(0,0);
	moveLabel.setSize(120, 30);
	moveLabel.setHorizontalAlignment(0);
	movePanel.add(moveLabel);

	//Button Panel///////////////////////////PANEL
	buttonPanel = new JPanel();
	buttonPanel.setLayout(null);
	buttonPanel.setLocation(70, 80);
	buttonPanel.setSize(280, 120);
	basePanel.add(buttonPanel);

	//MoveButtons
	examine = new JButton("Examine");
	examine.setLocation(30,0);
	examine.setSize(70, 30);
	examine.addActionListener(this);
	buttonPanel.add(examine);

	lookafar = new JButton("Look");
	lookafar.setLocation(30,60);
	lookafar.setSize(70, 30);
	lookafar.addActionListener(this);
	buttonPanel.add(lookafar);

	move = new JButton("Moving");
	move.setLocation(0,30);
	move.setSize(70, 30);
	move.addActionListener(this);
	buttonPanel.add(move);

	attack = new JButton("Attacking");
	attack.setLocation(60,30);
	attack.setSize(70, 30);
	attack.addActionListener(this);
	buttonPanel.add(attack);
	
	//Panel to hold Explanations Label///////////////////////////PANEL
	explanationsPanel = new JPanel();
	explanationsPanel.setLayout(null);
	explanationsPanel.setLocation(70, 210);
	explanationsPanel.setSize(140, 30);
	basePanel.add(explanationsPanel);

	//Exclamation Label
	exclamationLabel = new JLabel ("!!!");
	exclamationLabel.setLocation(0,0);
	exclamationLabel.setSize(120, 30);
	exclamationLabel.setHorizontalAlignment(0);
	explanationsPanel.add(exclamationLabel);

	//LookButtons Panel/////////////////////////////////PANEL
	expPanel = new JPanel();
	expPanel.setLayout(null);
	expPanel.setLocation(70, 240);
	expPanel.setSize(280, 120);
	basePanel.add(expPanel);

	//LookButtons
	map = new JButton("/L\\");
	map.setLocation(30,0);
	map.setSize(70, 30);
	map.addActionListener(this);
	expPanel.add(map);

	harvest = new JButton("\\L/");
	harvest.setLocation(30,60);
	harvest.setSize(70, 30);
	harvest.addActionListener(this);
	expPanel.add(harvest);
	/*
	lookleft = new JButton("<-L");
	lookleft.setLocation(0,30);
	lookleft.setSize(70, 30);
	lookleft.addActionListener(this);
	expPanel.add(lookleft);

	lookright = new JButton("L->");
	lookright.setLocation(60,30);
	lookright.setSize(70, 30);
	lookright.addActionListener(this);
	expPanel.add(lookright);
	*//*
	//AttackButton
	attack = new JButton("Attack");
	attack.setLocation(0,0);
	attack.setSize(120, 30);
	attack.addActionListener(this);
	//buttonPanel.add(attack);

	*/
	return basePanel;
    }


    public void actionPerformed(ActionEvent bang) {
	Object source = bang.getSource();
	if (source == attack) {
	    System.out.println("bang!");
	}
	if (source == examine) {
	    //move(0, 1);
	    System.out.println("Moved up");
	}
	if (source == lookafar) {
	    System.out.println ("Moved down" );
	}
	if (source == move ) {
	    System.out.println ("Moved left");
	}
	if (source == attack) {
	    System.out.println ("Moved right");
	}
	if (source == map) {
	    System.out.println ("map" );
	}
	if (source == harvest) {
	    System.out.println ("harvest" );
	}/*
	if (source == lookleft ) {
	    System.out.println ("lookLeft");
	}
	if (source == lookright) {
	    System.out.println ( "lookRight");
	}*/
    }/*
	*/
    public static void setup(int _temp) {
        JFrame frame = new JFrame("Player UI");
	
	GuiStuff gui = new GuiStuff(_temp);
	frame.setContentPane(gui.createContentPane());
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
	frame.setSize(280, 420);
	frame.setResizable(false);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	setup(100);
	}

}

