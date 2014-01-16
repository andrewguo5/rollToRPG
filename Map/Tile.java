public abstract class Tile {

    
    protected boolean _isPlayerHere; //tracks if the tile is occupied
    protected boolean _used;       //tracks if the tile is harvested
    protected int _xcor;
    protected int _ycor;
    //protected Item _item;        //the item inside of the Tile

    /*Constructor
  
     */
    
    public Tile() {//***SHOULD BE INSTANTIATED AFTER PLAYER ARRAY***
        /////isPlayerHere();
	_used = false;
	//_item -> some sort of random selection of a set of items
    }
    
    //Accessors//
    public boolean getisPlayerHere() {return _isPlayerHere;}
    public boolean getUsed() {return _used;}
    public int getXcor() {return _xcor;}
    public int getYcor() {return _ycor;}

    //Checks
    /*
     public void isPlayerHere() {
   	_isPlayerHere = Map.getPlayer(_xcor, _ycor) != null;
      }
     */
    
    //Mutator
    public void setUsed(boolean h) {
	_used = h;
    }
	    

    //Methods
    abstract String closeUp();     
    // abstract Item findItem();
    abstract String farAway();

}
