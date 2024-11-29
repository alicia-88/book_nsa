package com.nsa.book_nsa.service;

import com.nsa.book_nsa.model.User;
import com.nsa.book_nsa.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collections;
import javax.security.auth.login.AccountException;
import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void register(User userDetails) {
        // TODO  Hash Password
        // hashPassword
        //userDetails.setPassword(hashPassword);
        // valid email confirm
        // set role default user
        userDetails.setRole("USER");
        userRepository.save(userDetails);
    }

//    public void login(User userDetails) {
//        // TODO Search email exists
//        User user = userRepository.findByEmail(userDetails.getEmail());
//        // TODO Compare hash password
//        if (user != null) {
//            //validPassword = userDetails.getPassword() compare user.getPassword()
//            //!validPassword throw new AccountException("")
//        }
//        // generate token jwt
//    }
    public User logout() {
        // destroy token
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("Could not findUser with username = " + username);
        return new org.springframework.security.core.userdetails.User(
                username,
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
