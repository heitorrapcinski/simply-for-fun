package fun.simplyhaving.infrastructure.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fun.simplyhaving.repository.CustomerRepository;
import fun.simplyhaving.infrastructure.entity.CustomerEntity;
import fun.simplyhaving.model.Customer;

@Stateless
@Local(value=CustomerRepository.class)
public class CustomerRepositoryBean implements CustomerRepository {
	
	@PersistenceContext
	private EntityManager em;

	public Customer findById(String id) {
        if (id == null)
            throw new IllegalArgumentException("Customer Id is null");

        TypedQuery<CustomerEntity> typedQuery = em.createNamedQuery(CustomerEntity.FIND_BY_ID, CustomerEntity.class);
        typedQuery.setParameter("id", id);

        try {
            return typedQuery.getSingleResult().toCustomer();
        } catch (NoResultException e) {
            return null;
        }
	}

	public List<Customer> findAll() {
        System.out.println("===> CustomerRepository findAll");
        TypedQuery<CustomerEntity> typedQuery = em.createNamedQuery(CustomerEntity.FIND_ALL, CustomerEntity.class);
        List<CustomerEntity> entityList = typedQuery.getResultList();

        ArrayList<Customer> list = new ArrayList<Customer>();
        for (CustomerEntity customerEntity : entityList) {
            list.add(customerEntity.toCustomer());
        }       

        return list;
	}

	public Customer save(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer object is null");

        em.persist(new CustomerEntity(customer));

        return customer;
	}

	public void remove(Customer customer) {
        if (customer == null)
            throw new IllegalArgumentException("Customer object is null");

		em.remove(em.merge(new CustomerEntity(customer)));
	}

}
