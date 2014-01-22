import java.lang.Math;

public class Lake extends Tile {

    private int Type = 1;
    //name, str, dex, int, fth, per, con, hp
    public Lake() {
	super();
	double random = 6*Math.random();
	if ( random > 4 ) 
	    _item = new Item("trident (+10 int, +5 per).",0,0,10,0,5,0,0,0);
	else if ( random > 1 )
	    _item = new Item("delicious fish (mm tasty).",0,0,0,0,0,0,0,4);
	    _item = new Item("fancy treasure chest (+20 int, +5 per).",0,0,20,0,5,0,0,0);
    }
    
    public String closeUp() {
	return "You stand at the banks of a small lake, with marshy grass and mud underneath your feet. The wind brushes against the lake, brushing delicate ripples on its surface.";
    }
    public String farAway() {
	String ret = "It appears to be a small lake in the distance.";
	if (_isPlayerHere) 
	    ret += "You see a lone figure stopping by for a drink in the distance, is it a friend or a foe?";
	else if (slender) 
	    ret +=  " There seems to be a faceless tall figure walking out of the water. He doesn't seem to have noticed you yet.";
	return ret;
    }

}
