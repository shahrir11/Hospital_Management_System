/* File Name:MedicalClinicUserInterface.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26 -Nov-2018
*/

package assign4;



import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MedicalClinicUserInterface {
	// Initialize the ADD_PATIENT to one
	private final static int ADD_PATIENT = 1;
	// Initialize the ADD_APPOINTMENT to two
	private final static int ADD_APPOINTMENT = 2;
	// Initialize the CANCEL_APPOINTMENT to 3
	private final int CANCEL_APPOINTMENT = 3;
	// Initialize the LIST_APPOINTMENT 4
	private final static int LIST_APPOINTMENT = 4;

	private final static int WRITE_PATIENTDATA = 5;
	private final static int LOAD_PATIENTDATA = 6;
	
	private final static int QUIT = 7;
	// Declare MedicalClinic
	private MedicalClinic clinic;
	// Initialise the Scanner
	Scanner in = new Scanner(System.in);

	public MedicalClinicUserInterface() {

		clinic = new MedicalClinic();

	}

//main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MedicalClinicUserInterface me = new MedicalClinicUserInterface();

		me.menu();
	}

	// menu method to choose the option from the user
	public void menu() {
		boolean isQuit = true;
		// Run the while loop upto user's not enter the quit option
		while (isQuit) {

			System.out.println(
					"Please make a choice:\n" + "1.Enter a new patient \n" + "2.Make an appointment for a patient \n"
							+ "3.Cancel an appointments for patient \n" + "4 List all appointments \n" + "5. Quit \n"
							+ "6. Write patient data to file \n" + "7. Load Patient Data \n");

			int choice = in.nextInt();
			// User entering choice
			switch (choice) {

			case ADD_PATIENT:
				addPatient();
				break;
			case ADD_APPOINTMENT:
				addAppointment();
				break;
			case CANCEL_APPOINTMENT:
				cancelAppointment();
				break;
			case LIST_APPOINTMENT:
				listAppointment();
				break;
			case WRITE_PATIENTDATA:
				writePatientsOut();
				break;
			case LOAD_PATIENTDATA:
				readPatientsIn();
				printPatients();
				break;
			case QUIT:
				isQuit = false;
				break;
			}
			if (isQuit == false) {
				break;
			}
		}

	}

// User input to add Patient
	public void addPatient() {

		System.out.print("Enter the First Name:");
		String firstName = in.next();
		// user enter the last name
		System.out.print("Enter the Last Name:");
		String lastName = in.next();
		// user enter the Healthcard number

		String healthCardNumber = null;

		boolean isCorrect = false;
		do {

			System.out.print("Enter the healthcard number:");
			// through health number Checking the patient is already in the system or not
			healthCardNumber = in.next();

			try {
				if (healthCardNumber.length() != 9 || (!(healthCardNumber.matches("[0-9]+")))) {
					isCorrect = true;
					throw new MedicalClinicException("Please enter the 9 digit Health Card Number");

				} else {
					isCorrect = false;
				}

			} catch (MedicalClinicException me) {

				System.out.println(me.getLocalizedMessage());

			}
		} while (isCorrect);

		String bithDate = null;

		boolean isOkay = true;

		while (isOkay) {
			isOkay = false;

			System.out.print("Enter bith date DDMMYYYY ");

			bithDate = in.next();

			int birthDateLegnth = bithDate.length();
			// Checking the user entered 8 number in the birthdate input.
			// checking the user entered valid Day, Month, Year. If its invalid, it will ask
			// again enter the valid day, month and year
			if (birthDateLegnth != 8) {
				System.out.print("Enter the valid bithdate");
				isOkay = true;
			} else {
				//
				/*
				 * if (Integer.parseInt(bithDate.substring(0, 2)) < 0 ||
				 * Integer.parseInt(bithDate.substring(0, 2)) >= 31) {
				 * System.out.print("Enter the valid day format"); isOkay = true; }
				 * 
				 * if (Integer.parseInt(bithDate.substring(2, 4)) < 0 ||
				 * Integer.parseInt(bithDate.substring(2, 4)) > 12) {
				 * System.out.print("Enter the valid month format"); isOkay = true; }
				 * 
				 * if (Integer.parseInt(bithDate.substring(4, 8)) <= 1950) {
				 * System.out.print("Enter the valid year format"); isOkay = true; }
				 * 
				 * }
				 */

			}
			// using substring divide string first and second digit to consider has a day
			// and convert into int and save in day field
			int day = Integer.parseInt(bithDate.substring(0, 2));
			// using substring divide string third to fourth to consider has a month and
			// convert into int and save in month field
			int month = Integer.parseInt(bithDate.substring(2, 4));
			// using substring divide string fourth to seven to consider has a year and
			// convert into int and save in year field
			int year = Integer.parseInt(bithDate.substring(4, 8));

			System.out.println("Enter the type of patient:");
			System.out.println("1. Maternity Patient \n " + "2.OutPatient \n" + "3.Regular Patient");
			int patientType = in.nextInt();
			try {
				if (patientType == 1) {

					System.out.println("Enter the Due Date:");
					String dudate = in.next();
					int dueday = Integer.parseInt(dudate.substring(0, 2));
					int duemonth = Integer.parseInt(dudate.substring(2, 4));
					int dueyear = Integer.parseInt(dudate.substring(4, 8));

					System.out.println("is nutrition testing done");
					boolean nutritionTesting = in.nextBoolean();

					clinic.addPatient(lastName, firstName, new HealthCard(healthCardNumber),
							new OurDate(day, month, year), new OurDate(dueday, duemonth, dueyear), nutritionTesting);

				} else if (patientType == 2) {
					System.out.println("Enter the distanceFromClinic:");
					double distance = in.nextDouble();

					System.out.println("Enter the mobility :");
					boolean mobility = in.nextBoolean();

					clinic.addPatient(lastName, firstName, new HealthCard(healthCardNumber),
							new OurDate(day, month, year), mobility, distance);
				} else if (patientType == 3) {

					clinic.addPatient(firstName, lastName, new HealthCard(healthCardNumber),
							new OurDate(day, month, year));

				}
			} catch (MedicalClinicException me) {

				isOkay = true;
				System.out.println(me.getLocalizedMessage());
			}

		}

	}

