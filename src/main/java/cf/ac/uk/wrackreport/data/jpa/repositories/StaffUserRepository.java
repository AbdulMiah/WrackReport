package cf.ac.uk.wrackreport.data.jpa.repositories;

import cf.ac.uk.wrackreport.data.jpa.entities.StaffUserEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface StaffUserRepository extends JpaRepository<StaffUserEntity, Long> {

    Optional<StaffUserEntity> findByEmail(String email);

}
