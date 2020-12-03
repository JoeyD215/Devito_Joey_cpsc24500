package start.Java;

import java.util.ArrayList;

public class TileChecker {
	
	/**
	 * 
	 * @param input: allows for tile to change per selected roll
	 * @return: if balance is true, the value is returned with changes
	 * @param mult: acts as a multiplier
	 */
public double max_pattern(ArrayList<Tile> input) { //this displays possibilities for max ranged bets
	int shapeMatch = 1;
	int colorMatch = 1;
	double mult = 0;
	for (int i = 0; i < input.size()-1;i++) {
		if(input.get(i).getShape() != input.get(i+1).getShape()){
			shapeMatch = 0;
			break;
		}
	}
	for (int i = 0; i < input.size()-1;i++) {
		if(input.get(i).getColor() != input.get(i+1).getColor()){
			colorMatch = 0;
			break;
		}
			
	}
	if (shapeMatch == 1 && colorMatch == 1) {
		mult = 100;
		return mult;
	}
	if (colorMatch == 1) {
		mult = 25;
		return mult;
	}
	return mult; //if bet is won, the multiplier pays out
	
}
/**
 * 
 * @param shapeMatch: checks to see if shapes rolled and if they match to decide multiplier
 * @param colorMatch: checks to see if colors rolled and if they match to decide multiplier
 */
public double mid_pattern(ArrayList<Tile> input) { //possibilities for mid range bet
	int shapeMatch = 1;
	int colorMatch = 1;
	double mult = 0;
	for (int i = 0; i < input.size()-1;i++) {
		if(input.get(i).getShape() != input.get(i+1).getShape()){
			shapeMatch = 0;
			break;
		}
	}
	for (int i = 0; i < input.size()-1;i++) {
		if(input.get(i).getColor() != input.get(i+1).getColor()){
			colorMatch = 0;
			break;
		}
			
	}
	if (shapeMatch == 1 && colorMatch == 1) {
		mult = 50;
		return mult;
	}
	if (colorMatch == 1) {
		mult = 10;
		return mult;
	}
	return mult;
}
	

public double min_pattern(ArrayList<Tile> input) { //minimum bet payout
	int shapeMatch = 1;
	int colorMatch = 1;
	double mult = 0;
	for (int i = 0; i < input.size()-1;i++) {
		if(input.get(i).getShape() != input.get(i+1).getShape()){
			shapeMatch = 0;
			break;
		}
	}
	for (int i = 0; i < input.size()-1;i++) {
		if(input.get(i).getColor() != input.get(i+1).getColor()){
			colorMatch = 0;
			break;
		}
			
	}
	if (shapeMatch == 1 && colorMatch == 1) {
		mult = 10;
		return mult;
	}
	if (colorMatch == 1) {
		mult = 5;
		return mult;
	}
	return mult;
}
}
