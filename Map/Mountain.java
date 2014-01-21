import java.lang.Math;

public class Mountain extends Tile {

    public Mountain() {
	super();
	if ( Math.random() < .1 ) 
	    _item = new Item("muscle milk", 100,-50,-50,-50,-50,-50,100);
	else {
	    if ( (2* Math.random()) > 1 ) 
		_item = new Item("pick axe", 5,5,-5,10,0,0,0);
	    else 
		_item = new Item("dwarf potion",5,0,0,0,0,0,40);
	}
    }

    public String closeUp() {
	return "You find yourself on the slopes of a jagged mountain. Rocks lie all around you. The size of the mountain and sudden steepness of the slope astound you.";
    }
    public String farAway() {
	return "A tall mountain looms in the distance.";
    }


}
