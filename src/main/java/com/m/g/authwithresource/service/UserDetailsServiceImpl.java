package com.m.g.authwithresource.service;

import com.m.g.authwithresource.model.Authorities;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private static final boolean DEFAULT_ACC_NON_EXP = true;
    private static final boolean DEFAULT_CRED_NON_EXP = true;
    private static final boolean DEFAULT_ACC_NON_LOCKED = true;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<String> authorities = new ArrayList<>();
        authorities.add(Authorities.ROLE_USER);
        User springUser = new User("username",
                bCryptPasswordEncoder.encode("password"),
                true,
                DEFAULT_ACC_NON_EXP,
                DEFAULT_CRED_NON_EXP,
                DEFAULT_ACC_NON_LOCKED,
                buildAuthorities(authorities));
        return  springUser;
    }

    private List<GrantedAuthority> buildAuthorities(List<String> authorities) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
        for(String authority : authorities) {
            authList.add(new SimpleGrantedAuthority(authority));
        }
        return authList;
    }

}