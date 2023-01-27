package ee.valiit.back_bank_27.bank;

import lombok.Data;

@Data
public class LoginResponse {
    private Integer userId;
    private String roleType;
}
