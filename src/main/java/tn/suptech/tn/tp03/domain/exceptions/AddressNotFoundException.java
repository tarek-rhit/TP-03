package tn.suptech.tn.tp03.domain.exceptions;

import java.text.MessageFormat;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(Long AID){
        super( MessageFormat.format("il ne peut pas trouver l'address par id:{0}",AID));
    }

}
