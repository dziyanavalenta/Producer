package dvalenta.Producer.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hi";
    }

}
