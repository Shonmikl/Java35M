package org.example.kotiki._2023_02_24.unit.dummy;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	public List<Customer> customers = new ArrayList<>();

	public void addCustomer(Customer customer) {
		if (customer == null) {
			throw new NullPointerException();
		}
		customers.add(customer);
	}

	public int getNumberOfCustomers() {
		return customers.size();
	}
}