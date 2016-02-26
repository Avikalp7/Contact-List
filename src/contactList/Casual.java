package contactList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Casual extends Acquaintance
{
	public Date dateAcq;
	public String meetPlace;
	public String circumstance, usefulInfo;
	
	public void set_casual_details(String name, String mNumber, String eAddress, String dateAcq, String meetPlace, String circumstance, String usefulInfo) throws ParseException
	{
		String expectedPattern = "dd/MM/yyyy";
	    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		AcqID = Database.get_ID();
		super.name = name;
		super.mNumber = mNumber;
		super.eAddress = eAddress;
		this.dateAcq = formatter.parse(dateAcq);
		this.meetPlace = meetPlace;
		this.circumstance = circumstance;
		this.usefulInfo = usefulInfo;
	}
}
