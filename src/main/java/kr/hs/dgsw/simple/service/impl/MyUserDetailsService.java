package kr.hs.dgsw.simple.service.impl;

import kr.hs.dgsw.simple.domain.MyUserDetails;
import kr.hs.dgsw.simple.domain.User;
import kr.hs.dgsw.simple.service.UserService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            User user = userService.getUser(username);

            return new MyUserDetails(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException(username);
        }
    }
}
