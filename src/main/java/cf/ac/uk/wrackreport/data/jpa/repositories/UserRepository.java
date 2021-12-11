package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity save(UserEntity aUser);

    ArrayList<UserEntity> findAll();

}

