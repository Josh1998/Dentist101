import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.io.PrintWriter;

public class DentistPracticeSystem {

		static final Scanner Menu = new Scanner(System.in);
		private static Scanner input = new Scanner(System.in);
		 
		final static PatientDetailsA[] PatientDetailsArray = new PatientDetailsA[5];
		final static DentistDetailsA[] dentistDetailsArray = new DentistDetailsA[3];
		final static patientTreatments[] treatments = new patientTreatments[25];
		private static final String ListOfAppointments = "D://Dentist//AppointmentList.txt";
		private static final Scanner userInput = new Scanner(System.in);
		private static int caesarCipher = 3; 
		private static final HashMap<Integer, AppointmentInfo> appointments = new HashMap<Integer, AppointmentInfo>();
		private static Scanner group = new Scanner(System.in);
		
		 
		 	static String globalPatientID = "notFilledIn";
		 	static String globalPatientFirstName = "notFilledIn";
			static String globalPatientLastName = "notFilledIn";
			static String globalPatientPassword = "notFilledIn";
			
			static String globalDentistID = "notFilledIn";
		 	static String globalDentistFirstName = "notFilledIn";
			static String globalDentistLastName = "notFilledIn";
			static String globalDentistPassword = "notFilledIn";
		// fuck off
		public static void main(String[] args) throws Exception {
			loadAppointmentData();

			String choice = "";

			System.out.println("-- Welcome to the Dentists --");
			System.out.println(" ");
			
			loadPatientDetails();
			loadDentistDetails();
			treatmentList();

			do {
				System.out.println("1 - Admin");
				System.out.println("2 - Dentist");
				System.out.println("3 - Patient");
				System.out.println("Q - Quit");
				System.out.print("Pick : ");

				choice = Menu.next().toUpperCase();

				switch (choice) {
					case "1" : {
						Admin();
						break;
					}
					case "2" : {
						Dentist();
						break;
					}
					case "3" : {
						Patient();
						break;
					}
					case "4" : {

						break;
					}
				}
			} while (!choice.equals("Q"));
			
			savePatientDetails();
			saveDentistDetails();
			saveData();
			saveTreatments();
			
			
	}

		public static void Patient() throws FileNotFoundException {
			
			Scanner PatientDetails = new Scanner(new FileReader("D:\\Dentist\\PatientDetails.txt"));
			
				System.out.println("Please input your patientID:");
				String logInPatientID = input.next();
				System.out.println("Please input your first name:");
				String logInFirstName = input.next();
				System.out.println("Please input your last name:");
				String logInLastName = input.next();
				System.out.println("Please input your password:");
				String logInPassword = input.next();
				
				for (int i = 0; i<PatientDetailsArray.length; i++)
				{
					
					if ((PatientDetailsArray[i].getPatientID().equals(logInPatientID))&&(PatientDetailsArray[i].getFirstName().equals(logInFirstName))&&(PatientDetailsArray[i].getLastName().equals(logInLastName))&&(PatientDetailsArray[i].getPassword().equals(logInPassword)))
					{
						System.out.println("Your chosen account is:");
						System.out.println(PatientDetailsArray[i].display());
						globalPatientID = logInPatientID;
						globalPatientFirstName = logInFirstName;
						globalPatientLastName = logInLastName;
						globalPatientPassword = logInPassword;
						break;
					}
				}
				
				if (globalPatientPassword.equals("notFilledIn")) {
					 System.out.println("Your username or password is incorrect");
					
				}
				else { System.out.println("Successfully logged in");
					patientSubMenu();
				}	
		}
		
