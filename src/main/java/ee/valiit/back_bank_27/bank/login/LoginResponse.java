package ee.valiit.back_bank_27.bank.login;

import lombok.Data;

@Data
public class LoginResponse {
    private Integer userId;
    private String roleType;

}
