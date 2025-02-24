package fun.simplyhaving.repository;

import java.util.List;

import fun.simplyhaving.domain.Customer;

public interface CustomerRepository {

	public Customer findById(Long id);

	public List<Customer> findAll();

	public Customer save(Customer customer);

	public void remove(Customer customer);

}