		private static void Dentist() throws FileNotFoundException {
			
			Scanner dentistDetails = new Scanner(new FileReader("D:\\Dentist\\dentistDetails.txt"));
				
				System.out.println("Please input your DentistID:");
				String logInDentistID = input.next();
				System.out.println("Please input your first name:");
				String logInFirstName = input.next();
				System.out.println("Please input your last name:");
				String logInLastName = input.next();
				System.out.println("Please input your password:");
				String logInPassword = input.next();
				
				for (int i = 0; i<PatientDetailsArray.length; i++)
				{
					
					if ((dentistDetailsArray[i].getDentistID().equals(logInDentistID))&&(dentistDetailsArray[i].getFirstName().equals(logInFirstName))&&(dentistDetailsArray[i].getLastName().equals(logInLastName))&&(dentistDetailsArray[i].getPassword().equals(logInPassword)))
					{
						System.out.println("Your chosen account is:");
						System.out.println(dentistDetailsArray[i].display());
						globalDentistID = logInDentistID;
						globalDentistFirstName = logInFirstName;
						globalDentistLastName = logInLastName;
						globalDentistPassword = logInPassword;
						break;
					}
				}
				
				if (globalDentistPassword.equals("notFilledIn")) {
					 System.out.println("Your username or password is incorrect");
					
				}
				else { System.out.println("Successfully logged in");
					dentistSubMenu();
				}
		}
		
		private static void Admin() throws FileNotFoundException {
			Scanner admin = new Scanner(System.in);
			
			for(int i=0; i<3; i++) {
			
				System.out.println("Please input username");
				String usernameA = admin.next();
				System.out.println("Please input password");
				String passwordA = admin.next();
				
				if (usernameA.equals("Admin")&&passwordA.equals("password")) {
					adminSubMenu();
					break;
					
				}
				else { System.out.println("Your username or password is incorrect, please try again");
				
				}
			}
				System.out.println("Returning to menu.");
				
			
		}
		
		
		private static void patientSubMenu() throws FileNotFoundException {
			
			 final Scanner P = new Scanner(System.in);
			 
			 String patientChoice = "";
		
			do {
				System.out.println("1 - Add/change your personal details");
				System.out.println("2 - Previous visits to the practice");
				System.out.println("3 - Previous treatments received");
				System.out.println("4 - Request any appointment");
				System.out.println("5 - Request a specified appointment");
				System.out.println("6 - Cancel your appointment/s");
				System.out.println("7 - Do you allow your practice admin to view your treatment list (Y/N)");
				System.out.println("R - Return to main menu");
				System.out.print("Pick : ");

				patientChoice = P.next().toUpperCase();

				switch (patientChoice) {
					case "1" : {
						changePatientDetails();
						break;
					}
					case "2" : {
						PreviousVists();
						break;
					}
					case "3" : {
						displayTreatment();
						break;
					}
					case "4" : {
						reserveRoom();
						break;
					}
					case "5" : {
						searchRoom();
						break;
					}
					case "6" : {
						cancelRoom();
						break;
					}
					case "7" : {
						Privacy();
						break;
					}
					case "8" : {

						break;
					}
				}
			} while (!patientChoice.equals("R"));

			
			
		}
		
		private static void dentistSubMenu() throws FileNotFoundException {
			final Scanner D = new Scanner(System.in);
			
			String choice = "";
			
			do {
				System.out.println("1 - Add/change personal details");
				System.out.println("2 - View calendar");
				System.out.println("3 - List previous appointments");
				System.out.println("4 - Add treatment to a patient");
				System.out.println("5 - List Treatments Given");
				System.out.println("R - Return to main menu");
				System.out.print("Pick : ");

				choice = D.next().toUpperCase();

				switch (choice) {
					case "1" : {
						changeDentistDetails();
						break;
					}
					case "2" : {
						viewAllAppointments();
						break;
					}
					case "3" : {
						ListAppointments();
						break;
					}
					case "4" : {
						addTreatmentToPatient();
						break;
					}
					case "5" : {
						displayTreatmentForDentist();
						break;
					}

				}
			} while (!choice.equals("R"));
			
		}
		

