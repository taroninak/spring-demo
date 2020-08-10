package tk.taroninak.demo.controllers;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.taroninak.demo.dtos.CustomerDto;
import tk.taroninak.demo.entities.Customer;
import tk.taroninak.demo.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "city", produces = "application/json")
public class CityController {
    private final ConfigurableMapper mapper;

    private final CustomerService customerService;

    @Autowired
    public CityController(ConfigurableMapper mapper, CustomerService customerService) {
        this.mapper = mapper;
        this.customerService = customerService;
    }

    @GetMapping(path = "/{city}")
    @Transactional(readOnly = true)
    public List<CustomerDto> getCustomers(@PathVariable("city") String city) {
        List<Customer> list = customerService.getAllByCity(city);
        return  mapper.mapAsList(list, CustomerDto.class);

    }

}
