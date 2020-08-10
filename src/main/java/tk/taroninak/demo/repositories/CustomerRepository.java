package tk.taroninak.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tk.taroninak.demo.entities.Customer;

import java.util.List;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {


    @Query("select a.customer " +
            "from Address a " +
            "where a.city = :city")
    List<Customer> findByCity(String city);

    List<Customer> findByPhoneNumberStartsWith(String prefix);
}
