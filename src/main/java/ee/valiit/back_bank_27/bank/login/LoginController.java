package ee.valiit.back_bank_27.bank.login;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    @Operation(summary = "This service enables the user to log in.", description = "This service returns error message when credentials are incorrect.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Log in failed!", content = @Content(schema = @Schema))
    })
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
        LoginResponse loginResponse = loginService.login(username, password);
        return loginResponse;
    }

}
