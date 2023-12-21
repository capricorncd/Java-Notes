package com.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Auth {
  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  public User authenticateUsernameAndPassword(String username, String password) {
    try {
      // User user = userService.findByUsername(username);
      User user = userDetailsService.loadUserByUsername(username);
      if (user != null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
        return user;
      }
    } catch (UserNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  public void authWithUser(HttpServletRequest request, User user) {
    if (user == null) {
      throw new Exception("Invalid username or password");
    }

    UsernamePasswordAuthentication authentication = new UsernamePasswordAuthentication(user, password,
        user.getAuthorities());

    authentication.setDetails(new WebAuthenticationDetails(request));
    SecurityContextHolder.getContext().setAuthentication(authentication);

    HttpSession session = request.getSession();
    session.setAttribute(Constants.SESSION_KEY_AUTHENTICATION, authentication);
  }

  public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
    User user = authenticateUsernameAndPassword(username, password);
    authWithUser(request, user);
    // response.sendRedirect("/");
  }
}
