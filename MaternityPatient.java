
/* File Name: MaternityPatient.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26 -Nov-2018
*/

package assign4;


import java.io.Serializable;

public class MaternityPatient extends Patient implements Serializable {
	// Declare the OurDate type field dueDate
	private OurDate dueDate;
	// Declare the nutritionTesting variable
	private boolean nutritionTesting;

//Default Constructor
	public MaternityPatient() {
		this("unknown", "unknown", new HealthCard("1"), new OurDate(1, 1, 1800), new OurDate(1, 1, 3000), false);
	}

	public MaternityPatient(String firstName, String lastName, HealthCard healthCardNumber, OurDate birthDate,
			OurDate dueDate, boolean nutritionTesting) {
		super(firstName, lastName, healthCardNumber, birthDate);

		setDueDate(dueDate);
		setNutritionTesting(nutritionTesting);

	}

	// getter method to get DueDate
	public OurDate getDueDate() {
		return dueDate;
	}

	// setter method to set DueDate
	private void setDueDate(OurDate dueDate) {
		this.dueDate = dueDate;
	}

	// getter method to get isNutritionTesting
	public boolean isNutritionTesting() {
		return nutritionTesting;
	}

	// setter method to set isNutritionTesting
	private void setNutritionTesting(boolean nutritionTesting) {
		this.nutritionTesting = nutritionTesting;
	}

	@Override
	public String toString() {
		return super.toString() + (" dueDate " + dueDate + " nutritionTesting :" + nutritionTesting);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + (nutritionTesting ? 1231 : 1237);
		return result;
	}

// Checking the obj instanceof MaternityPatient
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MaternityPatient)) {

			return false;
		} else {

			MaternityPatient mpp = (MaternityPatient) obj;
			if (mpp.isNutritionTesting() == this.isNutritionTesting() && mpp.getDueDate().equals(getDueDate())) {
				return true;
			}
			return false;
		}
	}

}
