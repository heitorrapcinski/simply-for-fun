package fun.simplyhaving.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.repository.CustomerRepository;
import fun.simplyhaving.service.CustomerService;

@Stateless
@Local(value = CustomerService.class)
public class CustomerServiceBean implements CustomerService {

	@EJB
	private CustomerRepository customerRepository;

	public Customer createCustomer(String id, String companyName, String contactTitle, String contactName, String address,
			String city, String region, String postalCode, String country, String phone, String fax) {
		
		Customer customer = new Customer();
		customer.setId(id);
		customer.setCompanyName(companyName);
		customer.setContactTitle(contactTitle);
		customer.setContactName(contactName);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setRegion(region);
		customer.setPostalCode(postalCode);
		customer.setCountry(country);
		customer.setPhone(phone);
		customer.setFax(fax);

		return customerRepository.save(customer);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(String id) {
		return customerRepository.findById(id);
	}

	public void removeCustomer(String id) {
		customerRepository.remove(getCustomerById(id));
	}

	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
