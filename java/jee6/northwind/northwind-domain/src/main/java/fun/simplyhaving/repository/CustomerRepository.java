package fun.simplyhaving.infrastructure;

import java.util.List;

import fun.simplyhaving.model.Customer;

public interface CustomerRepository {

	public Customer findById(String id);

	public List<Customer> findAll();

	public Customer save(Customer customer);

	public void remove(Customer customer);

}
