public abstract class Tile {

    public boolean slender = false; 
    protected boolean ex = false;
    protected double chance;
    protected boolean _isPlayerHere; //tracks if the tile is occupied
    protected boolean _used = false;       //tracks if the tile is harvested
    protected int _xcor;
    protected int _ycor;
    protected Item _item;        //the item inside of the Tile

    /*Constructor
  
     */
    
    public Tile() {
	chance = .50; 
        _isPlayerHere = false;
	_used = false;
	
    }
    
    //Accessors//
    public boolean getSlender() { return slender; }
    public boolean getEx() { return ex; }
    public double getChance() { return chance; }
    public boolean getisPlayerHere() {return _isPlayerHere;}
    public boolean getUsed() {return _used;}
    public int getXcor() {return _xcor;}
    public int getYcor() {return _ycor;}
    public Item getItem() { return _item; }

    //Mutator
    public void setChance(double d) {
	chance = d;
    }
   public void setSlender( boolean b ) {
	slender = b;
    }
    
    public void setItem( Item i ) {
	_item = i;
    }
    
    public void setEx( boolean b ){
	ex = b;
    }

    public void setUsed(boolean h) {
	_used = h;
    }
    
    public boolean setisPlayerHere(boolean h) {
	_isPlayerHere = h;
	return !h;
    }
	    
    //Methods
    abstract String closeUp();     
    // abstract Item findItem();
    abstract String farAway();

}
