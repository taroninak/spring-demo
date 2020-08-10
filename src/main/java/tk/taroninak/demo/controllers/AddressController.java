package tk.taroninak.demo.controllers;

import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tk.taroninak.demo.dtos.AddressCreationRequestDto;
import tk.taroninak.demo.dtos.AddressDto;
import tk.taroninak.demo.entities.Address;
import tk.taroninak.demo.services.AddressCreationRequest;
import tk.taroninak.demo.services.AddressService;

@RestController
@RequestMapping(path = "customer/{customerId}/address", produces = "application/json")
public class AddressController {
    private final ConfigurableMapper mapper;

    private final AddressService addressService;

    @Autowired
    public AddressController(ConfigurableMapper mapper, AddressService addressService) {
        this.mapper = mapper;
        this.addressService = addressService;
    }

    @PostMapping
    @Transactional
    public AddressDto create(@PathVariable("customerId") long customerId, @RequestBody AddressCreationRequestDto requestDto) {
        AddressCreationRequest request = mapper.map(requestDto, AddressCreationRequest.class);
        Address address = addressService.create(customerId, request);
        return mapper.map(address, AddressDto.class);
    }

    @DeleteMapping(path = "/{addressId}")
    @Transactional
    public AddressDto delete(@PathVariable("customerId") long customerId, @PathVariable("addressId") long addressId) {
        Address address = addressService.delete(customerId, addressId);
        return mapper.map(address, AddressDto.class);
    }

}
