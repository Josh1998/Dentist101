
public class Appointment {


		String Weekday;
		String TimeOfAppointment;
		String Dentist;
		String TypeOfAilment;
		String ID;
		
		public Appointment(String Weekday, String TimeOfAppointment, String Dentist, String TypeOfAilment, String ID ) {
		
			this.Weekday= Weekday;
			this.TimeOfAppointment= TimeOfAppointment;
			this.Dentist= Dentist;
			this.TypeOfAilment= TypeOfAilment;
			this.ID= ID;
		}
		// makes the data into string type
			public String toString() {
					String result= Weekday+ " " + TimeOfAppointment+ " " + Dentist + " " + TypeOfAilment + " " + ID;
					return result;
			}
			
			public String getDentist(){
				return this.Dentist;
			}
			public String getTypeOfAilment(){
				return this.TypeOfAilment;
			}
			public String getID(){
				return this.ID;
			}
			public void order(String TypeOfAilment, String ID) {
				this.TypeOfAilment=TypeOfAilment;
				this.ID=ID;
			}
			public void cancel(String TypeOfAilment, String ID) {
				this.TypeOfAilment=TypeOfAilment;
				this.ID=ID;
			}
	}

