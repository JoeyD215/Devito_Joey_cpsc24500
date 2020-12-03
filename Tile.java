package start.Java;
//imports
import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

/**
 * 
 * @author Joey
 * @color: assigns number value to different colors
 * @shape: assigns number value to shapes
 * @rnd: randomizer
 * @
 */
public class Tile implements Serializable {
	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final String[] shapes = {"circle","square"};
	private int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	private int shape; // 0 - circle, 1 - square
	public Tile() {
		color = 3;
		shape = 0;
	}
	public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) { //color being set
		if (color < 0) {
			this.color = 0;
		} else if (color > 4) {
			this.color = 4;
		} else {
			this.color = color;
		}
	}
	/**
	 * 
	 * Functions obtain color, shape, and determines what is shown to user based on its number value
	 */
	public void setRandomly(Random rnd) { //randomized shape + color
		color = rnd.nextInt(colors.length);
		shape = rnd.nextInt(shapes.length);
	}
	public Color getActualColor() {
		return colors[color];
	}
	public String getColorName() {
		return colorNames[color];
	}
	public int getShape() {
		return shape; 
	}
	public void setShape(int shape) {
		if (shape < 0) {
			this.shape = 0;
		} else if (shape > 1) {
			this.shape = 1;
		} else {
			this.shape = shape;
		}
	}
	/**
	 * 
	 * Functions allow for shape to be "translated"
	 */
	public String getShapeAsString() {
		return shapes[shape];
	}
	public String toStringFancy() { 
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	@Override
	public String toString() {
		return String.format("%d %d",color,shape);
	}
	public int getCode() {
		return color*10+shape;
	}
}
