package cf.ac.uk.wrackreport.security;

import cf.ac.uk.wrackreport.data.jpa.entities.StaffUserEntity;
import cf.ac.uk.wrackreport.data.jpa.entities.UserEntity;
import cf.ac.uk.wrackreport.data.jpa.repositories.StaffUserRepository;
import cf.ac.uk.wrackreport.data.jpa.repositories.UserRepository;
import cf.ac.uk.wrackreport.service.StaffUserService;
import cf.ac.uk.wrackreport.service.dto.StaffUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WrackReportUserDetailsService implements UserDetailsService {

    @Autowired
    StaffUserService staffUserService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Get instance of User Details with username as argument
        Optional<StaffUserDTO> staffUser = staffUserService.findByEmail(email);

        staffUser.orElseThrow(() -> new UsernameNotFoundException("Not found " + email));

        //convert to WrackReportUserDetails instance
        return staffUser.map(WrackReportUserDetails::new).get();
    }
}
