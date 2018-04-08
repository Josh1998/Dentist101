
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class Console {
		private static final String ListOfAppointments = "D://AppointmentList.txt";
		private static final Scanner userInput = new Scanner(System.in);
		private static int caesarCipher = 3; 
		
		private static final HashMap<Integer, Room> appointments = new HashMap<Integer, Room>();

		public static void main(String[] args) throws Exception {
			loadData();

			String choice = "";

			System.out.println("--  Dentist Booking System --");

			
			System.out.println();

			do {
				System.out.println("-- MAIN MENU --");
				System.out.println("1 - Book any appointment");
				System.out.println("2 - Search & Reserve a specified appointment");
				System.out.println("3 - Cancel Appointment");
				System.out.println("4 - Display Appointments");
				System.out.println("Q - Quit");
				System.out.print("Pick : ");

				choice = userInput.next().toUpperCase();

				switch (choice) {
					case "1" : {
						reserveRoom();
						break;
					}
					case "2" : {
						searchRoom();
						break;
					}
					case "3" : {
						cancelRoom();
						break;
					}
					case "4" : {
						viewAll();
						break;
					}
				}
			} while (!choice.equals("Q"));

			userInput.close();

			saveData();

			System.out.println("Bye Bye :)");

			
		}
		
		private static void viewAll() {
			for (Room appointment : appointments.values())
				System.out.println(appointment.toString());
		}
		
		private static void loadData() throws Exception {
			Scanner userInput;
			
	
			userInput = new Scanner(new FileReader(ListOfAppointments));

			String in = "";
			String dec = "";
			char process;
			
			while (userInput.hasNext()) {
				
				in = userInput.nextLine();
				dec = "";
				for (int i = 0; i < in.length(); i++) {
					process = in.charAt(i);
					process = (char) (process + -caesarCipher);
					
					dec = dec + process;
				}
				
				String[] strs = dec.split(" ");

	

	
				appointments.put(Integer.parseInt(strs[0]), new Room(Integer.parseInt(strs[0]), strs[1], Double.parseDouble(strs[2]), strs[3], (strs.length == 7 ? strs[4] : ""), (strs.length == 7 ? strs[5] : ""), (strs.length == 7 ? Integer.parseInt(strs[6]) : -1)));
			}

	
			userInput.close();
		}
private static void reserveRoom() {
	System.out.println("-- AVAILABLE ROOMS --");

			boolean areRooms = false;

			for (Room appointment : appointments.values()) {
				if (!appointment.isReserve()) {
					System.out.println(appointment.toString());
					areRooms = true;
				}
			}

			aquireRoom(areRooms);
		}

private static void searchRoom() {
	System.out.println("-- SEARCH ROOMS --");

	boolean areRooms = false;

	System.out.print("Type a preferred date in April you would like [Format: 01/04/2018] : ");
	String type = userInput.next();

	System.out.print("Latest time you can make the appointement : ");
	double price = userInput.nextDouble();

	System.out.print("Please enter firts choice dentist [Surname] : ");
	String balcony = userInput.next();
	
		for (int match = 3; match >= 1; match--) {
		areRooms = false;

		System.out.println("Showing Appointments Matching " + match + " Requirements !");

		for (Room appointment : appointments.values()) {
			if (!appointment.isReserve()) {
				if (appointment.checkMatch(type, price, balcony) == match) {
					System.out.println(appointment.toString());
					areRooms = true;
				}
			}
		}

		if (areRooms) {
			break;
		}
		else {
			System.out.println("No Rooms Matching : " + match + " Requirements !");
		}
	}

	aquireRoom(areRooms);
}

private static void aquireRoom(boolean areRooms) {
	if (areRooms) {
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
		
		System.out.print("passcode (four digits) : ");
		int passcode = userInput.nextInt();

		try {
			
			appointments.get(no).reserveRoom(ailment, ID, passcode);

			System.out.println("Victory !");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	else {
		System.out.println("No Available Rooms !");
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
	
	System.out.print("passcode : ");
	int passcode = userInput.nextInt();

	System.out.println("-- " + ID + " RESERVE ROOMS --");

	boolean areRooms = false;

	for (Room appointment : appointments.values()) {
		if (appointment.isReserve()) {
			if ((ailment.equals(appointment.getAilment()))&&(ID.equals(appointment.getID())&&(passcode==appointment.getPasscode()))) {
				System.out.println(appointment.toString());
				areRooms = true;
			}
		}
	}

	if (areRooms) {
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
		System.out.println("No Reserve Rooms or check your passcode!");
	}
}

private static void saveData() throws Exception {
		
	String in = "";
	char process;
	String enc = "";
	
	try (PrintWriter pw = new PrintWriter(new FileWriter(ListOfAppointments))) {
		for (Room appointment : appointments.values()) {
			
			in = appointment.toSaveString();
			enc = "";
			
			for (int i = 0; i < in.length(); i++) {
				process = in.charAt(i);
				process = (char) (process + caesarCipher);
				
				enc = enc + process;
			}
			pw.println(enc); 
				
		}
		pw.close();
	}
	
  }
}
