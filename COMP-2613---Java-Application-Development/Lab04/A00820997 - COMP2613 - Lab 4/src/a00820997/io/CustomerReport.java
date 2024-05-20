/**
 * Project: COMP2613 - 04 - Lab 04
 * File: CustomerReport.java
 * Date: May 13, 2019
 * Time: 5:59:51 p.m.
 * 
 * @author Matthew Simpson / A00820997
 */

package a00820997.io;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import a00820997.data.Customer;
import a00820997.data.util.CompareByJoinDate;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */
public class CustomerReport {

	private static final String LINE = "------------------------------------------------------------------------------------------------------------------------------------------";
	private static final String FORMATTER = "%-4s %-11s %-11s %-25s %-12s %-12s %-15s %-25s %-10s%n";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

	/**
	 * Private constructor to prevent instantiation
	 */

	private CustomerReport() {
	}

	/**
	 * Method to generate a report of all customers, sorted by join date, to the console.
	 * 
	 * @param customerData
	 *            - a Map<Long, Customer> - the data to report.
	 */

	public static void reportCustomerDB(Map<Long, Customer> customerData) {
		ArrayList<Customer> sortedList = new ArrayList<Customer>();
		if (customerData != null) {
			System.out.println("Customer Report");
			System.out.println(LINE);
			System.out.format(FORMATTER, "ID#", "First Name", "Last Name", "Street", "City", "Postal Code", "Phone #", "Email", "Join Date");
			System.out.println(LINE);

			sortedList = CompareByJoinDate.sortData(customerData);

			for (Customer index : sortedList) {
				System.out.format(FORMATTER, index.getId(), index.getFirstName(), index.getLastName(), index.getStreetName(), index.getCity(),
						index.getPostalCode(), index.getPhoneNumber(), index.getEmailAddress(), index.getJoinDate().format(DATE_FORMATTER));
			}

		}
	}

	/**
	 * @deprecated please now use reportCustomerDB()
	 * @see reportCustomerDB();
	 *      Method to generate a report of customers in an array to the console.
	 * 
	 * @param customerData
	 *            - a Customer[] array
	 */
	@Deprecated
	public static void reportCustomers(Customer[] customerData) {
		if (customerData != null) {
			// Set up the report header.
			System.out.println("Customer Report");
			System.out.println(LINE);
			System.out.format(FORMATTER, "ID#", "First Name", "Last Name", "Street", "City", "Postal Code", "Phone #", "Email", "Join Date");
			System.out.println(LINE);

			// loop over the array and output the customer data.
			for (int i = 0; i < customerData.length; i++) {

				System.out.format(FORMATTER, customerData[i].getId(), customerData[i].getFirstName(), customerData[i].getLastName(),
						customerData[i].getStreetName(), customerData[i].getCity(), customerData[i].getPostalCode(), customerData[i].getPhoneNumber(),
						customerData[i].getEmailAddress(), customerData[i].getJoinDate().format(DATE_FORMATTER));

			}

		}
	}

}
