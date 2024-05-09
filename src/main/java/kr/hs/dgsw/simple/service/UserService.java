package kr.hs.dgsw.simple.service;

import kr.hs.dgsw.simple.domain.User;

import java.util.List;

public interface UserService {

    public User getUser(int idx);

    public User getUser(String email);

    public List<User> getUserList();

    public User addUser(User user);

    public User updateUser(User user);

    public void deleteUser(int userIdx);
}
