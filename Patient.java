/* File Name: Patient.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26 -Nov-2018
*/

package assign4;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;


//import assign2.Appointment;

//Default constructor
public class Patient  implements Serializable{
	// field to store the firstName of the Patient
	private String firstName;
	// field to store the lastName of the Patient
	private String lastName;
	// field to store the healthCardNumber of the Patient
	private HealthCard healthCard;
	// field to store the birthdate of the Patient
	private OurDate birthDate;

//Default Patient constructor
	public Patient() {

	}// End Default Constructor

	// Parameterize Patient Constructor to set the Patient's firstName, lastName ,
	// healthCardNumber , birthDate
	public Patient(String firstName, String lastName, HealthCard healthCardNumber, OurDate birthDate) {
		setFirstName(firstName);
		setlastName(lastName);
		setBirthDate(birthDate);
		setHealthCard(healthCardNumber);

	}// End of the Parameterize Patient Constructor

	// Using toString method print the patient details.
	@Override
	public String toString() {
		System.out.println();
		return (" " + firstName + "," + lastName + "," + "healthCardNumber :" + healthCard + "  dob:"
				+ birthDate.getDay() + "/" + birthDate.getMonth() + "/" + birthDate.getYear());
		
	}// End of the toString method

	// Start of getFirstName method
	public String getFirstName() {
		return firstName;

	}// End of getFirstName method

	// Start of setFirstName method
	private void setFirstName(String firstName) {
		this.firstName = firstName;

	}// End of setFirstName method

	// Start of getlastName method
	public String getlastName() {
		return lastName;

	}// End of getlastName method

	// Start of setlastName method
	private void setlastName(String lastName) {
		this.lastName = lastName;

	}// End of setlastName method

	// Start of getBirthDate method
	public OurDate getBirthDate() {
		return birthDate;
	}// End of getBirthDate method

	// Checking the user date with current date and set Patient birhtdate in past
	private void setBirthDate(OurDate birthDate) {

		if (birthDate.getYear() <= 1900) {

			throw new MedicalClinicException("Please do not enter the Year before the 1990");

		}

		if (birthDate.getMonth() > 12 || birthDate.getMonth() == 0) {
			throw new MedicalClinicException("Enter the valid months ");

		}
		Calendar cal = Calendar.getInstance();
		cal.set(birthDate.getYear(), birthDate.getMonth() - 1, birthDate.getDay());
		// System.out.println(cal.getActualMaximum(Calendar.DAY_OF_YEAR));

		int a[] = { 31, 30, 31, 30, 31, 30, 31, 31, 30, 30, 30, 31 };

		if (birthDate.getMonth() == 2) {

			if ((cal.getActualMaximum(Calendar.DAY_OF_YEAR) == 366)) {

				if ((birthDate.getDay() >= 30)) {

					throw new MedicalClinicException("Enter the valid Days in Febuaray month (This is the leap year) ");
				}

			} else if ((cal.getActualMaximum(Calendar.DAY_OF_YEAR) == 365)) {

				if ((birthDate.getDay() >= 29)) {
					throw new MedicalClinicException("Enter the valid Days in Febuaray month ");
				}

			}
		} else {
			if ((birthDate.getDay() > a[birthDate.getMonth() - 1])) {

				throw new MedicalClinicException("Enter the valid Days ");

			}

		}
		// Calendar cal = Calendar.getInstance();

		cal.set(birthDate.getYear(), birthDate.getMonth() - 1, birthDate.getDay());
		// cal.setLenient(false);

		Date date = cal.getTime();

		Date date1 = new Date();

		// System.out.println(date + " " + date1);
		// System.out.println(date1.compareTo(date));
		if ((date1.compareTo(date) == -1)) {

			throw new MedicalClinicException("BirthDate cannot be in future ");

		} else if ((date1.compareTo(date) == 0)) {

			throw new MedicalClinicException("BirthDate cannot be today ");
		}

		this.birthDate = birthDate;

	}// End of setBirthDate method

	public HealthCard getHealthCard() {
		return healthCard;
	}

	public void setHealthCard(HealthCard healthCard) {
		this.healthCard = healthCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((healthCard == null) ? 0 : healthCard.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Patient)) {
			return false;
		} else {

			Patient pat = (Patient) obj;

			if (pat.getFirstName().equals(getFirstName()) && pat.getlastName().equals(getlastName())
					&& pat.getBirthDate().equals(getBirthDate())) {

				return true;
			}

			return false;
		}

	}

}
