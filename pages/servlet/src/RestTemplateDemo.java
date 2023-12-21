@RestController
@RequestMapping("/rest")
public class RestTemplateDemo {

  public String getSomeData() {
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-SOME-KEY", "some-value");
    HttpEntity<String> entity = new HttpEntity<>(headers);

    RestTemplate restTemplate = new RestTemplate();
    String url = "https://api.domain.com/some-path";
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    return response.getBody();
  }
}
