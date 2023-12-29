package tn.suptech.tn.tp03.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.suptech.tn.tp03.domain.User;
import tn.suptech.tn.tp03.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    public final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    //Création d'un user
    @PostMapping ("/adduser")
    public User addUser(@RequestBody User user) {
        logger.info("BEGIN UserController#createUser");
        return userService.addUser(user);
    }

    //Récupérer tous les users
    @GetMapping("/get/all")
    public List<User> findAll() {
        logger.info("BEGIN UserController#récupérerUsers");
        return userService.getAllUser();
    }
    //Récupérer un seul user
    @GetMapping("{id}")
    public User getOne (@PathVariable Long ID){
        logger.info("BEGIN UserController#récupérerUser");
        return userService.getUser( ID );
    }

    //Modifier un user
    @PutMapping  ("{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long ID) {
        logger.info("BEGIN UserController#updateUser");
        return userService.updateUser(ID,user);
    }
    //Supprimer un user
    @DeleteMapping("{id}")
    public void deleteUser (Long id){
        logger.info("BEGIN UserController#deleteUser");
        userService.deleteUser(id);
    }
}