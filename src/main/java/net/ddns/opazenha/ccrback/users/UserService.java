package net.ddns.opazenha.ccrback.users;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
