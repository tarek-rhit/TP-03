package tn.suptech.tn.tp03.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.suptech.tn.tp03.domain.Role;

import tn.suptech.tn.tp03.domain.exceptions.RoleNotFoundException;
import tn.suptech.tn.tp03.repository.RoleRepository;

@Service
public class RoleService {

    Logger logger = LoggerFactory.getLogger(RoleService.class);

    public final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

     //Creation d'un nouveau role
     public Role addRole(Role role){
         logger.info("BEGIN RoleService#createRole");
        return roleRepository.save(role);
     }
    //Recupérer un role
    public Role getRole(Long RID) {
        logger.info("BEGIN RoleService#récupérerRole");
        return roleRepository.findById(RID).orElseThrow(()->
                new RoleNotFoundException(RID));
    }

    //Modifier un role
    public Role updateRole( Long RID ,Role role) {
        logger.info("BEGIN RoleService#updateRole");
        Role roleToUpdate = getRole(RID);
        roleToUpdate.setRID(role.getRID());
        roleToUpdate.setNAME(role.getNAME());
        roleToUpdate.setDESCRIPTION(role.getDESCRIPTION());
        logger.info("END RoleService#updateRole");
        return roleToUpdate;
    }

    //Supprimer un role
    public Role deleteRole(Long RID){
        logger.info("BEGIN RoleService#deleteRole");
        Role role = getRole(RID);
        roleRepository.delete(role);
        logger.info("END RoleService#deleteRole");
        return role;
    }
}
