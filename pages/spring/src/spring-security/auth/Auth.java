package com.demo;

public class Auth {
  @Autowired
  private UserDetailsService userDetailsService;

  public User authenticateUsernameAndPassword(String username, String password) {
    try {
      User user = userDetailsService.loadUserByUsername(username);
      if (user != null && user.getPassword().equals(password)) {
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
