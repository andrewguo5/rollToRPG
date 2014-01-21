import java.lang.Math;

public class Lake extends Tile {

    private int Type = 1;
    
    public Lake() {
	super();
	if ( (2* Math.random()) > 1 ) 
	    _item = new Item("treasure chest", 0,0,5,20,0,10,0);
	else 
	    _item = new Item("trident",10,5,5,-5,0,5,0);
    }
    
    public String closeUp() {
	return "You stand at the banks of a small lake, with marshy grass and mud underneath your feet. The wind brushes against the lake, brushing delicate ripples on its surface.";
    }
    public String farAway() {
	return "It appears to be a small lake in the distance.";
    }

}
