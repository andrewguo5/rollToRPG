import java.lang.Math;

public class Player {

    //Instance Variables
   
    protected boolean _harvesting = false; 
    protected boolean _attacking = false;
    protected boolean _moving = false ;
    protected boolean _looking = false;
    protected String _dir;

    protected int _actionsLeft;
    protected String _name;
    protected int HP;
    
    protected int _str;
    protected int _dex;
    protected int _int;
    protected int _fth;
    protected int _per;
    protected int _con;
    protected int _xcor;
    protected int _ycor;

    protected int _moveX;
    protected int _moveY;

    //Constructor
    public Player( String name ) {
	
	_actionsLeft = 3;
	HP = 100;
	
	_str = 10;
	_dex = 10;
	_int = 10;
	_fth = 10;
	_per = 10;
	_con = 10;

	_name = name; 
	_xcor = (int)(Math.random() * 8);
	_ycor = (int)(Math.random() * 8);
	_moveX = _xcor;
	_moveY = _ycor;
    }

    //public void ability()

    //accessor methods
   
    public String getDir() { return _dir; }
    public int getActionsLeft() { return _actionsLeft; }
    public int getHP() { return HP; }
    public int getStr()  {return _str;}
    public int getDex()  {return _dex;}
    public int getInt()  {return _int;}
    public int getFth()  {return _fth;}
    public int getPer()  {return _per;}
    public int getCon()  {return _con;}
    public int getXcor() {return _xcor;}
    public int getYcor() {return _ycor;}
    public int getMX() {return _moveX; }
    public int getMY() {return _moveY; }
    public String getName() { return _name; }

    public boolean getAttacking() { return _attacking; }
    public boolean getMoving() { return _moving; }
    public boolean getLooking() { return _looking; }
    public boolean getHarvesting() { return _harvesting; }
   

    //mutator methods
    public void setActionsLeft(int val) {
	_actionsLeft = val; }
    
    public int setHP(int val) {
	int oldVal = HP;
	HP = val;
	return oldVal;
    }

    public int setStr(int val) {
	int oldVal = _str;
	_str = val;
	return oldVal;
    }
    public int setDex(int val) {
	int oldVal = _dex;
	_dex = val;
	return oldVal;
    }
    public int setInt(int val) {
	int oldVal = _int;
	_int = val;
	return oldVal;
    }
    public int setFth(int val) {
	int oldVal = _fth;
	_fth = val;
	return oldVal;
    }
    public int setPer(int val) {
	int oldVal = _per;
	_per = val;
	return oldVal;
    }
    public int setCon(int val) {
	int oldVal = _con;
	_con = val;
	return oldVal;
    }    
    public int setXcor(int val) {
	int oldVal = _xcor;
	_xcor = val;
	return oldVal;
    }   
    public int setYcor(int val) {
	int oldVal = _ycor;
	_ycor = val;
	return oldVal;
    }
    public void move( String dir ) {
	int x = 0;
	int y = 0;

	if ( dir.equals("north") ) 
	    y = 1;
	   
	else if ( dir.equals("east") ) 
	    x = 1;
	
	else if ( dir.equals("south") )
	    y = -1;
	    
	else if ( dir.equals("west") )
	    x = -1;
	    
	else if ( dir.equals("north east") ){
	    x = 1;
	    y = 1; 
	}
	            
	else if ( dir.equals("north west") ){
	    x = -1;
	    y = 1;
	} 
	else if ( dir.equals("south east") ){
	    x = 1;
	    y = -1; 
	}
	  
	   
	else { 
	    x = -1;
	    y = -1;
	}
	_moveX = _xcor + x;
	_moveY = _ycor + y; 
	
    }	

    public void setAttacking( boolean b ) {
	_attacking = b;
    }
    public void setLooking( boolean b, String d ) {
	_looking = b;
	_dir = d;
    }
    public void setMoving( boolean b ) {
	_moving = b; 
    }
    public void setHarvesting( boolean b ) {
	_harvesting = b; 
    }
    public void teleport( int x, int y ) {
	_moveX = x;
	_moveY = y;
    }
	
}
