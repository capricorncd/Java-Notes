public class RedirectAndForward {
  /**
   * forward
   * 
   * @param request
   * @param response
   */
  public void forward(HttpServletRequest request, HttpServletResponse response) {
    String url = "/target_url";
    request.getRequestDispatcher(url).forward(request, response);
  }

  public void redirect(HttpServletRequest request, HttpServletResponse response) {
    String url = "/target_url";
    response.sendRedirect(url);
  }

  public String redirect(HttpServletRequest request, HttpServletResponse response) {
    String url = "/target_url";
    return String.format("redirect:%s", url);
  }
}
