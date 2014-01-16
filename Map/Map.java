import java.util.ArrayList;
import java.lang.Math;

public class Map {
        
    private Tile[][] _map = new Tile[8][8];
    private Player[][] _players = new Player[8][8];
    //////    private ArrayList _playerList; //probably will be taken from a different class, perhaps one that handles character creation


    /*Constructor
      Should create an 8x8 double array full of Tiles, stored in _map
      Should create an 8x8 double array of type Player, storing a Player in a random location and null in other locations
     */
    public Map(){//int numPlayers) { //takes number of players upon the completion for character creation. generates a map based on the number of players
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
	/////_playerList = new ArrayList(); //I want to create a list of all the players
	/////updatePlayers(); //Set all players to their respective coordinates
    }		 
    /*
    //Movement related methods
    public void updatePlayers() { //creates players at their player coordinates
	for (Player richard : _playerList) {
	    //int xcor = richard.getXcor();
	    //int ycor = richard.getYcor();
	    Player freshRichard = richard;
	    //_players[xcor][ycor] = new Player();//currently creates only default players, I need this to clone the player and make it appear at the new tile.
	    _players[xcor][ycor] = freshRichard;
	}
    }

    public void setNull(int x, int y) {//sets a tile to null in the player 8x8 array. This kills the player, usually during moves, to recreate it with updatePlayers()
	_players[xcor][ycor] = null;
    }
    */
    //Coordinate based Accessors
    public Tile getTile(int x, int y) {
	return _map[x][y];
    }
    /*
    public Player getPlayer(int x, int y) {
	return _players[x][y];
    }
    */

    public String toString() {
	String retStr = "";
	for (Tile[] x : _map) {
	    for (Tile y : x) {
		if (y instanceof Mountain) {
		    retStr += "[^]";
		}
		if (y instanceof Lake) {
		    retStr += "[O]";
			}
		if (y instanceof Plains) {
		    retStr += "[_]";
		}
		if (y instanceof Forest) {
		    retStr += "[T]";
		}
		
		//retStr += "[O]";
	    }
	    retStr += "\n";
	}
	return retStr;
    }

    public static void main (String[] args) {
	Map xyzz = new Map();
	System.out.println( xyzz );
    }



}
