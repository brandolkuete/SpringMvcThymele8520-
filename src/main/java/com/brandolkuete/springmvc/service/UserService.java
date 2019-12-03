package com.brandolkuete.springmvc.service;

import com.brandolkuete.springmvc.models.Role;
import com.brandolkuete.springmvc.models.User;
import com.brandolkuete.springmvc.repository.RoleRepository;
import com.brandolkuete.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Map<String,Object> getLogedUser(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();

        SecurityContext securityContext = (SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");

        String username = securityContext.getAuthentication().getName();

        List<String> roles = new ArrayList<>();

        for (GrantedAuthority ga: securityContext.getAuthentication().getAuthorities()){
            roles.add(ga.getAuthority());
        }

        Map<String,Object> params = new HashMap<>();
        params.put("username",username);
        params.put("roles",roles);

        return params;
    }

    public User save(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.getRoles().add(roleRepository.findByName("USER"));
        return userRepository.save(user);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }
    public List<Role> findRoles(){
        return roleRepository.findAll();
    }

    public User addRoleToUser(String username, String role){

        User user =userRepository.findByUsername(username);
        user.getRoles().add(roleRepository.findByName(role));
        userRepository.saveAndFlush(user);
        return user;
    }
}
