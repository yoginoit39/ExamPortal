package org.example.examserver.Services.implementations;

import org.example.examserver.Services.UserService;
import org.example.examserver.entity.User;
import org.example.examserver.entity.UserRole;
import org.example.examserver.repo.RoleRepository;
import org.example.examserver.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception {

        User local = this.userRepository.findByUsername(user.getUsername());

        if(local != null){
            System.out.println("user already exists");
            throw new Exception("User already present");
        }else {
            //create user
            for(UserRole ur:userRoles){
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);
           local = this.userRepository.save(user);
        }


        return local;
    }


    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(User user, Long userId) {
        Optional<User> optionalUser = this.userRepository.findById(userId);

        User existingUser = optionalUser.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        existingUser.setProfile(user.getProfile());
        existingUser.setPhone(user.getPhone());

        return this.userRepository.save(existingUser);
    }


}
