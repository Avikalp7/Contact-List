package contactList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Functions 
{
	static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    static Date today = new Date();
    
    final static String DATE_FORMAT = "dd/MM/yyyy";
    
    // Function source : Stack Overflow
    static boolean isDateValid(String date) 
    {
            try {
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                df.setLenient(false);
                df.parse(date);
                return true;
            } catch (ParseException e) {
                return false;
            }
    }
    
	static boolean isNum(char c)
	{
		if(c>='0'&&c<='9') return true;
		return false;
	}
	
	public static boolean checkDateFormat(String date) throws ParseException
	{
		if(date.length()!=10) return false;
		if(date.charAt(0)!='1'&&date.charAt(0)!='2'&&date.charAt(0)!='3'&&date.charAt(0)!='0') return false;
		if(!isNum(date.charAt(1))||(!isNum(date.charAt(4)))||(!isNum(date.charAt(6)))||(!isNum(date.charAt(7)))||(!isNum(date.charAt(8)))||(!isNum(date.charAt(9)))) return false;
		if(date.charAt(2)!='/'||date.charAt(5)!='/') return false;
		if(date.charAt(3)!='0'&&date.charAt(3)!='1') return false;
		//if(date.charAt(6)!='2'||date.charAt(7)!='0') return false;
		if(date.charAt(0)=='3'&&date.charAt(1)>'1') return false;
		if(date.charAt(3)=='1'&&date.charAt(4)>'2') return false;
		if(!isDateValid(date)) return false;
		// Checking that specified date shouldn't be more than 1 year in future
		String expectedPattern = "dd/MM/yyyy";
	    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
	    Date datum = formatter.parse(date);
	//    if(Math.abs(datum.getTime()-today.getTime())>31536000000L) return false;
	    if((datum.getTime()-today.getTime())>0) return false;
		return true;
	}
	
	static boolean check_mNumber(String mNumber)
	{
		if(mNumber.length()!=10) return false;
		for(int i=0;i<mNumber.length();i++)
		{
			if(!isNum(mNumber.charAt(i))) return false;
		}
		if(mNumber.charAt(0)<'4') return false;
		return true;
	}
	
	// Source : Stack Overflow
	public static boolean check_eAddress(String eAddress)
	{
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return eAddress.matches(EMAIL_REGEX);
	}
	
	
	public static String takeStrInput( )
	{
		String test = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			test = br.readLine();
		}
		catch(Exception e)
		{
			System.out.println("Exception! Unable to read from console.");
		}
		return test;
	}
	
	public static int takeIntInput(int upLimit)
	{
		String temp = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int userInput = 0,flag=0;
		while(flag==0)
		{	
			try
			{temp = br.readLine();}
			catch(Exception e)
			{System.out.println("Exception! Unable to read from console.");}
			flag=1;
			try{userInput = Integer.parseInt(temp);}
			catch(Exception e)
			{
				System.out.println("Exception! You were requested to enter an integer, not a string! Enter again.");
				flag=0;
			}
		}
		if(upLimit!=0) return checkChoice(userInput,upLimit);
		return userInput;
	}
	
	public static int checkChoice(int userInput, int upLimit)
	{
		if(userInput>upLimit)
		{
			System.out.println("Please enter a vaild choice!");
			userInput = takeIntInput(upLimit);
		}
		return userInput;
	}
		
	// Function Input Parameters : None
	// Function's Purpose : Take input from console for choice b/w yes and no, input should only be Y or N
	// Function's Working : Takes input until input is either Y or N
	// Function's Return Value : A string - Y or N
	public static String takeYNInput( )
	{
		String test = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			test = br.readLine();
		}
		catch (Exception e1) {System.out.println("Exception! Unable to read from console.");}
		
		while(!test.equals("Y")&&!test.equals("N"))
		{
			System.out.println("Please enter only Y or N to continue");
			try
			{
				test = br.readLine();
			}
			catch(Exception e2)
			{
				System.out.println("Exception! Unable to read from console.");
			}
		}
		return test;
	}
	
	
		
		/*** CREATE ACQUAINTANCES STARTING ***/ 
	
		public static void create_new_relative() throws ParseException
		{
			String name, mNumber, eAddress, birthDay,lastMeeting;
			Interactions.print_message(2);
			name = takeStrInput(); 
			while(!check_mNumber(mNumber = takeStrInput()))
			{
				System.out.println("Please enter a valid mobile number");
			}
			System.out.println("Enter Email Address");
			while(!check_eAddress(eAddress = takeStrInput()))
			{
				System.out.println("Please enter a valid email address");
			}
			System.out.println("Enter Birth Day in dd/mm/yyyy format strictly");
			birthDay =takeStrInput();
			while(!checkDateFormat(birthDay))
			{
				Interactions.print_message(3);
				birthDay =takeStrInput();
			}
			System.out.println("Enter Date of Last Meeting in dd/mm/yyyy format strictly");
			lastMeeting =takeStrInput();
			while(!checkDateFormat(lastMeeting))
			{
				Interactions.print_message(3);
				lastMeeting =takeStrInput();
			}
			Database.relative.add(new Relative());
			Database.relative.get(Database.relative.size()-1).set_relative_details(name, mNumber, eAddress, birthDay, lastMeeting);
			Interactions.print_message(5);
		}
		
		public static void create_new_professional()
		{
			String name, mNumber, eAddress, commonInterest;
			Interactions.print_message(2);
			name = takeStrInput(); 
			while(!check_mNumber(mNumber = takeStrInput()))
			{
				System.out.println("Please enter a valid mobile number");
			}
			System.out.println("Enter Email Address");
			while(!check_eAddress(eAddress = takeStrInput()))
			{
				System.out.println("Please enter a valid email address");
			}
			System.out.println("Enter specific common professional interests (100 characters maximum)");
			commonInterest = takeStrInput();
			while((commonInterest.length())>100)
			{
				Interactions.print_message(4);
				commonInterest = takeStrInput();
			}
			Database.professional.add(new Professional());
			Database.professional.get(Database.professional.size()-1).set_professional_details(name, mNumber, eAddress, commonInterest);
			Interactions.print_message(5);
		}
		
		public static void create_new_personal() throws ParseException
		{
			String name, mNumber, eAddress, context, dateAcq, specificEvent;
			Interactions.print_message(2);
			name = takeStrInput(); 
			while(!check_mNumber(mNumber = takeStrInput()))
			{
				System.out.println("Please enter a valid mobile number");
			}
			System.out.println("Enter Email Address");
			while(!check_eAddress(eAddress = takeStrInput()))
			{
				System.out.println("Please enter a valid email address");
			}
			System.out.println("Enter Context of Meeting (max 100 char)");
			context = takeStrInput();
			while(context.length()>100)
			{
				Interactions.print_message(4);
				context = takeStrInput();
			}
			System.out.println("Enter Date of which acquainted in dd/mm/yyyy format strictly");
			dateAcq =takeStrInput();
			while(!checkDateFormat(dateAcq))
			{
				Interactions.print_message(3);
				dateAcq =takeStrInput();
			}
			System.out.println("Enter any specific event to be noted (max 100 char)");
			specificEvent = takeStrInput();
			while(specificEvent.length()>100)
			{
				Interactions.print_message(4);
				specificEvent = takeStrInput();
			}
			Database.personal.add(new Personal());
			Database.personal.get(Database.personal.size()-1).set_personal_details(name, mNumber, eAddress, context, dateAcq, specificEvent);
			Interactions.print_message(5);
		}
		
		public static void create_new_casual() throws ParseException
		{
			String name, mNumber, eAddress, dateAcq, meetPlace, circumstance;
			Interactions.print_message(2);
			name = takeStrInput(); 
			while(!check_mNumber(mNumber = takeStrInput()))
			{
				System.out.println("Please enter a valid mobile number");
			}
			System.out.println("Enter Email Address");
			while(!check_eAddress(eAddress = takeStrInput()))
			{
				System.out.println("Please enter a valid email address");
			}
			System.out.println("Enter Date on which acquainted in dd/mm/yyyy format strictly");
			dateAcq =takeStrInput();
			while(!checkDateFormat(dateAcq))
			{
				Interactions.print_message(3);
				dateAcq =takeStrInput();
			}
			System.out.println("Enter the meeting place (max 100 char)");
			meetPlace = takeStrInput();
			while(meetPlace.length()>100)
			{
				Interactions.print_message(4);
				meetPlace = takeStrInput();
			}
			
			System.out.println("Enter Circustances of Meeting (max 100 char)");
			circumstance = takeStrInput();
			while(circumstance.length()>100)
			{
				Interactions.print_message(4);
				circumstance = takeStrInput();
			}
			System.out.println("Enter any other useful information (max 100 char)");
			String usefulInfo = takeStrInput();
			while(usefulInfo.length()>100)
			{
				Interactions.print_message(4);
				usefulInfo = takeStrInput();
			}
			Database.casual.add(new Casual());
			Database.casual.get(Database.casual.size()-1).set_casual_details(name, mNumber, eAddress, dateAcq, meetPlace, circumstance, usefulInfo);
			Interactions.print_message(5);
		}
	
		
		/*** DISPLAY ACQUAINTANCES STARTING ***/
		public static void display_all_relatives(boolean minimal)
		{
			if(Database.relative.size()==0){System.out.println("There are no relatives to diplay");Interactions.print_message(0); return;}
			System.out.println("LIST OF RELATIVES:");
			int i;
				for(i = 0; i < Database.relative.size(); i++ )
				{
					display_relative(minimal, i);
				}
				//if(i!=0) System.out.println("XX- End of Relatives List -XX");
				Interactions.print_message(0);
		}
		
		public static void display_relative(boolean minimal, int index)
		{
				//Interactions.print_message(5);
				System.out.println("ID : " + Database.relative.get(index).AcqID);
				System.out.println("NAME : " + Database.relative.get(index).name + "      MOBILE NUMBER : " + Database.relative.get(index).mNumber + "      EMAIL ADDRESS : " + Database.relative.get(index).eAddress);
				if(!minimal)
				{
					
					String birthDay = formatter.format(Database.relative.get(index).getBirthDay());
					String lastMeeting = formatter.format(Database.relative.get(index).getLastMeeting());
					System.out.println("BIRTH DAY : " + birthDay + "      DAY OF LAST MEETING : " + lastMeeting);
				}
		}
		
		public static void display_all_professionals(boolean minimal)
		{
			if(Database.professional.size()==0){System.out.println("There are no professional friends to diplay"); Interactions.print_message(0); return;}
			System.out.println("LIST OF PROFESSIONAL FRIENDS:");
			int i;
				for(i = 0; i < Database.professional.size(); i++ )
				{
					display_professional(minimal, i);
				}
				//if(i!=0) System.out.println("XX- End of professionals List -XX");
				Interactions.print_message(0);
		}
		
		public static void display_professional(boolean minimal, int index)
		{
				//Interactions.print_message(5);
				System.out.println("ID : " + Database.professional.get(index).AcqID);
				System.out.println("NAME : " + Database.professional.get(index).name + "      MOBILE NUMBER : " + Database.professional.get(index).mNumber + "      EMAIL ADDRESS : " + Database.professional.get(index).eAddress);
				if(!minimal)
				{
					System.out.print("COMMON PROFESSIONAL INTERESTS : ");
					System.out.println("" + Database.professional.get(index).commonInterest);
				}
		}
		
		public static void display_all_personals(boolean minimal)
		{
			if(Database.personal.size()==0){System.out.println("There are no personal friends to display"); Interactions.print_message(0); return;}
			System.out.println("LIST OF PERSONAL FRIENDS :");	
			int i;
				for(i = 0; i < Database.personal.size(); i++ )
				{
					display_personal(minimal, i);
				}
				//if(i!=0) System.out.println("XX- End of personal friends List -XX");
				Interactions.print_message(0);
		}
		
		public static void display_personal(boolean minimal, int index)
		{
				System.out.println("ID : " + Database.personal.get(index).AcqID);
				System.out.println("NAME : " + Database.personal.get(index).name + "      MOBILE NUMBER : " + Database.personal.get(index).mNumber + "      EMAIL ADDRESS : " + Database.personal.get(index).eAddress);
				if(!minimal)
				{
					System.out.print("CONTEXT : ");
					System.out.println("" + Database.personal.get(index).context);
					String dateAcq = formatter.format(Database.personal.get(index).dateAcq);
					System.out.println("DATE OF ACQUAINTANCE : " + dateAcq);
					System.out.print("NOTEWORTHY EVENTS : ");
					System.out.println("" + Database.personal.get(index).specificEvent);
				}
		}
		
		public static void display_all_casuals(boolean minimal)
		{
			if(Database.casual.size()==0){System.out.println("There are no casual Acquaintances to diplay"); Interactions.print_message(0); return;}
			System.out.println("LIST OF CASUAL ACQUAINTANCES :");
			int i;
				for(i = 0; i < Database.casual.size(); i++ )
				{
					display_casual(minimal, i);
				}
				Interactions.print_message(0);
		}
		
		public static void display_casual(boolean minimal, int index)
		{
				System.out.println("ID : " + Database.casual.get(index).AcqID);
				System.out.println("NAME : " + Database.casual.get(index).name + "      MOBILE NUMBER : " + Database.casual.get(index).mNumber + "      EMAIL ADDRESS : " + Database.casual.get(index).eAddress);
				if(!minimal)
				{
					System.out.print("PLACE OF MEETING : ");
					System.out.println("" + Database.casual.get(index).meetPlace);
					
					String dateAcq = formatter.format(Database.casual.get(index).dateAcq);
					System.out.println("DATE OF ACQUAINTANCE : " + dateAcq);
					System.out.print("CIRCUMSTANCES OF MEETING : ");
					System.out.println("" + Database.casual.get(index).circumstance);
					System.out.print("OTHER USEFUL INFORMATION : ");
					System.out.println("" + Database.casual.get(index).usefulInfo);
				}
		}
		
		public static void display_all(boolean minimal)
		{
			display_all_relatives(minimal);
			display_all_professionals(minimal);
			display_all_personals(minimal);
			display_all_casuals(minimal);
		}
	
		
		public static int find_relative_by_ID(int id)
		{
			for(int i=0; i<Database.relative.size();i++)
			{
				if(Database.relative.get(i).AcqID==id)
				{
					return i;
				}
			}
			return -1;
		}
		
		public static int find_professional_by_ID(int id)
		{
			for(int i=0; i<Database.professional.size();i++)
			{
				if(Database.professional.get(i).AcqID==id)
				{
					return i;
				}
			}
			return -1;
		}
		
		public static int find_personal_by_ID(int id)
		{
			for(int i=0; i<Database.personal.size();i++)
			{
				if(Database.personal.get(i).AcqID==id)
				{
					return i;
				}
			}
			return -1;
		}
		
		public static int find_casual_by_ID(int id)
		{
			for(int i=0; i<Database.casual.size();i++)
			{
				if(Database.casual.get(i).AcqID==id)
				{
					return i;
				}
			}
			return -1;
		}
		
		public static int select_ID(int i)
		{
			if(i==1)
			{
				display_all_relatives(true);
				Interactions.print_message(7);
				int rIdx;
				while((rIdx=find_relative_by_ID(takeIntInput(0)))==-1)
				{
					Interactions.print_message(1);
				}
				return rIdx;
			}
			else if(i==2)
			{
				display_all_professionals(true);
				Interactions.print_message(7);
				int pIdx;
				while((pIdx=find_professional_by_ID(takeIntInput(0)))==-1)
				{
					Interactions.print_message(1);
				}
				return pIdx;
			}
			else if(i==3)
			{
				display_all_personals(true);
				Interactions.print_message(7);
				int pIdx;
				while((pIdx=find_personal_by_ID(takeIntInput(0)))==-1)
				{
					Interactions.print_message(1);
				}
				return pIdx;
			}
			else
			{
				display_all_casuals(true);
				Interactions.print_message(7);
				int pIdx;
				while((pIdx=find_casual_by_ID(takeIntInput(0)))==-1)
				{
					Interactions.print_message(1);
				}
				return pIdx;
			}
		}
		
		
		public static int search_relative(String name, int counter)
		{
			for(int i=0; i<Database.relative.size(); i++)
			{
				if((Database.relative.get(i).name.toLowerCase()).contains(name.toLowerCase()))
				{
					counter++;
					System.out.println("Search Result " + counter + " - Type : Relative");
					display_relative(false,i);
				}
			}
			return counter;
		}
		
		public static int search_professional(String name, int counter)
		{
			for(int i=0; i<Database.professional.size(); i++)
			{
				if((Database.professional.get(i).name.toLowerCase()).contains(name.toLowerCase()))
				{
					counter++;
					System.out.println("Search Result " + counter + " - Type : Professional");
					display_professional(false,i);
				}
			}
			return counter;
		}
		
		public static int search_personal(String name, int counter)
		{
			for(int i=0; i<Database.personal.size(); i++)
			{
				if((Database.personal.get(i).name.toLowerCase()).contains(name.toLowerCase()))
				{
					counter++;
					System.out.println("Search Result " + counter + " - Type : Personal");
					display_personal(false,i);
				}
			}
			return counter;
		}
		
		public static int search_casual(String name, int counter)
		{
			for(int i=0; i<Database.casual.size(); i++)
			{
				if((Database.casual.get(i).name.toLowerCase()).contains(name.toLowerCase()))
				{
					counter++;
					System.out.println("Search Result " + counter + " - Type : Casual");
					display_casual(false,i);
				}
			}
			return counter;
		}
		
		public static int search(String name)
		{
			int counter = search_relative(name,0);
			counter = search_professional(name,counter);
			counter = search_personal(name,counter);
			counter = search_casual(name,counter);
			return counter;
		}

		
		public static void save_relatives()
		{
			String fileName = "relatives.txt";
			try{PrintWriter pw = new PrintWriter(fileName); pw.close();}
			catch(Exception e){System.out.println("Error! File " + fileName + " not found!");}
			for(int i=0;i<Database.relative.size();i++)
			{
				FileWriter fileWriter = null;
				try {fileWriter = new FileWriter(fileName,true);} 
				catch (IOException ex) {System.out.println("Error2 writing to file '"+ fileName + "'");}
				try(BufferedWriter bufferedWriter= new BufferedWriter(fileWriter))
				{
					bufferedWriter.write("NEW RELATIVE"); bufferedWriter.newLine();
					bufferedWriter.write("ID"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.relative.get(i).AcqID); bufferedWriter.newLine();
					bufferedWriter.write("NAME"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.relative.get(i).name); bufferedWriter.newLine();
					bufferedWriter.write("MOBILE NUMBER"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.relative.get(i).mNumber); bufferedWriter.newLine();
					bufferedWriter.write("EMAIL"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.relative.get(i).eAddress); bufferedWriter.newLine();
					bufferedWriter.write("BIRTH DAY"); bufferedWriter.newLine();
					bufferedWriter.write("" + formatter.format(Database.relative.get(i).getBirthDay())); bufferedWriter.newLine();
					bufferedWriter.write("DATE OF LAST MEETING"); bufferedWriter.newLine();
					bufferedWriter.write("" + formatter.format(Database.relative.get(i).getLastMeeting())); bufferedWriter.newLine();
					bufferedWriter.write("xx- END OF RELATIVE -xx"); bufferedWriter.newLine();
				}
				catch(IOException e){System.out.println("Exception! Error writing to file "+ fileName);}
			}
		}
		
		public static void save_professionals()
		{
			String fileName = "professionals.txt";
			try{PrintWriter pw = new PrintWriter(fileName); pw.close();}
			catch(Exception e){System.out.println("Error! File " + fileName + " not found!");}
			for(int i=0;i<Database.professional.size();i++)
			{
				FileWriter fileWriter = null;
				try {fileWriter = new FileWriter(fileName,true);} 
				catch (IOException ex) {System.out.println("Error2 writing to file '"+ fileName + "'");}
				try(BufferedWriter bufferedWriter= new BufferedWriter(fileWriter))
				{
					bufferedWriter.write("NEW PROFESSIONAL"); bufferedWriter.newLine();
					bufferedWriter.write("ID"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.professional.get(i).AcqID); bufferedWriter.newLine();
					bufferedWriter.write("NAME"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.professional.get(i).name); bufferedWriter.newLine();
					bufferedWriter.write("MOBILE NUMBER"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.professional.get(i).mNumber); bufferedWriter.newLine();
					bufferedWriter.write("EMAIL"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.professional.get(i).eAddress); bufferedWriter.newLine();
					bufferedWriter.write("PROFESSIONAL INTEREST"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.professional.get(i).commonInterest); bufferedWriter.newLine();
					bufferedWriter.write("xx- END OF PROFESSIONAL -xx"); bufferedWriter.newLine();
				}
				catch(IOException e){System.out.println("Exception! Error writing to file "+ fileName);}
			}
		}
		
		public static void save_personals()
		{
			String fileName = "personals.txt";
			try{PrintWriter pw = new PrintWriter(fileName); pw.close();}
			catch(Exception e){System.out.println("Error! File " + fileName + " not found!");}
			for(int i=0;i<Database.personal.size();i++)
			{
				FileWriter fileWriter = null;
				try {fileWriter = new FileWriter(fileName,true);} 
				catch (IOException ex) {System.out.println("Error2 writing to file '"+ fileName + "'");}
				try(BufferedWriter bufferedWriter= new BufferedWriter(fileWriter))
				{
					bufferedWriter.write("NEW PERSONAL"); bufferedWriter.newLine();
					bufferedWriter.write("ID"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.personal.get(i).AcqID); bufferedWriter.newLine();
					bufferedWriter.write("NAME"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.personal.get(i).name); bufferedWriter.newLine();
					bufferedWriter.write("MOBILE NUMBER"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.personal.get(i).mNumber); bufferedWriter.newLine();
					bufferedWriter.write("EMAIL"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.personal.get(i).eAddress); bufferedWriter.newLine();
					bufferedWriter.write("CONTEXT"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.personal.get(i).context); bufferedWriter.newLine();
					bufferedWriter.write("DATE ACQ"); bufferedWriter.newLine();
					bufferedWriter.write("" + formatter.format(Database.personal.get(i).dateAcq)); bufferedWriter.newLine();
					bufferedWriter.write("SPECIFIC EVENT"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.personal.get(i).specificEvent); bufferedWriter.newLine();
					bufferedWriter.write("xx- END OF PERSONAL -xx"); bufferedWriter.newLine();
				}
				catch(IOException e){System.out.println("Exception! Error writing to file "+ fileName);}
			}
		}
		
		public static void save_casuals()
		{
			String fileName = "casuals.txt";
			try{PrintWriter pw = new PrintWriter(fileName); pw.close();}
			catch(Exception e){System.out.println("Error! File " + fileName + " not found!");}
			for(int i=0;i<Database.casual.size();i++)
			{
				FileWriter fileWriter = null;
				try {fileWriter = new FileWriter(fileName,true);} 
				catch (IOException ex) {System.out.println("Error2 writing to file '"+ fileName + "'");}
				try(BufferedWriter bufferedWriter= new BufferedWriter(fileWriter))
				{
					bufferedWriter.write("NEW CASUAL"); bufferedWriter.newLine();
					bufferedWriter.write("ID"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).AcqID); bufferedWriter.newLine();
					bufferedWriter.write("NAME"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).name); bufferedWriter.newLine();
					bufferedWriter.write("MOBILE NUMBER"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).mNumber); bufferedWriter.newLine();
					bufferedWriter.write("EMAIL"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).eAddress); bufferedWriter.newLine();
					bufferedWriter.write("DATE ACQ"); bufferedWriter.newLine();
					bufferedWriter.write("" + formatter.format(Database.casual.get(i).dateAcq)); bufferedWriter.newLine();
					bufferedWriter.write("MEET PLACE"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).meetPlace); bufferedWriter.newLine();
					bufferedWriter.write("CIRCUMSTANCE"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).circumstance); bufferedWriter.newLine();
					bufferedWriter.write("USEFUL INFO"); bufferedWriter.newLine();
					bufferedWriter.write("" + Database.casual.get(i).usefulInfo); bufferedWriter.newLine();
					bufferedWriter.write("xx- END OF CASUAL -xx"); bufferedWriter.newLine();
				}
				catch(IOException e){System.out.println("Exception! Error writing to file "+ fileName);}
			}
		}

		
		public static void reconstruct_relatives() throws ParseException
		{
			String s = null;
			Relative relative = null;
			String fileName = "relatives.txt";
			FileReader fileReader = null;
	        try {fileReader = new FileReader(fileName);} catch (FileNotFoundException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
	            try (BufferedReader bufferedReader = new BufferedReader(fileReader))
	            {
	            	while((s=bufferedReader.readLine())!=null)
	            	{
	            		if(s.equals("NEW RELATIVE"))
	            		{
	            			relative = new Relative();
	            		}
	            		else if(s.equals("ID"))
	            		{
	            			s=bufferedReader.readLine();
	            			relative.AcqID = Integer.parseInt(s);
	            		}
	            		else if(s.equals("NAME"))
	            		{
	            			s=bufferedReader.readLine();
	            			relative.name = s;
	            		}
	            		else if(s.equals("MOBILE NUMBER"))
	            		{
	            			s = bufferedReader.readLine();
	            			relative.mNumber = s;
	            		}
	            		else if(s.equals("EMAIL"))
	            		{
	            			s=bufferedReader.readLine();
	            			relative.eAddress = s;
	            		}
	            		else if(s.equals("BIRTH DAY"))
	            		{
	            			s=bufferedReader.readLine();
	            			relative.setBirthDay(s);
	            		}
	            		else if(s.equals("DATE OF LAST MEETING"))
	            		{
	            			s=bufferedReader.readLine();
	            			relative.setLastMeeting(s);
	            		}
	            		else if(s.equals("xx- END OF RELATIVE -xx"))
	            		{
	            			Database.relative.add(relative);
	            		}
	            	}
	            }
	            catch(IOException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
			
		}

		public static void reconstruct_personals() throws ParseException
		{
			String s = null;
			Personal personal = null;
			String fileName = "personals.txt";
			FileReader fileReader = null;
	        try {fileReader = new FileReader(fileName);} catch (FileNotFoundException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
	            try (BufferedReader bufferedReader = new BufferedReader(fileReader))
	            {
	            	while((s=bufferedReader.readLine())!=null)
	            	{
	            		if(s.equals("NEW PERSONAL"))
	            		{
	            			personal = new Personal();
	            		}
	            		else if(s.equals("ID"))
	            		{
	            			s=bufferedReader.readLine();
	            			personal.AcqID = Integer.parseInt(s);
	            		}
	            		else if(s.equals("NAME"))
	            		{
	            			s=bufferedReader.readLine();
	            			personal.name = s;
	            		}
	            		else if(s.equals("MOBILE NUMBER"))
	            		{
	            			s = bufferedReader.readLine();
	            			personal.mNumber = s;
	            		}
	            		else if(s.equals("EMAIL"))
	            		{
	            			s=bufferedReader.readLine();
	            			personal.eAddress = s;
	            		}
	            		else if(s.equals("CONTEXT"))
	            		{
	            			s=bufferedReader.readLine();
	            			personal.context = s;
	            		}
	            		else if(s.equals("DATE ACQ"))
	            		{
	            			s=bufferedReader.readLine();
	            			personal.dateAcq = formatter.parse(s);
	            		}
	            		else if(s.equals("SPECIFIC EVENT"))
	            		{
	            			s=bufferedReader.readLine();
	            			personal.specificEvent = s;
	            		}
	            		else if(s.equals("xx- END OF PERSONAL -xx"))
	            		{
	            			Database.personal.add(personal);
	            		}
	            	}
	            }
	            catch(IOException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
			
		}

		public static void reconstruct_professionals() throws ParseException
		{
			String s = null;
			Professional professional = null;
			String fileName = "professionals.txt";
			FileReader fileReader = null;
	        try {fileReader = new FileReader(fileName);} catch (FileNotFoundException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
	            try (BufferedReader bufferedReader = new BufferedReader(fileReader))
	            {
	            	while((s=bufferedReader.readLine())!=null)
	            	{
	            		if(s.equals("NEW PROFESSIONAL"))
	            		{
	            			professional = new Professional();
	            		}
	            		else if(s.equals("ID"))
	            		{
	            			s=bufferedReader.readLine();
	            			professional.AcqID = Integer.parseInt(s);
	            		}
	            		else if(s.equals("NAME"))
	            		{
	            			s=bufferedReader.readLine();
	            			professional.name = s;
	            		}
	            		else if(s.equals("MOBILE NUMBER"))
	            		{
	            			s = bufferedReader.readLine();
	            			professional.mNumber = s;
	            		}
	            		else if(s.equals("EMAIL"))
	            		{
	            			s=bufferedReader.readLine();
	            			professional.eAddress = s;
	            		}
	            		else if(s.equals("PROFESSIONAL INTEREST"))
	            		{
	            			s=bufferedReader.readLine();
	            			professional.commonInterest = s;
	            		}
	            		else if(s.equals("xx- END OF PROFESSIONAL -xx"))
	            		{
	            			Database.professional.add(professional);
	            		}
	            	}
	            }
	            catch(IOException ex) {System.out.println("Error reading to file '"+ fileName + "'");}	
		}
		
		public static void reconstruct_casuals() throws ParseException
		{
			String s = null;
			Casual casual = null;
			String fileName = "casuals.txt";
			FileReader fileReader = null;
	        try {fileReader = new FileReader(fileName);} catch (FileNotFoundException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
	            try (BufferedReader bufferedReader = new BufferedReader(fileReader))
	            {
	            	while((s=bufferedReader.readLine())!=null)
	            	{
	            		if(s.equals("NEW CASUAL"))
	            		{
	            			casual = new Casual();
	            		}
	            		else if(s.equals("ID"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.AcqID = Integer.parseInt(s);
	            		}
	            		else if(s.equals("NAME"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.name = s;
	            		}
	            		else if(s.equals("MOBILE NUMBER"))
	            		{
	            			s = bufferedReader.readLine();
	            			casual.mNumber = s;
	            		}
	            		else if(s.equals("EMAIL"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.eAddress = s;
	            		}
	            		else if(s.equals("DATE ACQ"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.dateAcq = formatter.parse(s);
	            		}
	            		else if(s.equals("MEET PLACE"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.meetPlace = s;
	            		}
	            		else if(s.equals("CIRCUMSTANCE"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.circumstance = s;
	            		}
	            		else if(s.equals("USEFUL INFO"))
	            		{
	            			s=bufferedReader.readLine();
	            			casual.usefulInfo = s;
	            		}
	            		else if(s.equals("xx- END OF CASUAL -xx"))
	            		{
	            			Database.casual.add(casual);
	            		}
	            	}
	            }
	            catch(IOException ex) {System.out.println("Error reading to file '"+ fileName + "'");}
		}
		
		
		public static void clear()
		{
			String fileName[] = {"relatives.txt","professionals.txt","personals.txt","casuals.txt"}; 
			for(int i=0;i<4;i++)
			{
				try{PrintWriter pw = new PrintWriter(fileName[i]); pw.close();}
				catch(Exception e){System.out.println("Error! File " + fileName[i] + " not found!");}
			}
			for(int i=Database.relative.size()-1;i>=0;i--) Database.relative.remove(i);
			for(int i=Database.professional.size()-1;i>=0;i--) Database.professional.remove(i);
			for(int i=Database.personal.size()-1;i>=0;i--) Database.personal.remove(i);
			for(int i=Database.casual.size()-1;i>=0;i--) Database.casual.remove(i);
		}
}
