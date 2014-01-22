import java.lang.Math;

public class Mountain extends Tile {

    public Mountain() {
	super();
	if (100* Math.random() < 1 ) 
	    _item = new Item("ancient knowledge (+100 str).", 100,0,0,0,0,0,0,0);
	else {
	    if ( (3* Math.random()) > 1 ) 
		_item = new Item("pick axe (+15 str).", 15,0,0,0,0,0,0,0);
	    else 
		_item = new Item("dwarf potion (+30 str).",30,0,0,0,0,0,0,0);
	}
    }
    public String closeUp() {
	return "You find yourself on the slopes of a jagged mountain. Rocks lie all around you. The size of the mountain and sudden steepness of the slope astound you.";
    }
    public String farAway() {
	String ret = "A tall mountain looms in the distance.";
	if ( _isPlayerHere )
	    ret += " You see a shadow dancing in the fog of the mountain, moving in and out of the impassive boulders."; 
	else if (slender) 
	    ret += " You see the air shimmer in between two boulders, and feel a sudden sense of dread. Might be a good time to run.";
	return ret;
    }



}
