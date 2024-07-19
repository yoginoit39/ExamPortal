package org.example.examserver.Services;

import org.example.examserver.entity.User;
import org.example.examserver.entity.UserRole;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);

    //update user details
    public User updateUser(User user, Long userId);
}
