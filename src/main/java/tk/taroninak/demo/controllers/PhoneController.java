package tk.taroninak.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.taroninak.demo.entities.Customer;
import tk.taroninak.demo.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "phone", produces = "application/json")
public class PhoneController {
    private final CustomerService customerService;

    @Autowired
    public PhoneController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/{prefix}")
    @Transactional(readOnly = true)
    public List<Customer> getCustomers(@PathVariable("name") String prefix) {
        return customerService.getAllByPhone(prefix);
    }
}
