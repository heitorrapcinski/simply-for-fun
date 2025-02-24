package fun.simplyhaving.service;

import java.util.List;

import fun.simplyhaving.model.Customer;

public interface CustomerService {

	public Customer createCustomer(String companyName, String contactTitle, String contactName, String address,
			String city, String region, String postalCode, String country, String phone, String fax);

	public Customer getCustomerById(Integer id);

	public List<Customer> getAllCustomers();

	public Customer updateCustomer(Customer customer);

	public void removeCustomer(Integer id);

}
