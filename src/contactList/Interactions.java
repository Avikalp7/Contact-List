package contactList;

import java.text.ParseException;


public class Interactions
{
	public static void save()
	{
		Functions.save_relatives();
		Functions.save_professionals();
		Functions.save_personals();
		Functions.save_casuals();
	}
	
	public static void reconstruct() throws ParseException
	{
		Functions.reconstruct_relatives();
		Functions.reconstruct_professionals();
		Functions.reconstruct_personals();
		Functions.reconstruct_casuals();
	}
	
	public static boolean display_main_menu() throws ParseException
	{
		System.out.println("Welcome to your Contact List! Choose an option below to get started.");
		System.out.println("1. Create a New Acquaintance");
		System.out.println("2. Delete an Acquaintance");
		System.out.println("3. Display entire list of Acquaintances");
		System.out.println("4. Display specific category of Acquaintances");
		System.out.println("5. Search an Acquaintance by Name");
		System.out.println("6. Exit Program");
		System.out.println("7. Clear All Saved Data");
		int mainChoice = 0;
		// Take choice for main menu from user until he inputs a valid choice
		while(mainChoice!=6)
		{
			mainChoice = Functions.takeIntInput(7);
			if(mainChoice == 1)
			{
				int subChoice = sub_menu();
				switch (subChoice)
				{
					case 1:
						Functions.create_new_relative();
						save();
						break;
					case 2:
						Functions.create_new_professional();
						save();
						break;
					case 3:
						Functions.create_new_personal();
						save();
						break;
					case 4:
						Functions.create_new_casual();
						save();
						break;
					case 5:
						return true;
				}
			}
			
			if(mainChoice == 2)
			{
				System.out.println("Choose a field to delete from :");
				print_message(6);
				int dChoice =Functions.takeIntInput(5);
				switch(dChoice)
				{
					case 1:
						if(Database.relative.size()==0) System.out.println("There are no relatives in your list to delete");
						else
						{
							//Functions.display_all_relatives(true);
							int rdIdx = Functions.select_ID(1);
							Database.relative.remove(rdIdx);
							System.out.println("Specified contact has been successfuly removed.");
							save();
						}
						break;
					case 2:
						if(Database.professional.size()==0) System.out.println("There are no professionals in your list to delete");
						else
						{
							//Functions.display_all_professionals(true);
							int pfdIdx = Functions.select_ID(2);
							Database.professional.remove(pfdIdx);
							System.out.println("Specified contact has been successfuly removed.");
							save();
						}
						break;
					case 3:
						if(Database.personal.size()==0) System.out.println("There are no personals in your list to delete");
						else
						{
							//Functions.display_all_personals(true);
							int pdIdx = Functions.select_ID(3);
							Database.personal.remove(pdIdx);
							System.out.println("Specified contact has been successfuly removed.");
							save();
						}
						break;
					case 4:
						if(Database.casual.size()==0) System.out.println("There are no casuals in your list to delete");
						else
						{
							//Functions.display_all_casuals(true);
							int rdIdx = Functions.select_ID(4);
							Database.casual.remove(rdIdx);
							System.out.println("Specified contact has been successfuly removed.");
							save();
						}
						break;
					case 5:
						return true;
				}
				
			}
			
			if(mainChoice == 3)
			{
				Functions.display_all(true);
			}
			
			if(mainChoice==4)
			{
				System.out.println("Choose a category to display :");
				print_message(6);
				int disChoice = Functions.takeIntInput(5);
				switch(disChoice)
				{
					case 1:
						if(Database.relative.size()==0) System.out.println("There are no relatives to display");
						else
						{
							Functions.display_all_relatives(false);
						}
						break;
					case 2:
						if(Database.professional.size()==0) System.out.println("There are no professional friends to display");
						else
						{
							Functions.display_all_professionals(false);
						}
						break;
					case 3:
						if(Database.personal.size()==0) System.out.println("There are no personal friends to display");
						else
						{
							Functions.display_all_personals(false);
						}
						break;
					case 4:
						if(Database.casual.size()==0) System.out.println("There are no casual acquaintances to display");
						else
						{
							Functions.display_all_casuals(false);
						}
						break;
					case 5:
						return true;
				}
			}
			
			if(mainChoice==5)
			{
				System.out.println("Enter Name : ");
				String name = Functions.takeStrInput();
				while(name.length()==0)
				{
					System.out.println("Null String is not valid for a search, please enter name again");
					name = Functions.takeStrInput();
				}
				int counter = Functions.search(name);
				if(counter==0)System.out.println("No Results Found");
				else
				{
					print_message(0);
					System.out.println("TOTAL RESULTS : "  + counter);
				}
			}
			if(mainChoice==7)
			{
				System.out.println("Are you sure? All saved data will be removed and can't be recoverd. Y/N?");
				String yn = Functions.takeYNInput();
				if(yn.equals("Y"))
				{
					Functions.clear();
					System.out.println("Data has been cleared successfully");
				}
			}
			
			if(mainChoice!=6)
			{
				if(mainChoice>8) print_message(1);
				System.out.println(""); System.out.println("Go back to Main Menu Y/N? (No will exit the program)");
				String menuChoice = Functions.takeStrInput();
				while(!(menuChoice.equals("Y")||menuChoice.equals("N")))
				{
					System.out.println("Please enter Y or N only");
					menuChoice = Functions.takeStrInput();
				}
				if(menuChoice.equals("Y"))
				{
					return true;
				}
				else return false;
			}
		}
				
		return false;
	}
	
	public static int sub_menu()
	{
		int subChoice;
		System.out.println("1. New Relative");
		System.out.println("2. New Professional Friend");
		System.out.println("3. New Personal Friend");
		System.out.println("4. New Casual Acquaintance");
		System.out.println("5. Go Back to Home Menu");
		subChoice = Functions.takeIntInput(5);
		return subChoice;
	}
	
	public static void print_message(int line)
	{
		switch (line)
		{
			case 0 :
				System.out.println(""); break;
			case 1:
				System.out.println("Please enter a valid choice");
				break;
			case 2:
				System.out.println("Enter Name and Mobile Number in separate lines.");
				break;
			case 3:
				System.out.println("Please enter a valid date / date format dd/mm/yyyy :");
				break;
			case 4:
				System.out.println("Your description crosses the max limit of 100 chars. Enter a vaild length input again.");
				break;
			case 5:
				System.out.println("Data created successfully.");
				break;
			case 6:
				System.out.println("1. Relative    2. Professional Friend    3. Personal Friend    4. Causal Acquaintance    5.Go back to Home Menu");
				break;
			case 7:
				System.out.println("Enter ID to select");
				break;
		}
	}
}
