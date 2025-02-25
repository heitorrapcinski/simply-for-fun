package fun.simplyhaving.web;

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

    private List<Customer> customers;

    public List<Customer> getAllCustomers() {
        if (customers == null) {
            customers = customerService.getAllCustomers();
        }
        return customers;
    }

}
