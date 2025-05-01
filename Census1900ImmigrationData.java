package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class is the program performing immigrant population finding.
 * The program is interactive. 
 * When the program is executed the name of the input file containing the list of all the named 
 * The CSV data in this file serves as a database of all the regions, origins, and count of immigrants in 1900.
 * In the interactive part, the user enters REGION total, REGION from ORIGIN, and REGION all. The program 
 * responds by printing the region, count, and origin information.
 * 
 * @author Zhengyi Chen
 *
 */
public class Census1900ImmigrationData {

	/**
	 * The main() method of this program. 
	 * @param args array of Strings provided on the command line when the program is started; 
	 * the first string should be the name of the input file containing the list of named Origins. 

	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//verify that the command line argument exists 
		if (args.length == 0 ) {
			System.err.println("Usage Error: the program expects file name as an argument.\n");
			System.exit(1);
		}
		
		//verify that command line argument contains a name of an existing file 
		File OriginFile = new File(args[0]); 
		if (!OriginFile.exists()){
			System.err.println("Error: the file "+OriginFile.getAbsolutePath()+" does not exist.\n");
			System.exit(1);
		}
		if (!OriginFile.canRead()){
			System.err.println("Error: the file "+OriginFile.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
		
		//open the file for reading 
		Scanner f = null; 
		
		
		try {
			f = new Scanner (OriginFile ) ;
		} catch (FileNotFoundException e) {
			System.err.println("Error: the file "+OriginFile.getAbsolutePath()+
											" cannot be opened for reading.\n");
			System.exit(1);
		}
		
		//read the content of the file and save the data in a list of named Origins
		RegionList list = new RegionList();
		ArrayList<String> origins = new ArrayList<String>();
		String line = null; 
		Scanner parseLine = null; 
		String originName = null;
		String regionName = null;
		int count = 0; 
		Origin o = null;
		Region r = null;
		boolean isRegion = false;
		while (f.hasNextLine()) {
			try { 
				line = f.nextLine(); 
				parseLine = new Scanner(line);
				//edit from https://stackoverflow.com/questions/31993153/java-split-string-on-comma-except-when-between-parenthesis
				String [] temp = line.split(",(?![^()]*\\))");
				try {
					if (temp[0].equals("States and territories")) {
						for (int i = 0; i < temp.length; i++) {
							origins.add(temp[i]);
						}
						isRegion = true;
						continue;
					} 
				}
				catch (ArrayIndexOutOfBoundsException ex ) {
					//ignore this exception and skip to the next line 	
				}
				if (isRegion) {
					try {
						regionName = temp[0];
						r = new Region (regionName);	
					}
					catch (ArrayIndexOutOfBoundsException ex ) {
						//ignore this exception and skip to the next line 	
					}
					for (int j = 1; j < temp.length; j++) {
						try {
							count = Integer.parseInt(temp[j]);
							originName = origins.get(j);
							o = new Origin (originName, count);
							r.add(o);
						}
						catch (IllegalArgumentException ex ) {
							//ignore this exception and skip to the next line 	
						}
					}
					list.add(r);
				}
			}
			catch (NoSuchElementException ex ) {
				//caused by an incomplete or miss-formatted line in the input file
				continue; 	
			}
		}
		//interactive mode: 
		Scanner userInput  = new Scanner (System.in ); 
		String userValue = "";
		
		System.out.println("Enter one of the following instructions.\r\n"
				+ "\r\n"
				+ "REGION total\r\n"
				+ "REGION from ORIGIN\r\n"
				+ "REGION all\r\n"
				+ "quit\r\n"
				+ "\r\n"
				+ "Replace REGION with your desired region, and ORIGIN with your desired place of origin (or its substring).\r\n"
				+ "------\r\n"
				+ "" );
		do {
			System.out.println("Enter your instruction:");
			//get value of from the user 
			userValue = userInput.nextLine();
			if (!userValue.equalsIgnoreCase("quit")) {
				try {
					if (!userValue.equalsIgnoreCase("quit")) {
						if (userValue.contains("total")) {
							String [] temp = userValue.split(" total");
							try {
								Region c = list.getByName(temp[0]);
								int countTemp = c.getByName("Total foreign born").get(0).getCount();
								System.out.printf("%s: Total foreign born is: %d\n",temp[0],countTemp);
							} catch (NullPointerException ex) {
								System.out.println("No matches found. Try again.");
							}
							System.out.println();
						} else if (userValue.contains("from")) {
							String [] temp = userValue.split(" from ");
							Region c = list.getByName(temp[0]);
							ArrayList <Origin> originNameTemp = c.getByName(temp[1]);
							if (originNameTemp == null) {
								System.out.println("No matches found. Try again.");
							} else {
								System.out.println(String.format("\n%s: foreign born population",temp[0]));
								for (int i = 0; i < originNameTemp.size(); i++) {
									System.out.println(originNameTemp.get(i).toString());
								}
							}
							System.out.println();
						} else if (userValue.contains("all")) {
							String [] temp = userValue.split(" all");
							try {
								Region c = list.getByName(temp[0]);
								System.out.println(c.toString());
							} catch (NullPointerException ex) {
								System.out.println("No matches found. Try again.");
							}
						} else {
							System.out.println("This is not a valid query. Try again.\n");
						}
						System.out.println();
					}
				} catch (IllegalAccessException ex ) {
					System.out.println("No Region Input. Try again.\n"); 
					continue;
				}
			} 
		} while (!userValue.equalsIgnoreCase("quit"));
		userInput.close();
		
	}

}