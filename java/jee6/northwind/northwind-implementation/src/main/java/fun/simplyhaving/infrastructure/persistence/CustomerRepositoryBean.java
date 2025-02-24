package fun.simplyhaving.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.infrastructure.CustomerRepository;

@Stateless
@Local(value=CustomerRepository.class)
public class CustomerRepositoryBean implements CustomerRepository {
	
	//@PersistenceUnit(unitName = "NorthwindPU")
	private EntityManager em;

	public Customer findById(Integer id) {
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

	public List<Customer> findAll() {
        //TypedQuery<Customer> typedQuery = em.createNamedQuery(CustomerEntity.FIND_ALL, Customer.class);
        //return typedQuery.getResultList();

        List<Customer> list = new ArrayList<Customer>();
        CustomerEntity e = new CustomerEntity();
        e.setId(1);
        e.setCompanyName("TEST");
        list.add(e);

        return list;
	}

	public Customer save(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer object is null");

        em.persist(customer);

        return customer;
	}

	public void remove(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer object is null");

		em.remove(em.merge(customer));
	}

}
