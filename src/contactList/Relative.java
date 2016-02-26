package contactList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Relative extends Acquaintance
{
	public Date birthDay;
	public Date lastMeeting;
	String expectedPattern = "dd/MM/yyyy";
	SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
	
	public void set_relative_details(String name, String mNumber, String eAddress, String birthDay, String lastMeeting) throws ParseException
	{
	    
		AcqID = Database.get_ID();
		super.name = name;
		super.mNumber = mNumber;
		super.eAddress = eAddress;
		this.setBirthDay(birthDay);
		this.setLastMeeting(lastMeeting);
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) throws ParseException {
		this.birthDay = formatter.parse(birthDay);
	}

	public Date getLastMeeting() {
		return lastMeeting;
	}

	public void setLastMeeting(String lastMeeting) throws ParseException {
		this.lastMeeting = formatter.parse(lastMeeting);
	}
}
