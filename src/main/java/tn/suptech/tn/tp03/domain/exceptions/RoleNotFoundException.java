package tn.suptech.tn.tp03.domain.exceptions;

import java.text.MessageFormat;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(Long RID){
        super(MessageFormat.format("il ne peut pas trouver l'address par id:{0}",RID));
    }
}
