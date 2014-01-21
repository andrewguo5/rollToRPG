import cs1.Keyboard;

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
	    
	    for (Player fred: map.getplayerList()) {
		Player temp = fred;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nTurn begin");
		System.out.println("\n\n");
		System.out.println( map.getTileMap()[temp.getXcor()][temp.getYcor()].closeUp() ); //examine
		while (temp.getActionsLeft() > 0) {
		    System.out.println("\n\n\nWhat do you want to do? (Actions left: " + temp.getActionsLeft() + " )" );
		    System.out.println("'look'- Look at a neighboring tile (Costs 1 move)");
		    System.out.println("'harvest'- Search for bonuses on current tile (Costs 3 moves)");
		    System.out.println("'attack'- Swing your sword wildly (Costs 2 moves)");
		    System.out.println("'move'- Run blindly into a neighboring tile (Costs 1 move)");
		    System.out.println("'help'- Open help panel");
		    System.out.println("'map'- Open map");
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
		}
		    
		System.out.println("Turn is over! Enter any key to continue");
		String stop = Keyboard.readString();
	
		
	        
	    }
	}
    }
}
