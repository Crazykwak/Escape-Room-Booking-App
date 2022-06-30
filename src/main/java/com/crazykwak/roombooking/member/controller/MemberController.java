package com.crazykwak.roombooking.member.controller;

import com.crazykwak.roombooking.member.domain.LoginForm;
import com.crazykwak.roombooking.member.domain.Member;
import com.crazykwak.roombooking.member.dto.LoginDTO;
import com.crazykwak.roombooking.member.service.MemberService;
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
public class MemberController {

    @Autowired
    MemberService memberService;

    @PostMapping("/login")
    public String loginMember(@Validated @ModelAttribute LoginForm form,
                              BindingResult bindingResult,
                              @RequestParam(defaultValue = "/") String redirectURL,
                              HttpServletRequest request,
                              HttpSession session) {

        LoginDTO dto = new LoginDTO(form.getLoginId(), form.getPassword());
        Member loginMem = memberService.login(dto);

        if (loginMem == null) {
            bindingResult.reject("LOGIN_FAIL", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "/login/loginForm";
        }

        if (session.getAttribute("LOGIN") != null) {
            session.removeAttribute("LOGIN");
        }
        session.setAttribute("LOGIN", loginMem);

        return "redirect:" + redirectURL;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") LoginForm form) {
        return "login/loginForm";
    }

}
