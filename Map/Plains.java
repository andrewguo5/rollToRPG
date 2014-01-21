public class Plains extends Tile {

    public Plains() {
	super();
	if ( (2* Math.random()) > 1 ) 
	    _item = new Item("bow and arrow",20,10,0,0,0,5,0);
	else 
	    _item = new Item("Buffalo horn filled with eucalyptus juice",0,0,0,0,70,0,20);
    }


    public String closeUp() {
	return "You are walking in the midst of a grassy plain. Slight breezes make wave patterns on the wild grass. The air is filled with the sound of grass blades brushing against another.";
    }
    public String farAway() {
	return "There lies a grassy plain.";
    }


}
