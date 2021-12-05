package cf.ac.uk.wrackreport.jpa;

import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@DirtiesContext
public class UserDataJPATests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldGetTwelveUsers() throws Exception{
        List<UserEntity> userList = userRepository.findAll();
        assertEquals(12, userList.size());
    }

    @Test
    public void shouldGetThirteenUsersAfterInput() throws Exception{
        UserEntity newUser = new UserEntity(null, "ROLE_USER", "test", "user", "test@gmail.com", "08847567364", "testpass", true);
        userRepository.save(newUser);
        List<UserEntity> userList = userRepository.findAll();
        assertEquals(13, userList.size());
    }

}
