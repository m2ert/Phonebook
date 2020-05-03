package phonebookv3;

public class Contact {
	/* Default class for Contact object */
	 	private String Name;
	    private String PhoneNo;
	    private String EmailAddress;
	   
	    public Contact()
	    {
	        Name = "";
	        PhoneNo = "";
	        EmailAddress = "";
	    }

	    public String getName() {
	        return Name;
	    }

	    public void setName(String Name) {
	        this.Name = Name;
	    }

	    public String getPhoneNo() {
	        return PhoneNo;
	    }

	    public void setPhoneNo(String PhoneNo) {
	        this.PhoneNo = PhoneNo;
	    }

	    public String getEmailAddress() {
	        return EmailAddress;
	    }
	    
	    public void setEmailAddress(String EmailAddress) {
	        this.EmailAddress = EmailAddress;
	    }
}
