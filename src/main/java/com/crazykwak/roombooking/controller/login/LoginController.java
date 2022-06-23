package com.crazykwak.roombooking.controller.login;

import com.crazykwak.roombooking.login.LoginForm;
import com.crazykwak.roombooking.login.LoginService;
import com.crazykwak.roombooking.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
public class LoginController {

    LoginService loginService;

    @PostMapping("/login")
    public String loginMember(@Validated @ModelAttribute LoginForm form, BindingResult bindingResult, HttpServletRequest request) {
        if(bindingResult.hasErrors()) {
            log.info("로그인 실패!!! = {}");
            return "home";
        }

        Member login = loginService.login(form.getLoginId(), form.getPassword());
        if(login == null) {
        bindingResult.reject("loginFail");
        log.info("로그인 실패! = {}");

            return "home";
        }

        HttpSession session = request.getSession();
        session.setAttribute("LOGIN_MEMBER", login);
        log.info("로그인 성공! = {}", login.getUserId());

        return "home";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

}
