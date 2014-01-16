public class Player {

    //Instance Variables
    protected int _str;
    protected int _dex;
    protected int _int;
    protected int _fth;
    protected int _per;
    protected int _con;
    //protected Item[] inventory;
    protected int _xcor;
    protected int _ycor;

    //Constructor
    public Player() {
	_xcor = (int)(Math.randomInt * 8);
	_ycor = (int)(Math.randomInt * 8);
    }

    //accessor methods
    public int getStr()  {return _str;}
    public int getDex()  {return _dex;}
    public int getInt()  {return _int;}
    public int getFth()  {return _fth;}
    public int getPer()  {return _pet;}
    public int getCon()  {return _con;}
    public int getXcor() {return _xcor;}
    public int getYcor() {return _ycor;}

    //mutator methods
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

}