// Add Appointment. 
	public void addAppointment() {

		Patient selectedPatient = null;

		System.out.print("Enter the Health Card number:");
		String healthCardNumber1 = in.next();
		HealthCard h1 = new HealthCard(healthCardNumber1);

		// Using HealthCard number select the patient. Print the patients detail using
		// toString method and store the patients detail in selectPatients field
		for (int i = 0; i < clinic.getNumberPatients(); i++) {

			if (clinic.getPatients().get(i).getHealthCard().toString().equals(h1.toString())) {
				System.out.println(clinic.getPatients().get(i).toString());
				selectedPatient = clinic.getPatients().get(i);
				System.out.println();
				break;
			}
		}

		if (selectedPatient == null) {
			System.out.println("Please enter the Correct Health Card number to book the appointment");
			return;
		}

		for (int j = 0; j < clinic.getMaxDoctors(); j++) {
			System.out.println((j + 1) + " " + clinic.getDoctors().get(j).getFirstName() + " "
					+ clinic.getDoctors().get(j).getLastName());
		}
		// Enter the Doctor selection
		System.out.print("Enter number for doctor selection :");
		int selectedDoctorNum = in.nextInt();

		Doctor selectedDoctor = clinic.getDoctors().get(selectedDoctorNum - 1);
// chcecking the user enter the valid date, month and year for appointment date. User can not allow to enter the year less than 2018.
		boolean isOkay = true;
		String desiredDate = null;
		while (isOkay) {
			isOkay = false;
			System.out.print("Enter the desired date DDMMYYYY: ");

			desiredDate = in.next();

			int birthDateLegnth = desiredDate.length();

			if (birthDateLegnth != 8) {
				System.out.print("Enter the valid date");
				isOkay = true;
			}
			// using substring divide string first and second digit to consider has a day
			// and convert into int and save in day field
			int day = Integer.parseInt(desiredDate.substring(0, 2));
			// using substring divide string third to fourth to consider has a month and
			// convert into int and save in month field
			int month = Integer.parseInt(desiredDate.substring(2, 4));
			// using substring divide string fourth to seven to consider has a year and
			// convert into int and save in year field
			int year = Integer.parseInt(desiredDate.substring(4, 8));
			// Pass the day, month ,year to OurDate constructor
			OurDate appointmentDate;

			try {
				appointmentDate = new OurDate(day, month, year);

// Patients can book different doctor on different date but doctor has only one appointment per day.

				boolean isAppoinmentAvailable = true;
				for (int i = 0; i < clinic.getNumberAppointment(); i++) {
					if (clinic.getAppointments().get(i).date.toString().equals(appointmentDate.toString())
							&& clinic.getAppointments().get(i).doctor.toString().equals(selectedDoctor.toString())) {
						isAppoinmentAvailable = false;
						System.out.println("Appointment not available");
						return;
					}
				}
				clinic.addAppointment(selectedPatient, selectedDoctor, appointmentDate);

			} catch (MedicalClinicException me) {
				isOkay = true;
				System.out.println(me.getLocalizedMessage());

			}

		}

	}

