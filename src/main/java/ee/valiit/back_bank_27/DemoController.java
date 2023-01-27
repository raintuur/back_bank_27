package ee.valiit.back_bank_27;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/all/atm/city")
    public String helloWorld() {
        return "hello world";
    }
}
