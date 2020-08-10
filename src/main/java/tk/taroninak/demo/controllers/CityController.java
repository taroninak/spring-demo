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
@RequestMapping(path = "city", produces = "application/json")
public class CityController {

    private final CustomerService customerService;

    @Autowired
    public CityController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(path = "/{name}")
    @Transactional(readOnly = true)
    public List<Customer> getCustomers(@PathVariable("name") String name) {
        return customerService.getAllByCity(name);
    }

}
