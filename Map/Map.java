import java.util.ArrayList;
import java.lang.Math;

public class Map {
        
    private Tile[][] _map = new Tile[8][8];
    private Player[][] _players = new Player[8][8];
    private ArrayList<Player> _playerList = new ArrayList<Player>(); 
    private ArrayList<Player> _deadPlayerList = new ArrayList<Player>();
    private int exX;
    private int exY;
    private int sX;
    private int sY; 

    public Map( String N1, String N2, String N3 ){
    
	for (Tile[] x : _map) {
	    for (int n = 0; n < x.length; n++) {
		int randInt = (int)(Math.random() * 4);
		if (randInt == 0) {
		     x[n] = new Mountain();
		}
		if (randInt == 1) {
		    x[n] = new Lake();
		}
		if (randInt == 2) {
		    x[n] = new Plains();
		}
		if (randInt == 3) {
		    x[n] = new Forest();
		}
	    }
	}

	sX = (int)(Math.random() * 8);
	sY = (int)(Math.random() * 8);
	_map[sX][sY].setSlender(true);

	exX = (int)(Math.random() * 8);
	exY = (int)(Math.random() * 8);
	_map[exX][exY].setEx(true);
	Item excalibur = new Item("excalibur",100000,0,0,0,0,0,100000,0);
	_map[exX][exY].setItem( excalibur );
	_map[exX][exY].setChance(.125);
	
	_playerList.add( new Player( N1 ) );
	_playerList.add( new Player( N2 ) );
	_playerList.add( new Player( N3 ) );
	
	for ( Player p : _playerList ) {
	    int x = (int)(8 * Math.random());
	    int y = (int)(8 * Math.random());
	    p.teleport(x,y);
	    p.setMoving(true);
	    updatePlayer(p);
	}
 
    }		
    //ACCESSOR
    public int getExX() { return exX; }
    public int getExY() { return exY; }
    public int getsX() { return sX; }
    public int getsY() { return sY; }

    public ArrayList<Player> getplayerList() {
	return _playerList;
    }
    public ArrayList<Player> getDeadPlayerList() { return _deadPlayerList; }
    public Tile[][] getTileMap() { return _map; }
    public Player[][] getPlayerMap() { return _players; }
    
    //Movement related methods
    public void addPlayer( Player p ) {
	_playerList.add( p ); }

    public void updatePlayer( Player p ) { //runs all player actions 	
	for (Player richard : _playerList) {
	    if ( richard.getMoving() ) {
		moveM(richard);
	    }
	    if ( richard.getAttacking() ) {
		attackM(richard);
	    }
	    if ( richard.getLooking() ) {
		lookM(richard);
	    }
	    if ( richard.getHarvesting() ) {
		harvestM(richard);
	    }
	}
    }

    public void setNull(int x, int y) {//sets a tile to null in the player 8x8 array. This kills the player, usually during moves, to recreate it with updatePlayers()
	_players[x][y] = null;
    }
    
    //Coordinate based Accessors
    public Tile getTile(int x, int y) {
	return _map[x][y];
    }
    
    public Player getPlayer(int x, int y) {
	return _players[x][y];
    }


    public boolean isPlayerHere(int x, int y) {
	return _players[x][y] != null;
    }    

    public void attack( String Pname, int dmg  ) {
	for ( int n = 0; n < _playerList.size(); n++ ) {
	    Player p = _playerList.get(n);
	    if ( p.getName().equals( Pname ) ) {
		p.setHP( p.getHP() - dmg );
	    }
	}
    }

    public void killPlayer( String Pname ) {
	for ( int n = 0; n < _playerList.size(); n++ ) {
	    Player p = _playerList.get(n);
	    if ( p.getName().equals( Pname ) ) {
		setNull( p.getXcor(), p.getYcor() );
		_deadPlayerList.add(p);
		break;
	    }
	}
    }

   
    public void harvestM( Player richard ) {
	int x = richard.getXcor();
	int y = richard.getYcor();
	Tile t = _map[x][y];
	Item i = t.getItem();
	int hc = richard.getHarvestCtr();
	if ( hc >= 2 ) { richard.setChance(1); }
	else if ( hc >= 1 ) { richard.setChance(.75); }
		
	if ( ! t.getUsed() && richard.getChance() > Math.random() ) {
	    richard.setStr(richard.getStr() + i.gets() );
	    richard.setDex(richard.getDex() + i.getd() );
	    richard.setFth(richard.getFth() + i.getf() );
	    richard.setInt(richard.getInt() + i.geti() );
	    richard.setPer(richard.getPer() + i.getp() );
	    richard.setCon(richard.getCon() + i.getc() );
	    richard.setHP(richard.getHP() + i.geth() );
	    t.setUsed(true);
	    System.out.println("You found a(n) " + i.getN() );
	    richard.setHarvestCtr(0);
	    richard.setChance(.5);
	}
	else {
	    richard.setHarvestCtr( hc + 1 );
	    System.out.println("After rummaging through your surroundings you find nothing of use."); }
	richard.setHarvesting(false);
        
    }

