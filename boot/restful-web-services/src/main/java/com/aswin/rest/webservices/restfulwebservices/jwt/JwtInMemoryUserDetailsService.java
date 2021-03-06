package com.aswin.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  
//  {
//	  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhc3dpbiIsImV4cCI6MTU5ODM2Mjc4MCwiaWF0IjoxNTk3NzU3OTgwfQ.SIuZd9l0yiioMHNLRkA-nBArghadkVv2eliTY-_ZQqTICBIMNcz8etuw3kclVSsS0Cw-OH-VEzgmZe3tCvheRw"
//	  }
//  
  static {
    inMemoryUserList.add(new JwtUserDetails(1L, "aswin",
        "$2a$10$kkH/LSGdGK8ISqiLXk3cFeIjbEzXpjOi8Ia2yZDzFNJhIAMGCcjvm", "ROLE_USER_2"));
    inMemoryUserList.add(new JwtUserDetails(1L, "aswintp",
            "$2a$10$zipmMACkg0UM2UzAaeOhPOMKeipLHYqOvDRY3LiB80M6OGEUWr64O", "ROLE_USER_2"));
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


