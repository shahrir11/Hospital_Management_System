/* File Name: HealthCard.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26 -Nov-2018
*/
package assign4;

import java.io.Serializable;


public class HealthCard implements Serializable {

	private String healthCardNumber;

	public HealthCard() {

		this("999999999");
	}

	public HealthCard(String healthCardNumber) {

		setHealthCardNumber(healthCardNumber);

	}

	public String getHealthCardNumber() {
		return healthCardNumber;
	}

	public void setHealthCardNumber(String healthCardNumber) {
		
		/*
		 * boolean isCorrect = false;
		 * 
		 * do {
		 * 
		 * 
		 * 
		 * try { if (healthCardNumber.length() != 9) { isCorrect = true; throw new
		 * MedicalClinicException("Please enter the 9 digit Health Card Number");
		 * 
		 * }
		 * 
		 * } catch (MedicalClinicException me) {
		 * 
		 * System.out.println(me);
		 * 
		 * System.out.println("Please Enter the HealthCardNmber:");
		 * 
		 * 
		 * } } while (isCorrect);
		 */

		this.healthCardNumber = healthCardNumber;
	}

	@Override
	public String toString() {
		return "HealthCard [healthCardNumber=" + healthCardNumber + "]";
	}

	// do private HealthCardNUmber healthCardNumber in patient calss to create
	// composite relation
}
