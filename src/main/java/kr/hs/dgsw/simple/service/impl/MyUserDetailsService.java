package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.MyUserDetails;
import kr.hs.dgsw.simple.domain.User;
import kr.hs.dgsw.simple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.getUser(username);
            UserDetails userDetails = new MyUserDetails(user);

            return userDetails;
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(username, e);
        }
    }
}
