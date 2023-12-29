package tn.suptech.tn.tp03.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.tn.tp03.domain.Role;
import tn.suptech.tn.tp03.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

    Logger logger = LoggerFactory.getLogger(RoleController.class);

    public final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    //Récupérer un role
    @GetMapping("{rid}")
    public Role getRole(@PathVariable Long RID) {
        logger.info("BEGIN RoleController#createRole");
        return roleService.getRole(RID);
    }

    //Modifier un role
    @PutMapping("{rid}")
    public Role updateRole(@RequestBody Role role, @PathVariable Long RID) {
        logger.info("BEGIN RoleController#updateRole");
        return roleService.updateRole(RID, role);
    }

    //Supprimer role
    @DeleteMapping("{rid}")
    public void deleteRole(@PathVariable Long RID){
        logger.info("BEGIN RoleController#updateRole");
        roleService.deleteRole( RID);
    }
}
