package tk.taroninak.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.taroninak.demo.dtatatypes.CustomerCreationRequest;
import tk.taroninak.demo.dtos.CustomerDto;
import tk.taroninak.demo.entities.Customer;
import tk.taroninak.demo.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "customer", produces = "application/json")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public @ResponseBody
    List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping(path = "/{id}")
    @Transactional(readOnly = true)
    public @ResponseBody
    CustomerDto getById(@PathVariable("id") long id) {
        Customer customer = customerService.getById(id);
        CustomerDto response = new CustomerDto();
        response.setId(customer.getId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setPhoneNumber(customer.getPhoneNumber());
        response.setEmail(customer.getEmail());

        return response;
    }

    @PostMapping
    @Transactional
    public Customer create(@RequestBody CustomerCreationRequest request) {
        return customerService.create(request);
    }
}
