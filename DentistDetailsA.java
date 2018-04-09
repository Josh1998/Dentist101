public class DentistDetailsA {

	String dentistID;
	String firstName;
	String lastName;
	String password;
	String address; 
	   
	   public DentistDetailsA(String dentistID, String firstName, String lastName, String password, String address) {
		   this.dentistID = dentistID;
		   this.firstName = firstName;
		   this.lastName = lastName;
		   this.password = password;
		   this.address = address;
		   
	   }
	   
	   public String display() {
			String result = dentistID + " " + firstName + " " + lastName;
			return result;
			}
	   
	   public String getDentistID() {
			return this.dentistID;
		}

		public String getFirstName() {
			return this.firstName;
		}
		
		public String getLastName() {
			return this.lastName;
		}
		
		public String getPassword() {
			return this.password;
		}
		
		public String getAddress() {
			return this.address;
		}
		
		public void addFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public void addLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public void addPassword(String password) {
			this.password = password;
		}
		
		public void addAddress(String address) {
			this.address = address;
		}
		
		public void removeFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public void removeLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public void removePassword(String password) {
			this.password = password;
		}
		
		public void removeAddress(String address) {
			this.address = address;
		}
		
		public String save() {
			String finish = dentistID + " " + firstName + " " + lastName + " " + password + " " + address;
			return finish;
		}

}
