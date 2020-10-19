package start.Java;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
//importing for plot
/**
 * Date: October 19
 * @author Joey
 * Title: CovidPlotting.java
 */
public class CovidPlotting {
	public static LinkedHashMap<String, double[]> readData(Scanner fsc){ //declares data to return
		LinkedHashMap<String, double[]> result = new LinkedHashMap<String, double[]>();
		fsc.nextLine();
		String[] parts;
		String line;
		double[] values; //each value read from each line
		String name; //name taken from line
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			name = parts[0];
			values = new double[parts.length-1];
			for (int i = 1; i < parts.length; i++) {
				values[i-1] = Double.parseDouble(parts[i]);
			}
			result.put(name,values);
		}
		return result;
	}
	/**
	 * function Intro: for showing user what program is being used
	 */
	public static void Intro() {
		System.out.println("********************************************");
		System.out.println("*  INTERNATIONAL COVID-19 MORTALITY RATES  *");//Introduction statement
		System.out.println("********************************************");
	}
	/**
	 * 
	 * @param howMany is a function for getting an array of numbers which are used to plot deaths per day
	 * @return gives results
	 */
	public static double[] getDays(int howMany) {//function for days vs deaths
		double[] result = new double[howMany];
		for (int i = 0; i < howMany; i++) {
			result[i] = i;
		}
		return result;
	}
	/**
	 * 
	 * @param plot - allows plotting import to create proper graph
	 */
	public static void setUpAndShowFrame(Plot2DPanel plot) {
		JFrame frm = new JFrame();
		frm.setTitle("Country values");
		frm.setBounds(100,100,500,500);
		frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//gets rid of frame
		Container c = frm.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(plot,BorderLayout.CENTER);
		frm.setVisible(true);		
	}
	/**
	 * @param countries - name of country
	 * @param names - takes in first column of country names
	 * @param parts - splits data into separate parts
	 */
	public static void main(String[] args) {
		LinkedHashMap<String,double[]> countries = null;
		String names;
		String[] parts;
		double[] data;
		Scanner sc = new Scanner(System.in);
		Intro();
		System.out.println("Enter the name of the file: "); //user input for file
		String fname = sc.nextLine();
		try {
			Scanner fsc = new Scanner(new File(fname));
			countries = readData(fsc);
			fsc.close();
		} catch (Exception ex) {
			countries = null;
		}
		if (countries == null) {
			System.out.println("File does not exist");//if file is not in system or found
		} else {
			do {
			System.out.print("Enter countries to plot, seperated by commas (or quit to end): ");
			names = sc.nextLine();
			if (!names.equalsIgnoreCase("quit")) {
				Plot2DPanel plot = new Plot2DPanel();
				plot.setAxisLabels("Day","Deaths");//creating labels for graph
				plot.addLegend("SOUTH");
				BaseLabel title = new BaseLabel("Cumulative deaths",Color.RED,0.5,1.1);
				plot.addPlotable(title);
				parts = names.split(","); //separating country names using ,
				for (String part : parts) {
					part = part.trim();
					if (countries.containsKey(part) == false) {
						System.out.printf("%s is not in the data set, check spelling.\n",part);//error message if country is not listed correctly
					} else {
						data = countries.get(part);
						plot.addLinePlot(part,getDays(data.length),data);//data processed if country is correctly displayed
					}
				}
				setUpAndShowFrame(plot);
			}
		} while (!names.equalsIgnoreCase("quit"));//once user types quit, a message is displayed
			System.out.println("Your only task is to wear a mask...");
	}
}}

