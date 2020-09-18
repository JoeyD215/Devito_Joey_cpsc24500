package start.Java;
//Program used to calculate area and circumference of a random circle/radius.
//Starting with using random class to generate different numbers
	import java.util.Random;
	public class CircleCalc {
	    public static void main(String[] args) {
	        double r;
	     // the radius is assigned a random value
	        Random num = new Random();
	        r = num.nextDouble();
	     // the circumference and area are calculated
	        System.out.println("The area of the circle =" + Math.PI*r*r);
	        System.out.println("The circumference of the circle =" + 2*Math.PI*r);
	     // final results are printed  
	    }
	}
