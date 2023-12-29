package tn.suptech.tn.tp03.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.suptech.tn.tp03.domain.User;




@Repository
public interface UserRepository extends JpaRepository<User,Long> {



}
