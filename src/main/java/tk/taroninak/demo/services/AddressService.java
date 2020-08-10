package tk.taroninak.demo.services;

import org.springframework.transaction.annotation.Transactional;
import tk.taroninak.demo.entities.Address;

public interface AddressService {

    @Transactional
    Address create(long customerId, AddressCreationRequest request);

    @Transactional
    Address delete(long customerId, long id);
}
