package fun.simplyhaving.inbound;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.service.CustomerService;

@ManagedBean
@RequestScoped
public class CustomerController {

    @EJB
    private CustomerService customerService;

    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

}
