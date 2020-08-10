package tk.taroninak.demo.controllers;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.taroninak.demo.services.AddressService;

@RestController
@RequestMapping(path = "address", produces = "application/json")
public class AddressController {
    private final ConfigurableMapper mapper;

    private final AddressService addressService;

    @Autowired
    public AddressController(ConfigurableMapper mapper, AddressService addressService) {
        this.mapper = mapper;
        this.addressService = addressService;
    }
}
