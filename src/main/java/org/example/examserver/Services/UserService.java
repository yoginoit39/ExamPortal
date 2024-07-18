package org.example.examserver.Services;

import org.example.examserver.entity.User;
import org.example.examserver.entity.UserRole;

import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

}
