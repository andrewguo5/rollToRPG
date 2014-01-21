import java.util.ArrayList;
import java.lang.Math;

public class Map {
        
    private Tile[][] _map = new Tile[8][8];
    private Player[][] _players = new Player[8][8];
    private ArrayList<Player> _playerList = new ArrayList<Player>(); //probably will be taken from a different class, perhaps one that handles character creation


    /*Constructor
      Should create an 8x8 double array full of Tiles, stored in _map
      Should create an 8x8 double array of type Player, storing a Player in a random location and null in other locations
     */
    public Map( String N1, String N2, String N3 ){//int numPlayers) { //takes number of players upon the completion for character creation. generates a map based on the number of players
	/*Player Bob = new Player("bob");
	  _playerList.add(Bob);*/
    
	
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
	_playerList.add( new Player( N1 ) );
	_playerList.add( new Player( N2 ) );
	_playerList.add( new Player( N3 ) );
	
	for ( Player p : _playerList ) {
	    int x = (int)(8 * Math.random());
	    int y = (int)(8 * Math.random());
	    p.teleport(x,y);
	    updatePlayer(p);
	}
 
    }		
    //ACCESSOR
    public ArrayList<Player> getplayerList() {
	return _playerList;
    }
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
		_playerList.remove(n);
		break;
	    }
	}
    }

   
    public void harvestM( Player richard ) {
	int x = richard.getXcor();
	int y = richard.getYcor();
	Tile t = _map[x][y];
	Item i = t.getItem();
	if ( ! t.getUsed() ) {
	    richard.setStr( i.gets() );
	    richard.setDex( i.getd() );
	    richard.setFth( i.getf() );
	    richard.setInt( i.geti() );
	    richard.setPer( i.getp() );
	    richard.setCon( i.getc() );
	    richard.setHP( i.geth() );
	}
	t.setUsed(true);
    }

    public void moveM( Player richard ) {

		int _newXcor = richard.getMX() % 8;
		int _newYcor = richard.getMY() % 8;
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
	if ( dir.equals("north") ) 
	    System.out.println( getTile(richard.getXcor(),richard.getYcor()+1).farAway());
	
	else if ( dir.equals("east") ) 
	    System.out.println( getTile(richard.getXcor()+1,richard.getYcor()).farAway());
	
	else if ( dir.equals("south") )
	    System.out.println( getTile(richard.getXcor(),richard.getYcor()-1).farAway());
	
	else if ( dir.equals("west") )
	    System.out.println( getTile(richard.getXcor()-1,richard.getYcor()).farAway());
	
	else if ( dir.equals("north east") )
	    System.out.println( getTile(richard.getXcor()+1,richard.getYcor()+1).farAway());
	
	else if ( dir.equals("north west") )
	    System.out.println( getTile(richard.getXcor()-1,richard.getYcor()+1).farAway());
	
	else if ( dir.equals("south east") )
	    System.out.println( getTile(richard.getXcor()+1,richard.getYcor()-1).farAway());
	
	else {
	    System.out.println( getTile(richard.getXcor()-1,richard.getYcor()-1).farAway());}
	richard.setLooking(false,"");
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

    public static void main (String[] args) {
	Map xyzz = new Map("fred","jon","tom");
	System.out.println( xyzz );

  
    }



}
