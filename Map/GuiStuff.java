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
    JButton attack, examine, move, map, harvest, stats, hunger,
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
	buttonPanel.setSize(280, 580);
	basePanel.add(buttonPanel);

	//Buttons
	examine = new JButton("Examine");
	examine.setLocation(0,0);
	examine.setSize(140, 30);
	examine.addActionListener(this);
	buttonPanel.add(examine);

	lookafar = new JButton("Look");
	lookafar.setLocation(0,40);
	lookafar.setSize(140, 30);
	lookafar.addActionListener(this);
	buttonPanel.add(lookafar);

	move = new JButton("Moving");
	move.setLocation(0,80);
	move.setSize(140, 30);
	move.addActionListener(this);
	buttonPanel.add(move);

	attack = new JButton("Attacking");
	attack.setLocation(0,120);
	attack.setSize(140, 30);
	attack.addActionListener(this);
	buttonPanel.add(attack);
	/*
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
	explanationsPanel.add(exclamationLabel);*/

	/*
	//LookButtons Panel/////////////////////////////////PANEL
	expPanel = new JPanel();
	expPanel.setLayout(null);
	expPanel.setLocation(70, 240);
	expPanel.setSize(280, 120);
	basePanel.add(expPanel);
	*/
	//LookButtons
	map = new JButton("Map");
	map.setLocation(0,160);
	map.setSize(140, 30);
	map.addActionListener(this);
	//expPanel.add(map);
	buttonPanel.add(map);

	harvest = new JButton("Harvest");
	harvest.setLocation(0,200);
	harvest.setSize(140, 30);
	harvest.addActionListener(this);
	//expPanel.add(harvest);
	buttonPanel.add(harvest);
	
	hunger = new JButton("Hunger");
	hunger.setLocation(0,240);
	hunger.setSize(140, 30);
	hunger.addActionListener(this);
	buttonPanel.add(hunger);
        
	stats = new JButton("Stats");
	stats.setLocation(0,280);
	stats.setSize(140, 30);
	stats.addActionListener(this);
	buttonPanel.add(stats);	/*
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
	    System.out.println("\n\n" +
			       "Attacking:\n" +
			       "Players can be attacked if they're on the same tile as another player. Attacking does damage based on a player's strength and dexterity. Players recieve damage based on the attacking player's damage, and their defensive stats, based on constitution. If attacking while no players are present, nothing will happen. Haha.");
	}
	if (source == examine) {
	    //move(0, 1);
	    System.out.println("\n\n" +
			       "Examining: \n" +
			       "Players automatically examine the tile they are standing on the beginning of every turn. Examinations tell a player about the type of tile they are standing on, and various other traits about the tile.");
	}
	if (source == lookafar) {
	    System.out.println ("\n\n" +
				"Looking: \n" +
				"Looking is the only way to see if players are near you. If you look at a tile that a player is standing on, you will be notified of their existence. Looking at tiles also tells you what type of tile they are. Looking can help you determine where you are on the map.");
	}
	if (source == move ) {
	    System.out.println ("\n\n" +
				"Moving: \n" +
				"Moving lets players gather more resources and attack each other. Moving onto the same time as another player allows them to attack each other."
		);
	}
	if (source == map) {
	    System.out.println ("\n\n" +
				"Map: \n" +
				"The tiles on the map represent different tile types. \n[ ^ ] Mountain +str \n[ O ] Lake +int/per \n[ _ ] Plains +con/fth \n[ T ] Forest +dex . In every map, there is one tile that holds a legendary excalibur weapon." );
	}
	if (source == harvest) {
	    System.out.println ("\n\n" +
				"Harvesting: \n" + 
				"Harvesting tiles has a percent chance to yield a stat bonus. Harvesting tiles makes players stronger. Each tile can only be harvested once. Forests and lakes are more likely to return food, while mountains and plains are more likely to return bonuses. One tile contains a legendary excalibur, that makes a player invincible and impossibly strong.");
	}
	if (source == hunger ) {
	    System.out.println ("\n\n" +
				"Hunger: \n" +
				"It costs a little bit of hunger per turn. After six consecutive turns of not eating, you will begin to lose health due to starvation. Eating food replenishes but does not always fully replenish the hunger bar. Being full slightly heals a little bit of health");
	}
	if (source == stats ) {
	    System.out.println ("\n\n" +
				"Stats: \n" +
				"Statistics affect qualities of a player. There are six different statistics, not including health.\n" +
				"Strength: Greatly increases damage on attacks.\n" +
				"Dexterity: Slightly increases both damage and defense.\n" +
				"Intelligence: Increases harvest success and slows starvation rate\n" +
				"Perception: Grants more detailed environment descriptions\n" +
				"Faith: Increases the chance at divine guidance\n" +
				"Constitution: Increases defense and slows starvation rate\n" +
				"Players die when their health decreases to 0. Different tiles increase different stats." );
				}
    }/*
	*/
    public static void setup(int _temp) {
        JFrame frame = new JFrame("Instructions");
	
	GuiStuff gui = new GuiStuff(_temp);
	frame.setContentPane(gui.createContentPane());
	//frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	
	frame.setSize(280, 490);
	frame.setResizable(false);
	frame.setVisible(true);
    }
    
    public static void main(String[] args) {
	int i = -2 + 5;
	System.out.println( i );
	setup(100);
	
	}

}

