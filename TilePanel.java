package start.Java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * 
 * @param whichTile: allows selection and change to be made from 1 of 4 tiles
 * function bSpin and Spin allows for the intro to spin on startup
 */
public class TilePanel extends JPanel implements MouseListener { //listener allows for different user abilities
	private ArrayList<Tile> tiles;
	private Random rnd;
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) { //mouselistener being used for clicks 
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	public TilePanel() { //tiles will be randomized from arraylist
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		addMouseListener(this);
	}
	public void bSpin() {
		TileRandomizer a = new TileRandomizer();
		tiles = a.spin(tiles, rnd);
		repaint(); //spins tiles and variates them per roll
	}
	public void spin() {
		for (int i = 0; i < 400; i++) {
			if(i < 100) {
				for (int j = 0; j < 4; j++) {
					tiles.get(j).setRandomly(rnd);
				}
			}else if (i < 200) {
				for (int j = 0; j < 3; j++) {
					tiles.get(j).setRandomly(rnd);
				}
			}else if (i < 300) {
				for (int j = 0; j < 2; j++) {
					tiles.get(j).setRandomly(rnd);
				}
			}else {
				tiles.get(0).setRandomly(rnd);
			}
			try {
				Thread.sleep(10);
			}catch (Exception ex) {
				
			}
			repaint();
		}
	}
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	/**
	 * 	
	 * @param cellWidth: represents the range/width of the tiles
	 * @param tileSize: dictates overall size of tiles
	 * Function for paintComponent allows shape to obtain a color based on numeric value
	 */
	public Random getRnd() {
		return rnd; //random function implementation
	}
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	@Override
	public void paintComponent(Graphics g) { //tile requirements 
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
		}
	}
}
