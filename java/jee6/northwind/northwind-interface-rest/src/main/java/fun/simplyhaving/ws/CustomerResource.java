package fun.simplyhaving.ws;


import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import fun.simplyhaving.model.Customer;
import fun.simplyhaving.service.CustomerService;

@Path("/customer")
@Stateless
public class CustomerResource implements Serializable {

    @Context
    private UriInfo uriInfo;

    @EJB
    private CustomerService customerService;

    @GET
    @Path("/customers")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
}
