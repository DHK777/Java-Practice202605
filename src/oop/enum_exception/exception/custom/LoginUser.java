package oop.enum_exception.exception.custom;

// 로그인 검증을 수행하는 클래스
public class LoginUser {

    private String account;
    private String password;

    public LoginUser(String account, String password) {
        this.account = account;
        this.password = password;
    }

    // 로그인 검증 기능
    public String authenticate(String inputAccount, String inputPassword)
            throws LoginInvalidException {

        // 문자열 값을 비교할 때는 equals() 메서드를 사용해야 합니다.
        if (!this.account.equals(inputAccount)) {
            throw new LoginInvalidException("회원 가입이 되지 않은 계정입니다.", inputAccount);
        }

        if (!this.password.equals(inputPassword)) {
            throw new LoginInvalidException("비밀번호가 틀렸습니다.", inputAccount);
        }

        System.out.println("로그인에 성공하셨습니다.");
        return "로그인 성공!";
    }
}