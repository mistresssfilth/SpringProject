package com.mistressfilth.spring.service;

import com.mistressfilth.spring.entity.Role;
import com.mistressfilth.spring.repo.RoleRepo;
import com.mistressfilth.spring.repo.UserRepo;
import com.mistressfilth.spring.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }

    public Boolean save(User user){
        User userFromDB = userRepo.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        userRepo.save(user);
        return true;
    }
    public void delete(Long id){
        userRepo.deleteById(id);
    }

    public void update(String username, Set<Role> roles){
        User user = userRepo.findByUsername(username);
        user.setUsername(username);
        user.setRoles(roles);
        userRepo.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found");

        return user;
    }

}
