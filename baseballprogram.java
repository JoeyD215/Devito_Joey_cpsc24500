package start.Java;
/**
 * Date: October 7th
 * @author Joey
 * @version 1.0
 * Title: baseball_standings - allows user to insert file and the file will be read and display stats for the user
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
//Start
public class baseball_standings {
	public static void Intro() { //function for welcome message
		System.out.println("***********************************");
		System.out.println("*    BASEBALL STANDING ANALYZER   *");
		System.out.println("***********************************");
	}
	public static int showMenuAndGetChoice(Scanner sc) { //user selection menu
		System.out.println("Which standings would you like to see?");
		System.out.println("1. AL East ");
		System.out.println("2. AL Central ");
		System.out.println("3. AL West ");
		System.out.println("4. NL East ");
		System.out.println("5. NL Central ");
		System.out.println("6. NL West ");
		System.out.println("7. Overall ");
		System.out.println("8. Exit ");
		System.out.println("Enter the number of your choice: ");
		int choice = sc.nextInt(); //allowing choice
		return choice;
	}
	public static double getAverage(String line) { //function for finding avg
		String[] parts = line.split("\t");
		double games = (Integer.parseInt(parts[1])) + (Integer.parseInt(parts[2]));
	    double avg = (Integer.parseInt(parts[1])) / games;
		return avg;
	}
	/**
	 * Function: used for finding avg
	 * @param standings - the position/standings of teams from file
	 * @param avg - calculates average
	 */
	public static void printStats(ArrayList<String>standings) { //Stats finder/calculator
		String[] parts;
		double avg;
		System.out.println("----------------------------------");
		System.out.println("Teams:    Wins:    Losses:    Pct:    Games Behind: ");
		System.out.println("----------------------------------");
		for(String standing : standings) {//banner showing wins/loss
			parts = standing.split("\t");
			avg = getAverage(standing);
			System.out.printf("%-12s%-8s%-8s%6.2f\n",parts[0],parts[1],parts[2],avg);
		}
	}
	public static void printStatsPct(ArrayList<String> standings) {
		String[] parts;
		double avg;
		System.out.println("------------------");
		System.out.println("Teams: Pct: ");
		System.out.println("------------------");
		for(String standing : standings) {
			parts = standing.split("\t");
			avg = getAverage(standing);//avg is found and stats are printed
			System.out.printf("%-12s %6.2f\n", parts[0], avg);
		}
	}
	/**
	 * Function: used for printing stats base on avg size
	 * @param teams - teams per league on file
	 * @param line - reads the current line and gives avg
	 */
	public static void insertByAverage(ArrayList<String> teams, String line) {
		double thisAvg = getAverage(line);
		double otherAvg; //2 different averages, one for league, one for total
		int pos = -1;
		for (int i = 0; i < teams.size(); i++) {
			otherAvg = getAverage(teams.get(i));
			if(thisAvg>otherAvg) {
				pos = i;
				break;
			}
		}
		if(pos<0) {
			teams.add(line);
		}else {
			teams.add(pos,line);
		}
	}
	/**
	 * @param fname - allows for file to have input
	 * @param choice - allows user choice
	 * @param alltogether - overall standings
	 * @param args
	 */
	public static void main(String[]args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the name of the file: ");//user prompted with file input
			String fname = sc.nextLine();
			ArrayList<String> al_east = new ArrayList<String>();
			ArrayList<String> al_central = new ArrayList<String>();
			ArrayList<String> al_west = new ArrayList<String>();
			ArrayList<String> nl_east = new ArrayList<String>();
			ArrayList<String> nl_central = new ArrayList<String>();
			ArrayList<String> nl_west = new ArrayList<String>();
			ArrayList<String> target = null;
			ArrayList<String> allTogether = new ArrayList<String>();
			String line, title; //arrays for leagues are made
			String[] parts;
			boolean canGoAhead;
			int choice;
			try {
				Scanner fsc = new Scanner(new File(fname));
				while(fsc.hasNextLine()) {
					line = fsc.nextLine();
					parts = line.split("\t");//creating tab
					if(parts[0].equalsIgnoreCase("LEAGUE")){
						title = parts[1].toUpperCase();
						if(title.equalsIgnoreCase("AL EAST")) {
							target = al_east;//allowing it to read regardless of casing
						} else if(title.equalsIgnoreCase("AL CENTRAL")) {
							target = al_central;
						} else if(title.equalsIgnoreCase("AL WEST")) {
							target = al_west;
						} else if(title.equalsIgnoreCase("NL EAST")) {
							target = nl_east;
						} else if(title.equalsIgnoreCase("NL CENTRAL")) {
							target = nl_central;
						} else if(title.equalsIgnoreCase("NL WEST")) {
							target = nl_west;
						}
					}else {
						target.add(line);
						insertByAverage(allTogether,line);
					}
				}
				fsc.close();
				canGoAhead = true;
			}catch(Exception ex) {
				System.out.println("Could not read the file.");
			//	System.out.println(ex);
				canGoAhead = false;
			}
			if(canGoAhead) {
				do {
					choice = showMenuAndGetChoice(sc); //if file is read, then this is shown on screen
					if(choice == 1) {
						printStats(al_east);
					}else if(choice == 2) {
						printStats(al_central);
					}else if(choice == 3) {
						printStats(al_west);
					}else if(choice == 4) {
						printStats(nl_east);//displays each league with stats
					}else if(choice == 5) {
						printStats(nl_central);
					}else if(choice == 6) {
						printStats(nl_west);
					}else if(choice == 7) {
						for (String teams : allTogether) {
							System.out.println(teams);
						}
					}
				}while(choice != 8);
			}
	}
}
/**
 * end program
 */
