package ee.valiit.back_bank_27.bank;

import lombok.extern.java.Log;

public class LoginService {

    public LoginResponse login(String username, String password){
        // todo: implement
        LoginResponse response = new LoginResponse();
        response.setUserId(666);
        response.setRoleType("admin");

        return null; // todo: add return
    }

}
