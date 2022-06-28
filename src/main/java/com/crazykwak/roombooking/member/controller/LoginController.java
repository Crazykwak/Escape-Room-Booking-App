package com.crazykwak.roombooking.member.controller;

import com.crazykwak.roombooking.member.domain.LoginForm;
import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String loginMember(@Validated @ModelAttribute LoginForm form,
                              BindingResult bindingResult,
                              @RequestParam(defaultValue = "/") String redirectURL,
                              HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            log.info("로그인 실패! 검증! = {}" + bindingResult.toString());
            return "/login/loginForm";
        }

        log.info("form = {}", form.getLoginId());
        log.info("form = {}", form.getPassword());

        Member loginMem = loginService.login(form.getLoginId(), form.getPassword());

        if (loginMem == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            log.info("비밀번호 안맞아!! = {}");
            return "/login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute("LOGIN", loginMem);
        log.info("로그인 성공! = {}", loginMem.getUserId());

        return "redirect:" + redirectURL;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

}