		private static void adminSubMenu() throws FileNotFoundException {

			final Scanner A = new Scanner(System.in);
			
			String choice = "";
			
			do {
				System.out.println("1 - Add/remove dentist");
				System.out.println("2 - Add/remove patient");
				System.out.println("3 - Add/change first choice dentist");
				System.out.println("4 - Alter working days");
				System.out.println("5 - List upcoming appointments");
				System.out.println("6 - List previous visits made");
				System.out.println("7 - List treatments made");
				System.out.println("R - Return to main menu");
				System.out.print("Pick : ");

				choice = A.next().toUpperCase();

				switch (choice) {
					case "1" : {
						AddremoveDentist();
						break;
					}
					case "2" : {
						AddremovePatient();
						break;
					}
					case "3" : {
						AddremoveFirstChoice();
						break;
					}
					case "4" : {
						//();
						break;
					}
					case "5" : {
						ListAppointments();
						break;
					}
					case "6" : {
						ListPreviousUpcomingVisits();
						break;
					}
					case "7" : {
						displayTreatments();
						break;
					}
				}
			} while (!choice.equals("R"));
			
		}
			
			
		public static void loadPatientDetails() throws FileNotFoundException {
			
			Scanner PatientDetails = new Scanner(new FileReader("D:\\Dentist\\PatientDetails.txt"));
			
			
			int amount = 0;
			
			while(PatientDetails.hasNext()) {
				
				String patientID = PatientDetails.next();
				String firstName = PatientDetails.next();
				String lastName = PatientDetails.next();
				String password = PatientDetails.next();
				String address = PatientDetails.next();
				String firstDentist = PatientDetails.next();
				
				PatientDetailsArray[amount] = new PatientDetailsA(patientID, firstName, lastName, password, address, firstDentist);
				amount++;
				
			}
		}
		
		public static void savePatientDetails() throws FileNotFoundException {
			
			Scanner PatientDetails = new Scanner(new FileReader("D:\\Dentist\\PatientDetails.txt"));
			
			
			PrintWriter save = new PrintWriter("D:\\Dentist\\PatientDetails.txt");

			for (int i=0; i<PatientDetailsArray.length ; i++)
			  {
			     save.println(PatientDetailsArray[i].save());
			  }
			save.close();
			
			System.out.println("Data Saved.");
		}

		public static void AddremovePatient() throws FileNotFoundException {
			
			Scanner PatientDetails = new Scanner(new FileReader("D:\\Dentist\\PatientDetails.txt"));
			
			String addPatient = "0";
			String addFirstName = "free";
			String addLastName = "free";
			String addPassword = "free";
			String addAddress = "free";
			
			System.out.println("Would you like to add or remove a patient?");
			System.out.println("1 - Add");
			System.out.println("2 - Remove");
			
			addPatient = input.next().toUpperCase();
			
			if (addPatient.equals("1")) {
				
				String empty = "free";
				
				System.out.println("Please remember to use the '_' instead of spaces, thank you.");
				System.out.println(" ");
				
				System.out.println("Please enter first name:");
				addFirstName = input.next();
				
				System.out.println("Please enter last name:");
				addLastName = input.next();
				
				System.out.println("Please enter new password name:");
				addPassword = input.next();
				
				System.out.println("Please enter address:");
				addAddress = input.next();
				
				for (int i = 0; i<PatientDetailsArray.length; i++)
				{
				
					if ((PatientDetailsArray[i].getFirstName().equals(empty))&&(PatientDetailsArray[i].getLastName().equals(empty))&&(PatientDetailsArray[i].getPassword().equals(empty))&&(PatientDetailsArray[i].getAddress().equals(empty))&&(PatientDetailsArray[i].getFirstDentist().equals(empty)))
					{
						PatientDetailsArray[i].addFirstName(addFirstName);
						PatientDetailsArray[i].addLastName(addLastName);
						PatientDetailsArray[i].addPassword(addPassword);
						PatientDetailsArray[i].addAddress(addAddress);
						break;
					}
				
				}
				
				
				
			}
			
			
			else {
			
			System.out.println("Please enter first name:");
			String firstNameRemove = input.next();
			
			System.out.println("Please enter last name:");
			String lastNameRemove = input.next();
			
			System.out.println("Please enter password:");
			String passwordRemove = input.next();
			
			System.out.println("Please enter Patient ID:");
			String patientIDRemove = input.next();
			String remove = "free";
			
			
			for (int i = 0; i<PatientDetailsArray.length; i++)
			{
				if ((PatientDetailsArray[i].getFirstName().equals(firstNameRemove))&&(PatientDetailsArray[i].getLastName().equals(lastNameRemove))&&(PatientDetailsArray[i].getPassword().equals(passwordRemove)))
				{
					
					PatientDetailsArray[i].removeFirstName(remove);
					PatientDetailsArray[i].removeLastName(remove);
					PatientDetailsArray[i].removePassword(remove);
					PatientDetailsArray[i].removeAddress(remove);
					PatientDetailsArray[i].removeFirstDentist(remove);
					break;
				}
			}
			
			for (int i = 0; i<treatments.length; i++)
			{
				if ((treatments[i].getPatientID().equals(patientIDRemove)))
				{
					treatments[i].removePatientID(remove);
					treatments[i].removeTreatment(remove);
					treatments[i].removeDate(remove);
					treatments[i].removeDentist(remove);
					break;
				}
			}
			
			}
			
		}
	

