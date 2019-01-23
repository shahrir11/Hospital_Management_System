/* File Name: OutPatient.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26 -Nov-2018
*/

package assign4;


import java.io.Serializable;

public class OutPatient extends Patient implements Serializable {
	// Declare the distanceFromClinic
	private double distanceFromClinic;
	// Declare the mobility
	private boolean mobility;

//Default Constructor
	public OutPatient() {
		this("unknown", "unknown", new HealthCard("1"), new OurDate(1, 1, 1800), false, 1);
	}

	public OutPatient(String lastName, String firstName, HealthCard healthCardNumber, OurDate birthDate,
			boolean mobility, double distancceFromClinic) {
		super(firstName, lastName, healthCardNumber, birthDate);

		setDistanceFromClinic(distancceFromClinic);
		setMobility(mobility);
	}

// getter method to get distanceFromClinic
	public double getDistanceFromClinic() {
		return distanceFromClinic;
	}

	// setter method to set distanceFromClinic
	private void setDistanceFromClinic(double distanceFromClinic) {
		this.distanceFromClinic = distanceFromClinic;
	}

	// getter method to get mobility
	public boolean isMobility() {
		return mobility;
	}

	// setter method to set mobility
	private void setMobility(boolean mobility) {
		this.mobility = mobility;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distanceFromClinic);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (mobility ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OutPatient)) {

			return false;
		} else {

			OutPatient outPatient = (OutPatient) obj;
			if (outPatient.getDistanceFromClinic() == getDistanceFromClinic()
					&& outPatient.isMobility() == isMobility()) {
				return true;
			}
			return false;
		}

	}

	@Override
	public String toString() {
		return super.toString() + (" distanceFromClinic: " + distanceFromClinic + " mobility :" + mobility);
	}

}
