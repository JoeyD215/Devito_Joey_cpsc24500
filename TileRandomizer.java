package start.Java;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

public class TileRandomizer extends JPanel {
	
/**
 * 
 * @param input: random input value for rolls
 * @param rnd: randomizer
 * @return: returns final roll
 */
	public ArrayList<Tile>  spin(ArrayList<Tile> input, Random rnd) {
		// Auto-generated method 
		
		
		for (int i = 0; i < 400; i++) {
			if(i < 100) {
				for (int j = 0; j < 4; j++) {
					input.get(j).setRandomly(rnd); //tile randomized set amount of times
				}
			}else if (i < 200) {
				for (int j = 0; j < 3; j++) {
					input.get(j).setRandomly(rnd);
				}
			}else if (i < 300) {
				for (int j = 0; j < 2; j++) {
					input.get(j).setRandomly(rnd);
				}
			}else {
				input.get(0).setRandomly(rnd); //tile(rnd)
			}
			try {
				Thread.sleep(10);
			}catch (Exception ex) {
				
			}
	
		}
		return input;
	}
}
