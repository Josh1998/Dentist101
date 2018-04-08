public class Room {
	private int no;
	private String type;
	private double price;
	private String balcony;
	private String ailment;
	private String ID;
	private int passcode;

	// constructors must do everything as set methods are not necessary here
	public Room(int no, String type, double price, String balcony, String ailment, String ID, int passcode) {
		this.no = no;
		this.type = type;
		this.price = price;
		this.balcony = balcony;
		this.ailment = ailment;
		this.ID = ID;
		this.passcode = passcode;
	}
	
	@Override
	public String toString() {
		// ternary operators kick ass in string formatting
		return String.format("Appointment No:%02d  Date:%s  Time:%.2f  Dr:%s  isReserve:%s  %s",
				no, type, price, balcony , (isReserve() ? "Y" : "N"), (isReserve() ? "ID:" + ID + "  " +"Ailment:" + ailment : "" ));
	}
	// not sure to have this class doing this or have the calling class using get methods
		public String toSaveString() {
			return no + " " + type + " " + price + " " + balcony + " " + ailment + " " + ID + " " + (passcode == -1 ? "" : passcode);
		}
		public boolean isReserve() {
			return ID != "" ? true : false;
			
			/*
			if (eMail != "") {
				return true;
			}

			return false;
			*/
		}
	public void reserveRoom(String ailment, String ID, int passcode) throws Exception {
			// reserve check may be unnecessary but is best practice
			if (!isReserve()) {
				this.ailment = ailment;
				this.ID = ID;
				this.passcode = passcode;
			}
			else {
				throw new Exception("Already Reserve :(");
			}
		}
	public void cancelRoom(String ID) throws Exception {
	if (ID.equals(this.ID)) {
		this.ailment = "";
		this.ID = "";
		this.passcode = -1;
	}
	else {
		throw new Exception("eMails Don't Match :(");
	}
}

	public int checkMatch(String type, double price, String balcony) {
	// variable to tally up matching data
	int matching = 0;

	if (this.type.equalsIgnoreCase(type)) {
		matching++;
	}

	if (this.price <= price) {
		matching++;
	}

	if (this.balcony.equalsIgnoreCase(balcony)) {
		matching++;
	}


	return matching;
}
	public int getNo() {
		return no;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	// predicate accessors use 'is' not 'get'
	public String isBalcony() {
		return balcony;
	}
	public String getAilment() {
		return ailment;
	}
	

	public String getID() {
		return ID;
	}
	
	public int getPasscode() {
		return passcode;
	}
}
