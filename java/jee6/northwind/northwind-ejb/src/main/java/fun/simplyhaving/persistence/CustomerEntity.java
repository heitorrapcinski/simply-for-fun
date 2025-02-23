package fun.simplyhaving.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fun.simplyhaving.domain.Customer;

@Entity
public class CustomerEntity extends Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 40)
    @NotNull
    @Size(min = 1, max = 40)
    private String companyName;
    @Column(length = 30)
    private String contactTitle;
    @Column(length = 30)
    private String contactName;
    @Column(length = 60)
    private String address;
    @Column(length = 15)
    private String city;
    @Column(length = 15)
    private String region;
    @Column(length = 10)
    private String postalCode;
    @Column(length = 15)
    private String country;
    @Column(length = 24)
    private String phone;
    @Column(length = 24)
    private String fax;    
    
}
