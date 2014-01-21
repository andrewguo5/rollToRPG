import java.lang.Math;

public class Plains extends Tile {
    //name, str, dex, int, fth, per, con, hp

    public Plains() {
	super();
	if ( (3* Math.random()) > 1 ) 
	    _item = new Item("rough grass (+10 con, +5 fth).",0,0,0,5,0,10,0,0);
	else 
	    _item = new Item("buffalo horn filled with eucalyptus juice (+20 con, +5 fth).",0,0,0,5,0,20,0,0);
    }


    public String closeUp() {
	return "You are walking in the midst of a grassy plain. Slight breezes make wave patterns on the wild grass. The air is filled with the sound of grass blades brushing against another.";
    }
    public String farAway() {
	String ret ="There lies a grassy plain.";
	if (_isPlayerHere) 
	    ret += " You notice a warrior out in the open. Now is your chance to strike.";
	return ret;
    }


}
