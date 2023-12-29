package tn.suptech.tn.tp03.domain.exceptions;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long ID){
        super(MessageFormat.format("il ne peut pas trouver l'address par id:{0}",ID));
    }
}
