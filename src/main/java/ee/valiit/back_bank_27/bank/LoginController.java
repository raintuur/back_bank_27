package ee.valiit.back_bank_27.bank;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.annotations.OpenAPI30;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    @Operation(summary = "Selle teenusega saab rakendusse sisse logida")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {

        LoginService loginService = new LoginService();

//        loginService.login();


        return response;
    }

}
