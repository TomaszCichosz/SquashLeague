package com.groupproject.token;

import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passwords")
class TokenController {

    private TokenService tokenService;
    private MailServiceImpl mailService;
    private UserFacade userFacade;

    @Autowired
    public TokenController(TokenService tokenService, MailServiceImpl mailService, UserFacade userFacade) {
        this.tokenService = tokenService;
        this.mailService = mailService;
        this.userFacade = userFacade;
    }

    @GetMapping("/mail")
    public String generateNewToken(Model model) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        String token = tokenService.createToken(login);
        try {
            mailService.sendNotification(login, token);
        } catch (MailException e) {
            e.printStackTrace();
        }
        model.addAttribute("msg", "We sent you link to reset password. Check your mailbox.");
        return "home";
    }

    @GetMapping("/reset/{uuid}")
    public String getResetPasswordView(@PathVariable String uuid, Model model) {
//        Token token = tokenService.findTokenByUuid(uuid);
//        String tokenUuid=token.getToken();
        model.addAttribute("token", uuid);
        model.addAttribute("dto", new ResetPasswordDto());

        return "reset-password";
    }

    @GetMapping("/reset/new/{uuid}")
    public String resetPassword(@PathVariable String uuid, @ModelAttribute ResetPasswordDto dto, Model model) {
        if (!dto.getPassword().equals(dto.getRepeatPassword()) || !uuid.equals(dto.getToken()) || tokenService.checkIsTokenExpired(uuid)) {
            model.addAttribute("token", dto.getToken());
            model.addAttribute("dto", new ResetPasswordDto());
            model.addAttribute("error", "Passwords aren't equal or link has already expired");
            return "reset-password";
        }
        tokenService.resetPassword(dto.getToken(), dto.getPassword());
        return "index";
    }

    @GetMapping("/reset/view")
    public String getResetPasswordViewForNotLoggedUser() {
        return "reset-view";
    }

    @GetMapping("/check/")
    public String resetPasswordForNotLoggedUser(@RequestParam String login, Model model) {

        if (userFacade.getUserByLogin(login) == null) {
            model.addAttribute("msg", "Sorry, we couldn't find user with this login");
            return "index";
        }
        String token = tokenService.createToken(login);
        try {
            mailService.sendNotification(login, token);
        } catch (MailException e) {
            e.printStackTrace();
        }

        model.addAttribute("msg", "We sent you link to reset password. Check your mailbox.");
        return "index";
    }


}