		private static void AddremoveFirstChoice() throws FileNotFoundException {
			

			
			String change = "free";
			
			System.out.println("Please enter first name:");
			String FirstName = input.next();
			
			System.out.println("Please enter last name:");
			String LastName = input.next();
			
			System.out.println("Please enter new password name:");
			String Password = input.next();
			
			System.out.println("Would you like to add or remove your First Choice dentist?");
			System.out.println("1 - Add");
			System.out.println("2 - Remove");
			
			String addFirstChoice = input.next().toUpperCase();
			
			if (addFirstChoice.equals("1")) {
			
				for (int i = 0; i<PatientDetailsArray.length; i++)
				{
				
					if ((PatientDetailsArray[i].getFirstName().equals(FirstName))&&(PatientDetailsArray[i].getLastName().equals(LastName))&&(PatientDetailsArray[i].getPassword().equals(Password)))
					{
						System.out.println("Please enter your First Choice dentist's:");
						String FirstDentist = input.next();
						PatientDetailsArray[i].changeFirstDentist(FirstDentist);
						break;
					}
					
				}
			}
			
			else {
				
				for (int i = 0; i<PatientDetailsArray.length; i++)
				{
				
					if ((PatientDetailsArray[i].getFirstName().equals(FirstName))&&(PatientDetailsArray[i].getLastName().equals(LastName))&&(PatientDetailsArray[i].getPassword().equals(Password)))
					{
						
						PatientDetailsArray[i].changeFirstDentist(change);
						break;
					}
					
				}
				
			}
			
		
			
		}

		private static void ListAppointments() {
			System.out.print("Please enter your Surname : ");
			String surname = userInput.next();
			
			boolean areRooms = false;
			
			for (AppointmentInfo appointment : appointments.values()) {
				if (appointment.isReserve()) {
					if ((surname.equals(appointment.isBalcony()))) {
						System.out.println(appointment.toString());
						areRooms = true;
					}
				}
			}
		}

		private static void ListPreviousUpcomingVisits() {
			// TODO Auto-generated method stub
			
		}

		private static void treatmentList() throws FileNotFoundException {
			
			
			Scanner file = new Scanner(new FileReader("D:\\Dentist\\Treatments.txt"));
			int statement = 0;
		
			while (file.hasNext()) {
				String patientID = file.next();
				String treatment = file.next();
				String date = file.next();
				String dentist = file.next();
				
				treatments[statement] = new patientTreatments(patientID, treatment, date, dentist);
				statement++;
			}
			file.close();
		}
		
