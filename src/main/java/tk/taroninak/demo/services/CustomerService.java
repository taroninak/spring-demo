package tk.taroninak.demo.services;

import org.springframework.transaction.annotation.Transactional;
import tk.taroninak.demo.entities.Customer;

import java.util.List;

public interface CustomerService {
    @Transactional(readOnly = true)
    List<Customer> getAll();

    @Transactional(readOnly = true)
    Customer getById(long id);

    @Transactional
    Customer create(CustomerCreationRequest request);

    @Transactional(readOnly = true)
    List<Customer> getAllByCity(String city);

    @Transactional(readOnly = true)
    List<Customer> getAllByPhone(String phonePrefix);
}
