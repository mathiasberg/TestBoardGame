package se.dragonappdev.testboardgame.util;

import java.util.ArrayList;
import java.util.List;

import se.dragonappdev.testboardgame.domain.Tile;

public class MapFactory {

	private int rows;
	private int cols;
	
	private static MapFactory instance = null;
	private List<Tile> tiles = new ArrayList<Tile>();
	
	private MapFactory()
	{
		rows = 3;
		cols = 3;
		
		tiles.add(TileFactory)
	}
	
}
