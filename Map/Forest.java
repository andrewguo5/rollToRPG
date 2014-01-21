import java.lang.Math;

public class Forest extends Tile {
    
    public Forest() {
	super();
	if ( (2* Math.random()) > 1 ) 
	    _item = new Item("axe", 10,-5,-5,5,0,0,0);
	else 
	    _item = new Item("cooked squirrel",0,0,0,0,0,0,20);
    }
	


    public String closeUp() {
	return "A dense forest. Sunlight streams through the canopy above, revealing brushy undergrowth and faint tracks etched into the ground. Birds chirp and flit from branch to branch above your head.";
    }
    public String farAway() {
	return "In the distance, it looks like the beginnings of a large forest.";
    }


}
