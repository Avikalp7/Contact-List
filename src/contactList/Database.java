package contactList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

public class Database 
{
	public static ArrayList <Relative> relative = new ArrayList <Relative>();
	public static ArrayList <Personal> personal = new ArrayList <Personal>();
	public static ArrayList <Professional> professional = new ArrayList <Professional>();
	public static ArrayList <Casual> casual = new ArrayList <Casual>();
	
	// This function is used to get a unique ID for Acquaintances
		public static int get_ID()
		{
			String fileName = "ID.txt";
			
			String currentLine;
			String ID = null;
			int intID = 0;
			
	        FileReader fileReader = null;
	        try {fileReader = new FileReader(fileName);}
	        catch (FileNotFoundException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
	        
	        try (BufferedReader bufferedReader = new BufferedReader(fileReader))
	        {
	          	currentLine = bufferedReader.readLine();
	          	// ADD : If current line is null, write 1 to text file.
	           	ID = currentLine;
	           	intID = Integer.parseInt(ID);
	        }
	        catch(IOException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
			
	        try{PrintWriter pw = new PrintWriter(fileName); pw.close();}
			catch(Exception e){System.out.println("Error! File " + fileName + " not found!");}
	        
	        FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter(fileName,true);
	        } catch (IOException ex) {
	            System.out.println("Error2 writing to file '"+ fileName + "'");
	        }
	        
	        try(BufferedWriter bufferedWriter= new BufferedWriter(fileWriter))
	        {
	        	bufferedWriter.write(""+(intID+1));
	        }
	        catch(IOException ex){System.out.println("Error3 writing to file '"+ fileName + "'");}
	        
	        return intID;
		}

		public static void main(String[] args) throws ParseException
		{
			Interactions.reconstruct();
			while(Interactions.display_main_menu()){}
		}
}
