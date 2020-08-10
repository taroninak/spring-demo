package tk.taroninak.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.taroninak.demo.services.CustomerCreationRequest;
import tk.taroninak.demo.entities.Customer;
import tk.taroninak.demo.repositories.CustomerRepository;
import tk.taroninak.demo.services.CustomerService;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Customer getById(long id) {
        return customerRepository.getOne(id);
    }

    @Override
    @Transactional
    public Customer create(CustomerCreationRequest request) {
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setEmail(request.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllByCity(String city) {
        return customerRepository.findByCity(city);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllByPhone(String phonePrefix) {
        return customerRepository.findByPhoneNumberStartsWith(phonePrefix);
    }
}
