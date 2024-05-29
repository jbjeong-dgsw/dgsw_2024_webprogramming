package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.config.JwtTokenProvider;
import kr.hs.dgsw.simple.config.JwtTokenProvider1;
import kr.hs.dgsw.simple.domain.LoginRequest;
import kr.hs.dgsw.simple.domain.LoginResponse;
import kr.hs.dgsw.simple.domain.User;
import kr.hs.dgsw.simple.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{idx}")
    public void deleteUser(@PathVariable int idx) {
        userService.deleteUser(idx);
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        log.info("LOGIN {}", loginRequest);

        try {
            AbstractAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwtToken = jwtTokenProvider.createToken(authentication);

            loginResponse.setResult("success");
            loginResponse.setToken(jwtToken);


        } catch (LockedException e) {
            loginResponse.setResult("locked");
        } catch (BadCredentialsException e) {
            loginResponse.setResult("bad credential");
        } catch (DisabledException e) {
            loginResponse.setResult("disabled");
        } catch (UsernameNotFoundException e) {
            loginResponse.setResult("Not registered");
        }
        catch (Exception e) {
            log.error(e.getMessage(), e);
            loginResponse.setResult("fail");
        }

        return loginResponse;
    }

}
