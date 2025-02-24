package fun.simplyhaving.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fun.simplyhaving.domain.Customer;

@Entity(name = "Customer")
@Table(name = "Customers")
@NamedQueries({
        @NamedQuery(name = CustomerEntity.FIND_BY_ID, query = "SELECT c FROM Customer c WHERE c.id = :id"),
        @NamedQuery(name = CustomerEntity.FIND_ALL, query = "SELECT c FROM Customer c")
})
public class CustomerEntity extends Customer {

    public static final String FIND_BY_ID = "Customer.findById";
    public static final String FIND_ALL = "Customer.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustomerID")
    private Long id;
    @Column(name="CompanyName",nullable = false, length = 40)
    @NotNull
    @Size(min = 1, max = 40)
    private String companyName;
    @Column(name="ContactTitle",length = 30)
    private String contactTitle;
    @Column(name="ContactName",length = 30)
    private String contactName;
    @Column(name="Address",length = 60)
    private String address;
    @Column(name="City",length = 15)
    private String city;
    @Column(name="Region",length = 15)
    private String region;
    @Column(name="PostalCode",length = 10)
    private String postalCode;
    @Column(name="Country",length = 15)
    private String country;
    @Column(name="Phone",length = 24)
    private String phone;
    @Column(name="Fax",length = 24)
    private String fax;    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (!id.equals(customer.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer");
        sb.append("{id=").append(id);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", contactTitle='").append(contactTitle).append('\'');
        sb.append(", contactName='").append(contactName).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", region='").append(region).append('\'');
        sb.append(", postalCode=").append(postalCode).append('\'');
        sb.append(", country=").append(country).append('\'');
        sb.append(", phone=").append(phone).append('\'');
        sb.append(", fax=").append(fax).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
