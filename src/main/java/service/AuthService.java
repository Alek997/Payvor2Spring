package service;


import model.Role;
import model.User;

import java.util.List;

public interface AuthService {
    User findByUsername(String username);
    List<Role> getRoles();
}