    public void moveM( Player richard ) {

	int _newXcor = (richard.getMX()+80) % 8;
	int _newYcor = (richard.getMY()+80) % 8;
	Player freshRichard = richard;
		
		_players[_newXcor][_newYcor] = new Player(richard.getName());
		_players[_newXcor][_newYcor] = freshRichard;
		
		setNull( richard.getXcor(), richard.getYcor() );
		
		_map[richard.getXcor()][richard.getYcor()].setisPlayerHere( false );
		_map[_newXcor][_newYcor].setisPlayerHere( true );
	    
		richard.setXcor( _newXcor );
		richard.setYcor( _newYcor );
		richard.setMoving(false);
    }

    public void attackM( Player richard ) {
	String target = "";
	int dmg = 0;
	for ( Player p : _playerList ) {
	    if (p.getXcor() == richard.getXcor() && p.getYcor() == richard.getYcor() && p.getName() != richard.getName() ) { 
		dmg = richard.getStr();
		p.setHP( p.getHP() - dmg);
		target += p.getName() + " ";}
	}
	richard.setAttacking(false);
	System.out.println("You attacked " + target + "for " + dmg + " hp.");  
    }

    public void lookM( Player richard ) {	
  	String dir = richard.getDir();
	int _xcor = richard.getXcor() % 8; 
	int _ycor = richard.getYcor() % 8;
	if ( dir.equals("north") )  
	    System.out.println( getTile(_xcor, (_ycor+1)%8 ).farAway());
	
	else if ( dir.equals("east") ) 
	    System.out.println( getTile((_xcor+1)%8, _ycor).farAway());
	
	else if ( dir.equals("south") )
	    System.out.println( getTile(_xcor, (_ycor+7)%8).farAway());
	
	else if ( dir.equals("west") )
	    System.out.println( getTile((_xcor+7)%8, _ycor).farAway());
	
	else if ( dir.equals("north east") || dir.equals("northeast") )
	    System.out.println( getTile((_xcor+1)%8, (_ycor+1)%8).farAway());
	
	else if ( dir.equals("north west") || dir.equals("northwest") )
	    System.out.println( getTile((_xcor+7)%8, (_ycor+1)%8).farAway());
	
	else if ( dir.equals("south east")|| dir.equals("southeast") )
	    System.out.println( getTile((_xcor+1)%8, (_ycor+7)%8).farAway());
	
	else if ( dir.equals("south west") || dir.equals("southwest") ) 
	    System.out.println( getTile((_xcor+7)%8, (_ycor+7)%8).farAway());
    else { System.out.println("Sorry, that's not a direction"); }
	richard.setLooking(false,"");
    }

    public void updateSlender() { 
	_map[sX][sY].setSlender(false);
	int x = (int)(3* Math.random() - 1);
	int y = (int)(3* Math.random() - 1);
	sX += x;
	sX %= 8;
	sY += y;
	sY %= 8;
	_map[sX][sY].setSlender(true);
    }

    public String toString() {
	String retStr = "";
	for (Tile[] x : _map) {
	    for (Tile y : x) {
		if ( y.getisPlayerHere() ) 
		    retStr += "-(-";
		else
		    retStr += " [ ";
		
		if (y instanceof Mountain) {
		    retStr += "^";
		}
		if (y instanceof Lake) {
		    retStr += "O";
			}
		if (y instanceof Plains) {
		    retStr += "_";
		}
		if (y instanceof Forest) {
		    retStr += "T";
		}
		if ( y.getisPlayerHere() ) 
		    retStr += "-)-";
		else
		    retStr += " ] ";
		
		//retStr += "[O]";
	    }
	    retStr += "\n";
	}
	return retStr;
    }    

    public String returnMap() {
	String retStr = "";
	for (Tile[] x : _map) {
	    for (Tile y : x) {
		retStr += " [ ";
		
		if (y instanceof Mountain) {
		    retStr += "^";
		}
		if (y instanceof Lake) {
		    retStr += "O";
		}
		if (y instanceof Plains) {
		    retStr += "_";
		}
		if (y instanceof Forest) {
		    retStr += "T";
		}
		retStr += " ] ";
		
		//retStr += "[O]";
	    }
	    retStr += "\n";
	}
	return retStr;
    }

    public static void main (String[] args) {
	Map xyzz = new Map("fred","jon","tom");
	System.out.println( xyzz );
	System.out.println(-1%8);
  
    }



}
