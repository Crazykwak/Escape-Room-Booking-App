package com.crazykwak.roombooking.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

@Data
@NoArgsConstructor
@Slf4j
public class LoginDTO {
    private String id;
    private String pwd;
    private String encPwd;

    public LoginDTO(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
        this.encPwd = encPwd(pwd);
    }

    /**
     * 평문 비밀번호를 암호화 된 비밀번호로 변경.
     * @param pwd 평문 비밀번호.
     * @return 암호화 된 비밀번호.
     * @throws Exception
     */
    private String encPwd(String pwd) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pwd.getBytes());
            byte[] bt = md.digest();
            StringBuilder encPwd = new StringBuilder();
            for (byte b : bt) {
                encPwd.append(String.format("%02x", b));
            }
            result = encPwd.toString();
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        return result;
    }
}
