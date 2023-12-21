@RestController
@RequestMapping("/api")
public class ResponseJsonFromObject {
  @GetMapping("/entity")
  public ResponseData getEntityData(HttpServletRequest request, HttpServletResponse response) {
    ResponseData data = new ResponseData(1, "success");
    return data;
  }
}
