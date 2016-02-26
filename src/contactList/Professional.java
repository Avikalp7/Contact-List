package contactList;

public class Professional extends Acquaintance 
{
	public String commonInterest;
	public void set_professional_details(String name, String mNumber, String eAddress, String commonInterest)
	{
		AcqID = Database.get_ID();
		super.name = name;
		super.mNumber = mNumber;
		super.eAddress = eAddress;
		this.commonInterest = commonInterest;
	}
	
}