// Method use to Cancel the appointment
	public void cancelAppointment() {

		Patient selectedPatient = null;

		System.out.print("Enter the Health Card number:");
		String healthCardNumber1 = in.next();
		HealthCard h1 = new HealthCard(healthCardNumber1);
		// Using HealthCard number select the patient. Print the patients detail using
		// toString method and store the patients detail in selectPatients field
		for (int i = 0; i < clinic.getNumberPatients(); i++) {

			if (clinic.getPatients().get(i).getHealthCard().toString().equals(h1.toString())) {
				System.out.println(clinic.getPatients().get(i).toString());
				selectedPatient = clinic.getPatients().get(i);
				System.out.println();
				break;
			}
		}

		if (selectedPatient == null) {
			System.out.println("Please enter the Correct Health Card number to Cancel the appointment");
			return;
		}

		for (int j = 0; j < clinic.getMaxDoctors(); j++) {
			System.out.println((j + 1) + " " + clinic.getDoctors().get(j).getFirstName() + " "
					+ clinic.getDoctors().get(j).getLastName());
		}
		// Enter the Doctor selection
		System.out.print("Enter number for doctor selection :");
		int selectedDoctorNum = in.nextInt();

		Doctor selectedDoctor = clinic.getDoctors().get(selectedDoctorNum - 1);
// chcecking the user enter the valid date, month and year for cancel anappointment date. User can not allow to enter the year less than 2018.
		boolean isOkay = true;
		String desiredDate = null;
		while (isOkay) {
			isOkay = false;
			System.out.print("Enter the desired date DDMMYYYY: ");

			desiredDate = in.next();

			int birthDateLegnth = desiredDate.length();

			if (birthDateLegnth != 8) {
				System.out.print("Enter the valid date");
				isOkay = true;
			}

		}
		// using substring divide string first and second digit to consider has a day
		// and convert into int and save in day field
		int day = Integer.parseInt(desiredDate.substring(0, 2));
		// using substring divide string third to fourth to consider has a month and
		// convert into int and save in month field
		int month = Integer.parseInt(desiredDate.substring(2, 4));
		// using substring divide string fourth to seven to consider has a year and
		// convert into int and save in year field
		int year = Integer.parseInt(desiredDate.substring(4, 8));
		// Pass the day, month ,year to OurDate constructor
		OurDate appointmentDate = new OurDate(day, month, year);

// Patients can book different doctor on different date but doctor has only one appointment per day.

		// boolean isAppoinmentAvailable = true;
		for (int i = 0; i < clinic.getNumberAppointment(); i++) {
			if (clinic.getAppointments().get(i).date.toString().equals(appointmentDate.toString())
					&& clinic.getAppointments().get(i).doctor.toString().equals(selectedDoctor.toString())) {
				clinic.cancelAppointment(i);
				System.out.println("Appointment Cancelled");
				return;
			}

		}
	}

// LIst all the Appointment
	public void listAppointment() {
		for (int i = 0; i < clinic.getAppointments().size(); i++) {
			System.out.println(clinic.getAppointments().get(i));
		}

	}

// List the number of Doctors
	public void printDoctors() {
		System.out.println(clinic.getDoctors());
	}

// List the Print of Patients
	public void printPatients() {

		System.out.println(clinic.getPatients());
	}

	
	
	
	public void writePatientsOut() {

		clinic.filePatientOut();
	}

	public void readPatientsIn() {

		clinic.filePatientIn();

	}

}