		private static void displayTreatments() throws FileNotFoundException {
			treatmentList();
			for (int i=0; i<treatments.length; i++) { 
				
				System.out.println("");
				System.out.println(treatments[i].displayTreatments());
				
			}
		}
		
		public static void loadDentistDetails() throws FileNotFoundException {
		
			Scanner dentistDetails = new Scanner(new FileReader("D:\\Dentist\\DentistDetails.txt"));

			
			int amount = 0;
			
			while(dentistDetails.hasNext()) {
				
				String dentistID = dentistDetails.next();
				String firstName = dentistDetails.next();
				String lastName = dentistDetails.next();
				String password = dentistDetails.next();
				String address = dentistDetails.next();
				
				
				dentistDetailsArray[amount] = new DentistDetailsA(dentistID, firstName, lastName, password, address);
				amount++;
				
			}
		}
		
		public static void saveDentistDetails() throws FileNotFoundException {
			

			PrintWriter save = new PrintWriter("D:\\Dentist\\DentistDetails.txt");

			for (int i=0; i<dentistDetailsArray.length ; i++)
			  {
			     save.println(dentistDetailsArray[i].save());
			  }
			save.close();
			
			
		}

		private static void AddremoveDentist() throws FileNotFoundException {
			
			
			
			String addDentist = "0";
			String addFirstName = "free";
			String addLastName = "free";
			String addPassword = "free";
			String addAddress = "free";
			
			System.out.println("Would you like to add or remove a Dentist?");
			System.out.println("1 - Add");
			System.out.println("2 - Remove");
			
			addDentist = input.next().toUpperCase();
			
			if (addDentist.equals("1")) {
				
				String empty = "free";
				
				System.out.println("Please remember to use the '_' instead of spaces, thank you.");
				System.out.println(" ");
				
				System.out.println("Please enter first name:");
				addFirstName = input.next();
				
				System.out.println("Please enter last name:");
				addLastName = input.next();
				
				System.out.println("Please enter new password:");
				addPassword = input.next();
				
				System.out.println("Please enter address:");
				addAddress = input.next();
				
				for (int i = 0; i<dentistDetailsArray.length; i++)
				{
				
					if ((dentistDetailsArray[i].getFirstName().equals(empty))&&(dentistDetailsArray[i].getLastName().equals(empty))&&(dentistDetailsArray[i].getPassword().equals(empty)))
					{
						
						dentistDetailsArray[i].addFirstName(addFirstName);
						dentistDetailsArray[i].addLastName(addLastName);
						dentistDetailsArray[i].addPassword(addPassword);
						dentistDetailsArray[i].addAddress(addAddress);
						break;
					}
				
				}
				
				
				
			}
			
			
			else {
			
			
			
			System.out.println("Please enter first name:");
			String firstNameRemove = input.next();
			
			System.out.println("Please enter last name:");
			String lastNameRemove = input.next();
			
			System.out.println("Please enter password:");
			String passwordRemove = input.next();
			
			String remove = "free";
			
			for (int i = 0; i<dentistDetailsArray.length; i++)
			{
				if ((dentistDetailsArray[i].getFirstName().equals(firstNameRemove))&&(dentistDetailsArray[i].getLastName().equals(lastNameRemove))&&(dentistDetailsArray[i].getPassword().equals(passwordRemove)))
				{
					
					dentistDetailsArray[i].removeFirstName(remove);
					dentistDetailsArray[i].removeLastName(remove);
					dentistDetailsArray[i].removePassword(remove);
					dentistDetailsArray[i].removeAddress(remove);
					break;
				}
			}
		}
	}

		
		private static void addTreatmentToPatient() throws FileNotFoundException {
			
		Scanner file = new Scanner(new FileReader("D:\\Dentist\\Treatments.txt"));
		
		System.out.println("Please enter the patient's ID: ");
		String setPatientID = input.next();
		
		System.out.println("Please enter the treatment: ");
		String setTreatment = input.next();
		
		System.out.println("Please enter the date: ");
		String setDate = input.next();
		
		String setDentist = globalDentistLastName;
		
		String empty = "free";
	
		
		for (int i = 0; i<treatments.length; i++)
			
		{
			
			if ((treatments[i].getPatientID().equals(empty))&&(treatments[i].getTreatment().equals(empty))&&(treatments[i].getDate().equals(empty))&&(treatments[i].getDentist().equals(empty)))
			{
				
				treatments[i].addPatientID(setPatientID);
				treatments[i].addTreatment(setTreatment);
				treatments[i].addDate(setDate);
				treatments[i].addDentist(setDentist);
				break;
			}
		}
	}

