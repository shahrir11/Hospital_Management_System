/* File Name: Doctor.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: SHAHRIR AHMED
* Date: 26 -Nov-2018
*/

package assign4;

import java.io.Serializable;




public class Doctor  implements Serializable{
	// field to store the firstName of the Doctor
	private String firstName;
	// field to store the secondName of the Doctor
	private String lastName;
	// field to store the speciality of the Doctor
	private String speciality;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Doctor)) {

			return false;
		} else {

			Doctor doc = (Doctor) obj;
			if (doc.getFirstName().equals(firstName) && doc.getLastName().equals(getLastName())
					&& doc.getSpeciality().equals(getSpeciality())) {

				return true;

			}
		}
		return true;
	}

	// Default constructor
	public Doctor() {

		this("unknown", "unknown", "unknown");
	}// End of the default constructor

	// Parameterized constructor : Passing the doctor's firstName, lastName, and
	// speciality
	public Doctor(String firstName, String lastName, String speciality) {

		setFirstName(firstName);

		setLastName(lastName);
		setSpeciality(speciality);

	}// End of the parameterize constructor

	// Using toString method print Doctor's firstName, lasrName and speciality
	@Override
	public String toString() {

		return (" " +firstName + "," + lastName + "," + speciality);
	}// End of toString method

	// Using getter method to get the firstName field
	public String getFirstName() {
		return firstName;
	}// End of getFirstName method

	// Using setter method to set the firstName field
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}// End of setFirstName method

	// Using getter method to get the lastName field
	public String getLastName() {

		return lastName;
	}// End of getlastName method

	// Using setter method to set the lastName field
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}// End of setLastName method

	// Using getter method to get the speciality field
	public String getSpeciality() {
		return speciality;
	}// End of getSpeciality method

	// Using setter method to set the speciality field
	private void setSpeciality(String speciality) {
		this.speciality = speciality;
	}// End of setSpeciality method

}
