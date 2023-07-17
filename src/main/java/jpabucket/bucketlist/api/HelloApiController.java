package jpabucket.bucketlist.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloApiController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello!";
    }

    @GetMapping("/main")
    public String getMainData() {
        return "Main data from API";
    }
}
