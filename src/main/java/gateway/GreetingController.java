package gateway;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
 
    @GetMapping("/helloworld")
    public ResponseEntity<String> getSimple() {
        return ResponseEntity.ok("Helloo World!");
    }
}