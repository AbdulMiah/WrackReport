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
    public void shouldGetTwoUsers() throws Exception{
        List<UserEntity> userList = userRepository.findAll();
        assertEquals(2, userList.size());
    }

    @Test
    public void shouldGetThreeUsersAfterInput() throws Exception{
        UserEntity newUser = new UserEntity(null, 1, "test", "user", "test@gmail.com", "08847567364");
        userRepository.save(newUser);
        List<UserEntity> userList = userRepository.findAll();
        assertEquals(3, userList.size());
    }

}
