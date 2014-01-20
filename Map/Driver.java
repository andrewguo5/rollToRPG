import cs1.Keyboard;

public class Driver {
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
		System.out.println("Turn begin");
		System.out.println( map.getTileMap()[fred.getXcor()][fred.getYcor()].closeUp() );
		
		TestFrame test = new TestFrame();
	        String Test = Keyboard.readString();
	    }
	}


    }
}
