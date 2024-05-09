package kr.hs.dgsw.simple.controller;

import kr.hs.dgsw.simple.domain.User;
import kr.hs.dgsw.simple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{idx}")
    public void deleteUser(@PathVariable int idx) {
        userService.deleteUser(idx);
    }

}
