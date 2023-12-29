package tn.suptech.tn.tp03.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.tn.tp03.domain.Address;

import tn.suptech.tn.tp03.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    Logger logger = LoggerFactory.getLogger(AddressController.class);

    public final AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {

        this.addressService = addressService;
    }

    //Récupérer une address
    @GetMapping("{aid}")
    public Address getAddress(@PathVariable Long AID) {
        logger.info("BEGIN AddressController#createAddress");
        return addressService.getAddress(AID);
    }

    //Modifier une address
    @PutMapping("{aid}")
    public Address updateAddress(@RequestBody Address address, @PathVariable Long AID) {
        logger.info("BEGIN AddressController#updateAddress");
        return addressService.updateAddress( AID,getAddress(AID));
    }

    //Supprimer Address
    @DeleteMapping("{aid}")
    public void deleteAddress(@PathVariable Long AID){
        logger.info("BEGIN AddressController#deleteAddress");
        addressService.deleteAddress( AID);
    }
}