		public static void displayTreatmentForDentist() throws FileNotFoundException {
			
			
			String checkDentistLastName = globalDentistLastName;
			
			Scanner file = new Scanner(new FileReader("D:\\Dentist\\Treatments.txt"));
			
			
			for (int i = 0; i<treatments.length; i++)
				
			{
				
				if ((treatments[i].getDentist().equals(checkDentistLastName)))
				{
					System.out.println("");
					System.out.println("Your treatment information is:");
					System.out.println(treatments[i].displayTreatment()); 
					System.out.println("");
				}
			}
		}
				
		public static void changePatientDetails() throws FileNotFoundException {
			
		
			
			String checkFirstName = globalPatientFirstName;
			String checkLastName = globalPatientLastName;
			String checkPassword = globalPatientPassword;
			String checkPatientID = globalPatientID;

			
			System.out.println("Please remember to use the '_' instead of spaces, thank you.");
			System.out.println(" ");
			
			System.out.println("Please enter new first name:");
			String newFirstName = input.next();
			
			System.out.println("Please enter new last name:");
			String newLastName = input.next();
			
			System.out.println("Please enter new password name:");
			String newPassword = input.next();
			
			System.out.println("Please enter new address:");
			String newAddress = input.next();
			
			System.out.println("Please enter new First Choice Dentist:");
			String newFirstDentist = input.next();
			
			
			for (int i = 0; i<PatientDetailsArray.length; i++)
			{
			
				if ((PatientDetailsArray[i].getPatientID().equals(checkPatientID))&&(PatientDetailsArray[i].getFirstName().equals(checkFirstName))&&(PatientDetailsArray[i].getLastName().equals(checkLastName))&&(PatientDetailsArray[i].getPassword().equals(checkPassword)))
				{
					
					PatientDetailsArray[i].addFirstName(newFirstName);
					PatientDetailsArray[i].addLastName(newLastName);
					PatientDetailsArray[i].addPassword(newPassword);
					PatientDetailsArray[i].addAddress(newAddress); 
					PatientDetailsArray[i].changeFirstDentist(newFirstDentist); 
					break;
				}
			
			}
			
		}
		
		public static void changeDentistDetails() throws FileNotFoundException {
			
			
			
			String checkFirstName = globalDentistFirstName;
			String checkLastName = globalDentistLastName;
			String checkPassword = globalDentistPassword;
			String checkPatientID = globalDentistID;

			
			System.out.println("Please remember to use the '_' instead of spaces, thank you.");
			System.out.println(" ");
			
			System.out.println("Please enter new first name:");
			String newFirstName = input.next();
			
			System.out.println("Please enter new last name:");
			String newLastName = input.next();
			
			System.out.println("Please enter new password name:");
			String newPassword = input.next();
			
			System.out.println("Please enter new address:");
			String newAddress = input.next();
			
			for (int i = 0; i<PatientDetailsArray.length; i++)
			{
			
				if ((dentistDetailsArray[i].getDentistID().equals(checkPatientID))&&(dentistDetailsArray[i].getFirstName().equals(checkFirstName))&&(dentistDetailsArray[i].getLastName().equals(checkLastName))&&(dentistDetailsArray[i].getPassword().equals(checkPassword)))
				{
					
					dentistDetailsArray[i].addFirstName(newFirstName);
					dentistDetailsArray[i].addLastName(newLastName);
					dentistDetailsArray[i].addPassword(newPassword);
					dentistDetailsArray[i].addAddress(newAddress);
					break;
				}
			
			}
			
		}
		
