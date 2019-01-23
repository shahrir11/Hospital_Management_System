/* File Name: MedicalClinic.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26- Nov-2018
*/
package assign4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



import java.util.ArrayList;
import java.util.Scanner;

public class MedicalClinic implements Serializable {
	// Declare the appointment arrayList
	private ArrayList<Appointment> appointments;
	// Declare the patients arrayList
	private ArrayList<Patient> patients;
	// Declare the doctors arrayList
	private ArrayList<Doctor> doctors;
	// Initialize the numberAppointments to zero
	private int numberAppointments = 0;
	// Initialize the numberPatients to zero
	private int numberPatients = 0;
	// Initialize the numberDoctors to zero
	private int numberDoctors = 0;
	// Initialize the MAXPATIENTS to 10
	private final int MAX_PATIENTS = 10;
	// Initialize the MAXAPPOINTMENTS to 10
	private final static int MAX_APPOINTMENTS = 10;
	// Initialize the MAXDOCTORS to 10
	private final static int MAX_DOCTORS = 5;
	Scanner input = new Scanner(System.in);

// default constructor
	MedicalClinic() {
		// Initialize the patients arrayList
		patients = new ArrayList<>();
		// Initialize the appointments arrayList
		appointments = new ArrayList<>();
		// Initialize the Doctor arrayList
		doctors = new ArrayList<>();
		// Enter the doctor's firstName, lastName and speciality on the array's
		// different index.
		doctors.add(0, new Doctor("Vikash", "Singh", "Heart Specialist"));
		doctors.add(1, new Doctor("Susan", "Miller", "Eye Specialist"));
		doctors.add(2, new Doctor("Thanh", "Do", "Liver Specialist"));
		doctors.add(3, new Doctor("Vikash", "Singh", "Heart Specialist"));
		doctors.add(4, new Doctor("Judy", "Chain", " Lung specialist"));
	}

//  Add patient method use to add Regular Patients
	public void addPatient(String firstName, String lastName, HealthCard healthCardNumber, OurDate date)

	{

		Patient pat = new Patient(firstName, lastName, healthCardNumber, date);
		patients.add(numberPatients, pat);
		numberPatients++;

	}

//  Add patient method use to add OutPatients
	public void addPatient(String lastName, String firstName, HealthCard healthCardNumber, OurDate date,
			boolean mobility, double distance)

	{
		Patient out = new OutPatient(lastName, firstName, healthCardNumber, date, false, distance);
		patients.add(numberPatients, out);
		numberPatients++;

	}

// Add patient method use to add Maternity Patient
	public void addPatient(String lastName, String firstName, HealthCard healthCardNumber, OurDate date,
			OurDate dueDate, boolean nutritionTesting) {

		Patient mat = new MaternityPatient(lastName, firstName, healthCardNumber, date, dueDate, false);
		patients.add(numberPatients, mat);
		numberPatients++;
	}

// add Appointment method
	public void addAppointment(Patient patient, Doctor doctor, OurDate date) {

		Appointment appointment = new Appointment(patient, doctor, date);
		appointments.add(numberAppointments, appointment);
		numberAppointments++;
	}

// Cancel Appointment method
	public void cancelAppointment(int index) {
		appointments.remove(index);
	}

// getter method to get numberofAppointment
	public int getNumberAppointment() {
		return numberAppointments;

	}

// getter method to get NumberofPatients
	public int getNumberPatients() {
		return numberPatients;
	}

// Using numberDoctors method access numberDoctors
	public int numberDoctors() {
		return numberDoctors;
	}

// gettter method to get MAX_APPOINTMENTS
	public int getMaxAppointments() {
		return MAX_APPOINTMENTS;
	}

// getter method to getMaxPatients
	public int getMaxPatients() {
		return MAX_PATIENTS;
	}

// getter method to getMaxDoctors
	public int getMaxDoctors() {
		return MAX_DOCTORS;

	}

// getter method to access doctors ArrayList
	public ArrayList<Doctor> getDoctors() {

		return doctors;
	}

	// getter method to access patient ArrayList
	public ArrayList<Patient> getPatients() {

		return patients;
	}

	// getter method to access Appointment ArrayList
	public ArrayList<Appointment> getAppointments() {

		return appointments;
	}

	public void filePatientOut() {

		try {
			FileOutputStream fileoutputStrem = new FileOutputStream("PatientData.ser");
         
			//Objects convert into bytecode and give it to fileoutputsteam and its write to file
			
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileoutputStrem);
			System.out.println(getPatients());
			
			objectOutputStream.writeObject(getPatients());
			
			objectOutputStream.close();
			
			fileoutputStrem.close();
		} 
		catch (FileNotFoundException file) {
			// TODO: handle exception

		} catch (IOException io) {

		}
	}

	public void filePatientIn() {

		try {
			
			FileInputStream fileInputStrem = new FileInputStream("PatientData.ser");

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStrem);
			
			ArrayList<Patient> listOfPatients = (ArrayList<Patient>) objectInputStream.readObject();
			this.patients = listOfPatients;
			System.out.println(this.patients);

			 objectInputStream.readObject();
			objectInputStream.close();
			fileInputStrem.close();

		} catch (FileNotFoundException file) {
			// TODO: handle exception

		} catch (IOException io) {

		} catch (ClassNotFoundException cnf) {

		}

	}

}
