package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.domain.LoginRequest;
import kr.hs.dgsw.simple.domain.LoginResponse;
import kr.hs.dgsw.simple.domain.User;
import kr.hs.dgsw.simple.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{idx}")
    public void deleteUser(@PathVariable int idx) {
        userService.deleteUser(idx);
    }


    @GetMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();

        try {
            AbstractAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            loginResponse.setResult("success");
        } catch (LockedException e) {
            loginResponse.setResult("locked");
        } catch (BadCredentialsException e) {
            loginResponse.setResult("bad credential");
        } catch (DisabledException e) {
            loginResponse.setResult("disabled");
        } catch (Exception e) {
            loginResponse.setResult("fail");
        }

        return loginResponse;
    }

}
