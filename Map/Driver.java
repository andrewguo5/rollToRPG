import cs1.Keyboard;
import java.lang.Math;

public class Driver {

    public static boolean islegitDirection(String d) {
	return( d.equals("north") || d.equals("south") || d.equals("west") || d.equals("east") || d.equals("northwest") || d.equals("northeast") || d.equals("southeast") || d.equals("southwest")|| d.equals("south west") || d.equals("south east") || d.equals("north west") || d.equals("north east") );
    }

    public static void main (String[] args) {
	System.out.print("Enter the name of player1: ");
	String name1 = Keyboard.readString();
	System.out.print("\nEnter the name of player2: ");
	String name2 = Keyboard.readString();
	while (name1.equals(name2) ) {
	    System.out.print("\nName already exists! New name: ");
	    name2 = Keyboard.readString();
	}
	System.out.print("\nEnter the name of player3: ");
	String name3 = Keyboard.readString();
	while (name3.equals(name2) || name3.equals(name1)) {
	    System.out.print("\nName already exists! New name: ");
	    name3 = Keyboard.readString();
	}	
	Map map = new Map(name1, name2, name3);
	
	while (map.getplayerList().size() > 1) {
	    
	    for (Player temp: map.getplayerList()) {
		if (temp.getHP() > 0) {
		    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\nTurn begin: " + temp.getName());
		    System.out.println("\n\n");
		    System.out.println( map.getTileMap()[temp.getXcor()][temp.getYcor()].closeUp() ); //examine
		    temp.setActionsLeft(3);
		    while (temp.getActionsLeft() > 0) {
			System.out.println("\n\n\nWhat do you want to do? (Actions left: " + temp.getActionsLeft() + " )" );
			System.out.println("'look'- Look at a neighboring tile (Costs 1 move)");
			System.out.println("'harvest'- Search for bonuses on current tile (Costs 3 moves)");
			System.out.println("'attack'- Swing your sword wildly (Costs 2 moves)");
			System.out.println("'move'- Run blindly into a neighboring tile (Costs 1 move)");
			System.out.println("'help'- Open help panel");
			System.out.println("'map'- Open map");
			int sDiffX = temp.getXcor() - map.getsX();
                	int sDiffY = temp.getYcor() - map.getsY();
                 	if ( Math.abs(sDiffX) <= 1 && Math.abs(sDiffY) <= 1 ) {
                            System.out.println("\nYou feel a strange sense of foreboding, something sinister is lurking in the area. Be weary of where you step.\n");
                 }
			
			String response = Keyboard.readString();
			if (response.equals("look") ) {
			    String direction = "";
			    System.out.println("What direction do you want to look in?");
			    direction = (Keyboard.readString()).toLowerCase();
			    while ( !islegitDirection(direction) ) {
				System.out.println("I don't know what direction " + direction + " is in.");
				System.out.println("What direction do you want to look in?");
				direction = (Keyboard.readString()).toLowerCase();
			    }
			    temp.setLooking(true, direction);
			    System.out.println("\n\n");
			    map.updatePlayer(temp);
			    temp.setActionsLeft(temp.getActionsLeft() - 1 );
			}
			else if (response.equals("move") ) {
			    String direction = "";
			    System.out.println("What direction do you want to move in?");
			    direction = (Keyboard.readString()).toLowerCase();
			    while ( !islegitDirection(direction) ) {
				System.out.println("I don't know what direction " + direction + " is in.");
				System.out.println("What direction do you want to look in?");
				direction = (Keyboard.readString()).toLowerCase();
			    }
			    temp.move(direction);
			    temp.setMoving(true);
			    System.out.println("\n\n");
			    map.updatePlayer(temp);
			    temp.setActionsLeft(temp.getActionsLeft()-1);
			}
			else if (response.equals("harvest") ) {
			    if (temp.getActionsLeft() < 3) {
				System.out.println("There isn't enough time left to do that. Let's do something else.");
			    }
			    else {
				temp.setHarvesting(true);
				System.out.println("\n\n");
				map.updatePlayer(temp);
				temp.setActionsLeft(temp.getActionsLeft() - 3);
			    }
			}
			else if (response.equals("attack") ) {
			    if (temp.getActionsLeft() < 2) {
				System.out.println("Let's do that when it's earlier. It'll take forever to swing your sword across this whole tile.");
			    }
			    else {
				temp.setAttacking(true);
				System.out.println("\n\n");
				map.updatePlayer(temp);
				temp.setActionsLeft(temp.getActionsLeft() -2);
			    }
			}
			else if (response.equals("map")) {
			    System.out.println("You take out your trusty scroll and examine the area: \n\n");
			    System.out.println("\n\n");
			    System.out.println(map.returnMap());
			    System.out.println("\nN ->");
			
			}
			else if (response.equals("help")) {
			    GuiStuff.setup(temp.getHP());
			}
			else {
			    System.out.println("\n\nThis game is very sensitive to spelling. It had a traumatizing childhood experience. Leave out spaces and ' when entering commands!");
			}
		    }
		    temp.setHunger( temp.getHunger() - 1);
		    System.out.println("\n");
		    

		    if ( temp.getFth() > (int)(Math.random() * 100) ) {
			String exRet = "You sense a strong magical force from the ";
			int xDiff = temp.getXcor() - map.getExX();
			int yDiff = temp.getYcor() - map.getExY(); 
			
			if ( xDiff > 0 && yDiff == 0 ) 
			    exRet += "east.";
			else if ( xDiff < 0 && yDiff == 0 )
			    exRet += "west.";
			else if ( xDiff == 0 && yDiff > 0 ) 
			    exRet += "north.";
			else if ( xDiff == 0 && yDiff < 0 )
			    exRet += "south.";
			else if ( xDiff > 0 && yDiff > 0 )
			    exRet += "north east.";
			else if ( xDiff < 0 && yDiff > 0 ) 
			    exRet += "north west.";
			else if ( xDiff > 0 && yDiff < 0 )
			    exRet += "south east.";
			else if ( xDiff < 0 && yDiff < 0 )
			    exRet += "south west.";
			else {
			    exRet = "You feel an incredible surge of power in your veins. A lightning bolt strikes the ground before your feet. You've found the it! Excalibur (All stats maxed).";}
			System.out.println(exRet);
		    }	    


		    
		    System.out.println("\n\n");

		    if ( temp.getHunger() > 10 ) { 
		    	if ( temp.getHP() < 100 ) {
			temp.setHP( temp.getHP() + 10 );
			System.out.println("You've eaten well recently. You have restored a bit of health");
			temp.setHP( (temp.getHP() + 500) % 100);
		    	}
			temp.setHunger(10);
		    }
		    
		    else if (temp.getHunger() < 6 && temp.getHunger() >= 2) {
			System.out.println("Your stomach rumbles. You haven't eaten in ages. You're hungry. Find food in a forest or lake.");
		    }
		    else if (temp.getHunger() < 2 && temp.getHunger() >= 0) {
			System.out.println("You are very hungry. You may start starving if you don't find food fast. Harvest forest and lake tiles for food.");
			temp.setHP(temp.getHP() + (temp.getHunger() * 10));
		    }
		    else if (temp.getHunger() < 0) {
			System.out.println("Oh no! You're starving! You take " + (temp.getHunger()*10) + " damage due to hunger pangs.");
			temp.setHP(temp.getHP() + (temp.getHunger() * 10));
		    }
		    
		    if (temp.getHP() <= 0) {
			map.killPlayer(temp.getName());
			System.out.println("\n\nYou have died! Oh no. What a tragedy. Oh well.");
		    }
		    else if (map.getTileMap()[temp.getXcor()][temp.getYcor()].getSlender() ){
			map.killPlayer(temp.getName());
			System.out.println("\n\nYou feel the darkness washing over you as you freeze in fear. As the faceless man walks towards you you realize it's the end: you have died.");   
		    }
		}
	        else {
			System.out.println(temp.getName() + ", you are dead! Sit tight. Your turn will end immediately.");
		    }
		System.out.println("\n\nTurn is over! Enter any key to continue");
		String stop = Keyboard.readString();
	    }
		    
	    map.updateSlender();
		
	        
	}
    }
}