		private static void PreviousVists() {
			
			System.out.print("ID : ");
			String ID = userInput.next();
			
			System.out.print("password : ");
			String password = userInput.next();
			
			System.out.println("");
			System.out.println("-- " + ID + " PREVIOUS/UPCOMING APPOINTMENTS LIST --");

			boolean isThereAppointments = false;

			for (AppointmentInfo appointment : appointments.values()) {
				if (appointment.isReserve()) {
					if ((ID.equals(appointment.getID())&&(password.equals(appointment.getPassword())))) {
						System.out.println(appointment.toString());
						isThereAppointments = true;
						System.out.println("");
					}
				}
			}	
		}
		public static void displayTreatment() throws FileNotFoundException {
			treatmentList();
				
				String checkPatientID = globalPatientID;
				
				Scanner file = new Scanner(new FileReader("D:\\Dentist\\Treatments.txt"));
				
				for (int i = 0; i<treatments.length; i++)
				{
								
								if ((treatments[i].getPatientID().equals(checkPatientID)))
								{
									System.out.println("");
									System.out.println("Your treatment information is:");
									System.out.println(treatments[i].displayTreatment()); 
									
				        }
								}
		}
			
		
		
		private static void viewAllAppointments() {
			for (AppointmentInfo appointment : appointments.values())
				System.out.println(appointment.toString());
		}
		private static void loadAppointmentData() throws Exception {
			Scanner userInput;
			
	
			userInput = new Scanner(new FileReader(ListOfAppointments));

			String information = "";
			String decrypt = "";
			char fileSecurity;
			
			while (userInput.hasNext()) {
				
				information = userInput.nextLine();
				decrypt = "";
				for (int i = 0; i < information.length(); i++) {
					fileSecurity = information.charAt(i);
					fileSecurity = (char) (fileSecurity + -caesarCipher);
					
					decrypt = decrypt + fileSecurity;
				}
				
				String[] strs = decrypt.split(" ");

	

	
				appointments.put(Integer.parseInt(strs[0]), new AppointmentInfo(Integer.parseInt(strs[0]), strs[1], Double.parseDouble(strs[2]), strs[3], (strs.length == 7 ? strs[4] : ""), (strs.length == 7 ? strs[5] : ""), (strs.length == 7 ? strs[6] : "")));
			}

	
			userInput.close();
		}
		
		private static void reserveRoom() {
			System.out.println("-- AVAILABLE ROOMS --");

					boolean isThereAppointments = false;

					for (AppointmentInfo appointment : appointments.values()) {
						if (!appointment.isReserve()) {
							System.out.println(appointment.toString());
							isThereAppointments = true;
						}
					}

					aquireRoom(isThereAppointments);
				}
		private static void searchRoom() {
			System.out.println("-- SEARCH FOR AN APPOINTMENT --");

			boolean isThereAppointments = false;

			System.out.print("Type a preferred date in April you would like [Format: 01/04/2018] : ");
			String type = userInput.next();

			System.out.print("Latest time you can make the appointement : ");
			double price = userInput.nextDouble();

			System.out.print("Please enter first choice dentist [Surname] : ");
			String balcony = userInput.next();
			
				for (int match = 3; match >= 1; match--) {
					isThereAppointments = false;

				System.out.println("Showing Appointments Matching " + match + " Requirements !");

				for (AppointmentInfo appointment : appointments.values()) {
					if (!appointment.isReserve()) {
						if (appointment.checkMatch(type, price, balcony) == match) {
							System.out.println(appointment.toString());
							isThereAppointments = true;
						}
					}
				}

				if (isThereAppointments) {
					break;
				}
				else {
					System.out.println("No Rooms Matching : " + match + " Requirements !");
				}
			}

			aquireRoom(isThereAppointments);
		}
		
