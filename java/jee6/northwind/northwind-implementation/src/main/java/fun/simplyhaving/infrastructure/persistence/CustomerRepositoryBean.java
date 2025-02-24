package fun.simplyhaving.infrastructure.persistence;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.infrastructure.CustomerRepository;

@Stateless
@Local(value=CustomerRepository.class)
public class CustomerRepositoryBean implements CustomerRepository {
	
	@PersistenceUnit
	private EntityManager em;

	@Override
	public Customer findById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Customer Id is null");

        TypedQuery<Customer> typedQuery = em.createNamedQuery(CustomerEntity.FIND_BY_ID, Customer.class);
        typedQuery.setParameter("id", id);

        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	@Override
	public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery = em.createNamedQuery(CustomerEntity.FIND_ALL, Customer.class);
        return typedQuery.getResultList();
	}

	@Override
	public Customer save(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer object is null");

        em.persist(customer);

        return customer;
	}

	@Override
	public void remove(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer object is null");

		em.remove(em.merge(customer));
	}

}
