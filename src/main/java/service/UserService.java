package service;


import model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    User save(User user);

    User findById(Long id);
    void update(User user);

    User findByUsername(String username);
    List<User> getAll();
    void deleteUser(User user);
    Set<User> search(String query);
}