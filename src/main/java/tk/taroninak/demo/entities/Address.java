package tk.taroninak.demo.entities;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(
        name = "address"
)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    //TODO: Most probably should be some enum. Communicate with test assigner and change to appropriate one
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "address_line", nullable = false)
    private String addressLine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return new EqualsBuilder()
                .append(getId(), address.getId())
                .append(getCustomer() != null ? getCustomer().getId() : null,
                        address.getCustomer() != null ? address.getCustomer().getId() : null)
                .append(getType(), address.getType())
                .append(getCity(), address.getCity())
                .append(getCountry(), address.getCountry())
                .append(getAddressLine(), address.getAddressLine())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getCustomer() != null ? getCustomer().getId() : null)
                .append(getType())
                .append(getCity())
                .append(getCountry())
                .append(getAddressLine())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("customer", customer)
                .append("type", type)
                .append("city", city)
                .append("country", country)
                .append("addressLine", addressLine)
                .toString();
    }
}
