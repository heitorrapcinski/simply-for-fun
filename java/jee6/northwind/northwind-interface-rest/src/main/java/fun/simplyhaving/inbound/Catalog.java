package fun.simplyhaving.inbound;


import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.service.CustomerService;

@Path("/catalog")
@ManagedBean
public class Catalog implements Serializable {

    @Context
    private UriInfo uriInfo;

    @EJB
    private CustomerService customerService;

    @GET
    @Path("/customers")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Customer> findAllCustomers() {
        System.out.println("==== Customer Service ==="+customerService);

        return customerService.getAllCustomers();
    }
    
}
