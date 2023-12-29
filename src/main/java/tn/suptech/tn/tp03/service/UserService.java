package tn.suptech.tn.tp03.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.suptech.tn.tp03.domain.User;
import tn.suptech.tn.tp03.domain.exceptions.UserNotFoundException;
import tn.suptech.tn.tp03.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UserService {

   Logger logger = LoggerFactory.getLogger(UserService.class);


   public final UserRepository userRepository;
   public final AddressService addressService;
   public final RoleService roleService;


    @Autowired
    public UserService(UserRepository userRepository, AddressService addressService, RoleService roleService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
        this.roleService = roleService;
    }


    //Créer un user
    public User addUser(User user){
        logger.info("BEGIN UserService#createUser");
        return userRepository.save(user);
    }

    //Recuperer un user
    public User getUser (Long ID){
        logger.info("BEGIN UserService#récupérerUser");
        return userRepository.findById(ID).orElseThrow(()->
                new UserNotFoundException(ID));
    }

    //Récupérer tous les users
    public List<User> getAllUser(){
        logger.info("BEGIN UserService#récupérerUsers");
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    //Modifier un user
    public User updateUser(Long ID , User user) {
        logger.info("BEGIN UserService#updateUser");
        User userToupdate = getUser(ID);
        userToupdate.setID(user.getID());
        userToupdate.setFIRSTNAME(user.getFIRSTNAME());
        userToupdate.setLASTNAME(user.getLASTNAME());
        userToupdate.setUSERNAME(user.getUSERNAME());
        userToupdate.setPASSWORD(user.getPASSWORD());
        userToupdate.setAddress(user.getAddress());
        logger.info("END UserService#updateUser");
        return userToupdate;
    }

    //Supprimer user
    public User deleteUser(Long ID){
        logger.info("BEGIN UserService#deleteUser");
        User user = getUser(ID);
        userRepository.delete(user);
        logger.info("END UserService#deleteUser");
        return user;
    }

}
