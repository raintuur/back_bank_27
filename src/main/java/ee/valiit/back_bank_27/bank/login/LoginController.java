package ee.valiit.back_bank_27.bank.login;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

//    @Resource - Rakendust laadides otsitakse ülesse see class ning tehakse objekt, et saaks servicit
//                kasutada controlleri meetodites ning iga kord ei pea uuesti classi instance'it tegema
//                ilma @ annotatsioonita oleks instance'i väärtus null, annotatsioon annab terve klassi insantsi
    @Resource
    private LoginService loginService;

// @GetMapping - Kui tuleb get sõnum /login pathile, siis käivitatakse see method
    @GetMapping("/login")
    @Operation(summary = "Selle teenusega saab rakendussse sisse logida")
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {

        LoginResponse loginResponse = loginService.login(username, password);

        return loginResponse;
    }

}