		private static void aquireRoom(boolean isThereAppointments) {
			if (isThereAppointments) {
				System.out.print("Reserve Appointment No : ");
				int no = userInput.nextInt();
				
				System.out.print("What is your ailment? [1:Toothache, 2:Accident, 3:Bleeding, 4:Over-Sensitive, 5:Other] ");
				String ailment = userInput.next();
				if (ailment.equals("1")) {
					ailment = "Toothache";
					}
				else if (ailment.equals("2")) {
					ailment = "Accident";
					}
				else if (ailment.equals("3")) {
					ailment = "Bleeding";
					}
				else if (ailment.equals("4")) {
					ailment = "Over-Sensitive";
					}
				else if (ailment.equals("5")) {
					ailment = "Other";
				}

				System.out.print("ID : ");
				String ID = userInput.next();
				
				System.out.print("password : ");
				String password = userInput.next();

				try {
					
					appointments.get(no).reserveRoom(ailment, ID, password);

					System.out.println("Victory !");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("No Appointments are available at this time");
			}
		}
		private static void cancelRoom() {
			System.out.print("What was your ailment? [1:Toothache, 2:Accident, 3:Bleeding, 4:Over-Sensitive, 5:Other] ");
			String ailment = userInput.next();
			if (ailment.equals("1")) {
				ailment = "Toothache";
				}
			else if (ailment.equals("2")) {
				ailment = "Accident";
				}
			else if (ailment.equals("3")) {
				ailment = "Bleeding";
				}
			else if (ailment.equals("4")) {
				ailment = "Over-Sensitive";
				}
			else if (ailment.equals("5")) {
				ailment = "Other";
			}
			
			System.out.print("ID : ");
			String ID = userInput.next();
			
			System.out.print("password : ");
			String password = userInput.next();

			System.out.println("-- " + ID + " RESERVE APPOINTMENTS --");

			boolean isThereAppointments = false;

			for (AppointmentInfo appointment : appointments.values()) {
				if (appointment.isReserve()) {
					if ((ailment.equals(appointment.getAilment()))&&(ID.equals(appointment.getID())&&(password.equals(appointment.getPassword())))) {
						System.out.println(appointment.toString());
						isThereAppointments = true;
					}
				}
			}
			if (isThereAppointments) {
				System.out.print("Cancel Appointment No : ");
				int no = userInput.nextInt();

				try {
					
					appointments.get(no).cancelRoom(ID);

					System.out.println("Victory !");
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("There are no appointments matching your credentials");
			}
		}

		private static void saveData() throws Exception {
				
			String information = "";
			char fileSecurity;
			String encrypt = "";
			
			try (PrintWriter pw = new PrintWriter(new FileWriter(ListOfAppointments))) {
				for (AppointmentInfo appointment : appointments.values()) {
					
					information = appointment.toSaveString();
					encrypt = "";
					
					for (int i = 0; i < information.length(); i++) {
						fileSecurity = information.charAt(i);
						fileSecurity = (char) (fileSecurity + caesarCipher);
						
						encrypt = encrypt + fileSecurity;
					}
					pw.println(encrypt); 
						
				}
				pw.close();
			}
			
		  }
		
		
		private static void Privacy() {
			// TODO Auto-generated method stub
			
		}
		public static void saveTreatments() throws FileNotFoundException {
			
			Scanner PatientDetails = new Scanner(new FileReader("D:\\Dentist\\PatientDetails.txt"));
			
			
			PrintWriter save = new PrintWriter("D:\\Dentist\\Treatments.txt");

			for (int i=0; i<treatments.length ; i++)
			  {
			     save.println(treatments[i].save());
			  }
			save.close();
			
			
		}}
