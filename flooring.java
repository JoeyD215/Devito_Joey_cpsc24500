package start.Java;

import java.util.Scanner;

public class Flooring {
	// setting up variables
	public static void main(String[] args) {
		double Area = 0, w, l;
		int packagenum =0;
		int Boardnum = 6;
		int Boardsize = 30*6;
		int cost = 0;
		
		Scanner sc = new Scanner(System.in);
		//user input 
		System.out.print("What is the length of the room:");
		l = sc.nextDouble();
		System.out.print("What is the width of the room:");
		w = sc.nextDouble(); //more variables
		Area = l*w*.20;
		Boardnum = (int) (Area / Boardsize);
		packagenum = Boardnum / 6;
		System.out.print("The area of the room is:" + Area);
		System.out.print("It will requrie" + Boardnum + "boards, so that means at least" + packagenum + "packages are required");
		//printing area and required package number with cost
		cost = (int)(Boardnum / 6 * 24.99);
	}	//System.out.print("The cost will be:" + cost);
}
