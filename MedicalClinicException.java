/* File Name: MedicalClinicException.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: Shahrir Ahmed
* Date: 26 -Nov-2018
*/

package assign4;

import java.io.Serializable;


public class MedicalClinicException extends RuntimeException implements Serializable {

	private String measssage;

	public MedicalClinicException(String message) {

		super(message);

	}

	
}
