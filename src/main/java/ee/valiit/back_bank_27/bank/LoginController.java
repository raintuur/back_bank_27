package ee.valiit.back_bank_27.bank;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "Selle teenusega saab rakendusse sisse logida")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
       LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;
    }

}
