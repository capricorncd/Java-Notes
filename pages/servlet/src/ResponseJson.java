import java.io.PrintWriter;

@RestController
@RequestMapping("/api")
class ResponseJson {

  @GetMapping("/json")
  public void getJson(HttpServletRequest request, HttpServletResponse response) {
    String data = "{\"key\":\"value\",\"type\":null}";
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    // Write data to the response body
    writeData(response, data);
  }

  @GetMapping("/some-data")
  public void getJsonFromOtherResponse(HttpServletRequest request, HttpServletResponse response) {
    RestTemplate restTemplate = new RestTemplate();
    String url = "https://api.domain.com/some-data";

    // String data = restTemplate.postForObject(url, String.class);

    ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.POST, null, String.class);
    String data = res.getBody(); // "{\"key\":\"value\",\"type\":null}"

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    // Write data to the response body
    writeData(response, data);
  }

  public static void writeData(HttpServletResponse response, String data) {
    PrintWriter out = response.getWriter();
    out.print(data);
    out.flush();
    out.close();
  }
}