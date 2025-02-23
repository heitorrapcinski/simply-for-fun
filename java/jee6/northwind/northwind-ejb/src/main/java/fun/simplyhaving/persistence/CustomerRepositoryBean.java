package fun.simplyhaving.persistence;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

import fun.simplyhaving.domain.Customer;
import fun.simplyhaving.repository.CustomerRepository;

@Stateless
@Local(value=CustomerRepository.class)
public class CustomerRepositoryBean implements CustomerRepository {
	
	@PersistenceUnit
	private EntityManager em;

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findById'");
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'findAll'");
	}

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'save'");
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
	}

}
