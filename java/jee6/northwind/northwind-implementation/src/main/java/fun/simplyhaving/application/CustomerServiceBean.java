package fun.simplyhaving.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.infrastructure.CustomerRepository;
import fun.simplyhaving.service.CustomerService;

@Stateless
@Local(value = CustomerService.class)
public class CustomerServiceBean implements CustomerService {

	@EJB
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(String companyName, String contactTitle, String contactName, String address,
			String city, String region, String postalCode, String country, String phone, String fax) {
		
		Customer customer = new Customer();
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

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerRepository.findById(id);
	}

	@Override
	public void removeCustomer(Integer id) {
		customerRepository.remove(getCustomerById(id));
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
