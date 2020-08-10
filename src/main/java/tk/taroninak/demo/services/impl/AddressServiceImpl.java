package tk.taroninak.demo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.taroninak.demo.entities.Address;
import tk.taroninak.demo.entities.Customer;
import tk.taroninak.demo.repositories.AddressRepository;
import tk.taroninak.demo.repositories.CustomerRepository;
import tk.taroninak.demo.services.AddressCreationRequest;
import tk.taroninak.demo.services.AddressService;

import java.security.InvalidParameterException;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public Address create(long customerId, AddressCreationRequest request) {
        Optional<Customer> optional = customerRepository.findOneById(customerId);
        Customer customer = optional.orElseThrow();

        Address address = new Address();
        address.setCustomer(customer);
        address.setType(request.getType());
        address.setCity(request.getCity());
        address.setCountry(request.getCountry());
        address.setAddressLine(request.getAddressLine());

        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public Address delete(long customerId, long id) {
        Address address = addressRepository.getOne(id);
        if (address == null || address.getCustomer() == null || address.getCustomer().getId() != customerId) {
            throw new InvalidParameterException();
        }

        addressRepository.delete(address);
        return address;
    }
}
