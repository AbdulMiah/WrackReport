package cf.ac.uk.wrackreport.data.jpa.adaptors;

import cf.ac.uk.wrackreport.data.interfaces.WrackReportRepository;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import cf.ac.uk.wrackreport.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class WrackRepositoryAdaptor implements WrackReportRepository {

    private UserRepository userRepository;

    public WrackRepositoryAdaptor(UserRepository repo) {
        userRepository = repo;
    }

    public void saveUser(User aUser) {
        UserEntity userEntity = new UserEntity(aUser);
        userRepository.save(userEntity);
    }

}
