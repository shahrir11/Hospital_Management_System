/* File Name: OurDate.java
* Course Name:18F_CST8284_312 Object Oriented Programming
* Lab Section: 312
* Student Name: SHAHRIR AHMED
* Date: 07 -Nov-2018
*/

package assign4;

import java.io.Serializable;



import java.util.Calendar;

public class OurDate implements Serializable {
	// field to store the day
	private int day;
	// field to store the month
	private int month;
	// field to store the year
	private int year;
	public static final Calendar CALENDAR = Calendar.getInstance();

	// Default constructor
	public OurDate() {

		this(CALENDAR.get(CALENDAR.DATE), CALENDAR.get(CALENDAR.MONTH), CALENDAR.get(CALENDAR.YEAR));

	}// End of Default constructor

	// Parameterized constructor : Passing the field day, month, year
	public OurDate(int day, int month, int year) {

		setDay(day);
		setMonth(month);
		setYear(year);

	}// End of Parameterized constructor

	// Using getter method to get the day field
	public int getDay() {
		return day;
	}// End of getDay method

	// Using setter method to set the day field
	private void setDay(int day) {

		this.day = day;
	}// End of setDay method

	// Using getter method to get the month field
	public int getMonth() {
		return month;
	}// End of getMonth method

	// Using setter method to set the month field
	private void setMonth(int month) {
		this.month = month;
	}// End of setMonth method

	// Using getter method to get the year field
	public int getYear() {
		return year;
	}// End of getYear method

	// Using setter method to set the year field
	private void setYear(int year) {
		this.year = year;

	}// End of setYear method

	// using toString method print the day, month, year
	@Override
	public String toString() {
		return ("day=" + day + ",month=" + month + ",year=" + year + " ");
	}// End of toString method

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof OurDate)) {
			return false;
		} else {

			OurDate date = (OurDate) obj;
			if (date.getDay() == day && date.getMonth() == month && date.year == year) {
				return true;
			}

		}
		return true;
	}

}
