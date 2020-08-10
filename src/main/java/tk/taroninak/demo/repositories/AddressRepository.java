package tk.taroninak.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tk.taroninak.demo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
