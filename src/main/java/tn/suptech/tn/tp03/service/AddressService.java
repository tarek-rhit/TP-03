package tn.suptech.tn.tp03.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.tn.tp03.domain.Address;
import tn.suptech.tn.tp03.domain.exceptions.AddressNotFoundException;
import tn.suptech.tn.tp03.repository.AddressRepository;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);


    public final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Creation d'une nouveau addresse
    public Address addAddress(Address address){
        logger.info("BEGIN AddressService#createAddress");
        return addressRepository.save(address);
    }

    //Récupérer une address
    public Address getAddress(Long AID) {
        logger.info("BEGIN AddressService#récupérerAddress");
        return addressRepository.findById(AID).orElseThrow(()->
                new AddressNotFoundException(AID));
    }

    //Modifier une address
    public Address updateAddress(Long AID ,Address address) {
        logger.info("BEGIN AddressService#updateAddress");
        Address addressToUpdate = getAddress(AID);
        addressToUpdate.setAID(address.getAID());
        addressToUpdate.setCOUNTRY(address.getCOUNTRY());
        addressToUpdate.setSTREET(address.getSTREET());
        addressToUpdate.setZIPCODE(address.getZIPCODE());
        logger.info("END AddressService#updateAddress");
        return addressToUpdate;
    }

    //Supprimer une address
    public Address deleteAddress(Long AID){
        logger.info("BEGIN AddressService#deleteAddress");
       Address address = getAddress(AID);
        addressRepository.delete(address);
        logger.info("END AddressService#deleteAddress");
        return address;
    }
}
