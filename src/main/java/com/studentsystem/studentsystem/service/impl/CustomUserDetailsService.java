package com.studentsystem.studentsystem.service.impl;

import com.studentsystem.studentsystem.entity.Korisnik;
import com.studentsystem.studentsystem.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        System.out.println("Attempting to load user by username or email: " + usernameOrEmail);

        Korisnik korisnik = korisnikRepository.findByUsername(usernameOrEmail);
        if (korisnik == null) {
            korisnik = korisnikRepository.findByEmail(usernameOrEmail);
            if (korisnik == null) {
                System.out.println("User not found");
                throw new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail);
            }
        }

        System.out.println("User found: " + korisnik);
        return new User(korisnik.getUsername(), korisnik.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + korisnik.getRole().toUpperCase())));
    }
}
