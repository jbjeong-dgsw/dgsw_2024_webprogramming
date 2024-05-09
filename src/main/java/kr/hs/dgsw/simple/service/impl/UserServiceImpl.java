package kr.hs.dgsw.simple.service.impl;

import jakarta.transaction.Transactional;
import kr.hs.dgsw.simple.domain.User;
import kr.hs.dgsw.simple.entity.UserEntity;
import kr.hs.dgsw.simple.repository.UserRepository;
import kr.hs.dgsw.simple.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUser(int idx) {
        UserEntity entity = userRepository.findById(idx).orElseThrow();

        return User.toDomain(entity);
    }

    @Override
    public User getUser(String email) {
        UserEntity entity = userRepository.findByEmail(email).orElseThrow();

        return User.toDomain(entity);
    }

    @Override
    public List<User> getUserList() {
        List<UserEntity> entities = userRepository.findAll();

        return entities.stream().map(User::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public User addUser(User user) {
        UserEntity entity = User.toEntity(user);
        entity.setRegisterTime(new Date());

        entity.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(entity);

        return getUser(entity.getUserIdx());
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        UserEntity entity = User.toEntity(user);

        userRepository.save(entity);

        return getUser(user.getUserIdx());
    }

    @Override
    @Transactional
    public void deleteUser(int userIdx) {
        userRepository.updateUserWithdrawed(userIdx, new Date());
    }
}
