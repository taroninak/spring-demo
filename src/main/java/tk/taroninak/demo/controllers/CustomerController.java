package tk.taroninak.demo.controllers;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.taroninak.demo.dtos.CustomerCreationRequestDto;
import tk.taroninak.demo.services.CustomerCreationRequest;
import tk.taroninak.demo.dtos.CustomerDto;
import tk.taroninak.demo.entities.Customer;
import tk.taroninak.demo.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping(path = "customer", produces = "application/json")
public class CustomerController {

    private final ConfigurableMapper mapper;

    private final CustomerService customerService;

    @Autowired
    public CustomerController(ConfigurableMapper mapper, CustomerService customerService) {
        this.mapper = mapper;
        this.customerService = customerService;
    }

    @GetMapping
    @Transactional(readOnly = true)
    public @ResponseBody
    List<CustomerDto> getAll() {
        List<Customer> list = customerService.getAll();
        return  mapper.mapAsList(list, CustomerDto.class);
    }

    @GetMapping(path = "/{id}")
    @Transactional(readOnly = true)
    public @ResponseBody
    CustomerDto getById(@PathVariable("id") long id) {
        return mapper.map(customerService.getById(id), CustomerDto.class);
    }

    @PostMapping
    @Transactional
    public CustomerDto create(@RequestBody CustomerCreationRequestDto requestDto) {
        CustomerCreationRequest request = mapper.map(requestDto, CustomerCreationRequest.class);
        Customer customer = customerService.create(request);
        return mapper.map(customer, CustomerDto.class);
    }
}
