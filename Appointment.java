/* File Name: Appointment.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: SHAHRIR AHMED
* Date: 7 -Nov-2018
*/
package assign4;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;



public class Appointment implements Serializable {
	// Declare the Doctor type field doctor
	Doctor doctor;
	// Declare the Patient type field patient
	Patient patient;
	// Declare the OurDate type field date
	OurDate date;

	// Default Appointment Constructor
	public Appointment() {

	}// End of Default Appointment Constructor

	public Appointment(Patient patient, Doctor doctor, OurDate appoinemtnetDate) {
		setPatient(patient);
		setDoctor(doctor);
		setDate(appoinemtnetDate);
	}

	// Using getter method to get the doctor field
	public Doctor getDoctor() {
		return doctor;
	}

	// Using setter method to set the doctor field
	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	// Using getter method to get the patient field
	public Patient getPatient() {
		return patient;
	}

	// Using setter method to set the patient field
	private void setPatient(Patient patient) {
		this.patient = patient;
	}

	// Using getter method to get the date field
	public OurDate getDate() {
		return date;
	}

	// Using setter method to set the date field
	private void setDate(OurDate date) {

//Checking the user date with current date and Appointment date should be in future
		if (date.getMonth() > 12 || date.getMonth() == 0) {
			throw new MedicalClinicException("Enter the valid months ");

		}
		Calendar cal = Calendar.getInstance();
		cal.set(date.getYear(), date.getMonth() - 1, date.getDay());
		// System.out.println(cal.getActualMaximum(Calendar.DAY_OF_YEAR));

		int a[] = { 31, 30, 31, 30, 31, 30, 31, 31, 30, 30, 30, 31 };

		if (date.getMonth() == 2) {

			if ((cal.getActualMaximum(Calendar.DAY_OF_YEAR) == 366)) {

				if ((date.getDay() >= 30)) {

					throw new MedicalClinicException("Enter the valid Days in Febuaray month (This is the leap year) ");
				}

			} else if ((cal.getActualMaximum(Calendar.DAY_OF_YEAR) == 365)) {

				if ((date.getDay() >= 29)) {
					throw new MedicalClinicException("Enter the valid Days in Febuaray month ");
				}

			}
		} else {
			if ((date.getDay() > a[date.getMonth() - 1])) {

				throw new MedicalClinicException("Enter the valid Days ");

			}

		}
		// Calendar cal = Calendar.getInstance();

		cal.set(date.getYear(), date.getMonth() - 1, date.getDay());
		// cal.setLenient(false);

		Date appointmentDate = cal.getTime();

		Date date1 = new Date();

		// System.out.println(date + "     " + date1);
		// System.out.println(date1.compareTo(date));
		if ((date1.compareTo(appointmentDate) == 1)) {

			throw new MedicalClinicException("Appointment date cannot be in Past ");

		} else if ((date1.compareTo(appointmentDate) == 0)) {

			throw new MedicalClinicException("Appointment date cannot be today ");
		}

		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {

			return false;
		}

		if (!(obj instanceof Appointment)) {

			return false;

		} else {

			Appointment app = (Appointment) obj;

			if (app.getDate().equals(getDate()) && app.getDoctor().equals(getDoctor())
					&& app.getPatient().equals(getPatient())) {

				return true;
			}
		}
		return false;
	}

	// returns the doctor and patient details.
	@Override
	public String toString() {
		return ("Appointment date:" + date.getDay() + "/" + date.getMonth() + "/" + date.getYear() + doctor.toString()
				+ patient.toString());

	}

}
