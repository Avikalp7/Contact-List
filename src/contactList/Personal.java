package contactList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personal extends Acquaintance
{
	public String context;
	public Date dateAcq;
	public String specificEvent;
	public void set_personal_details(String name, String mNumber, String eAddress,String context, String dateAcq, String specificEvent) throws ParseException
	{
		String expectedPattern = "dd/MM/yyyy";
	    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
		AcqID = Database.get_ID();
		super.name = name;
		super.mNumber = mNumber;
		super.eAddress = eAddress;
		this.context = context;
		this.dateAcq = formatter.parse(dateAcq);
		this.specificEvent = specificEvent;
	}
	
}
