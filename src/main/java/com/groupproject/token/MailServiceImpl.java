package com.groupproject.token;

import com.groupproject.user.User;
import com.groupproject.user.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class MailServiceImpl {

    private JavaMailSender javaMailSender;
    private UserFacade userFacade;

    @Autowired
    public MailServiceImpl(JavaMailSender javaMailSender, UserFacade userFacade) {
        this.javaMailSender = javaMailSender;
        this.userFacade = userFacade;
    }

    public void sendNotification(String login, String token) throws MailException {
        User user = userFacade.getUserByLogin(login);
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("squashleaguejava@gmail.com");
        mail.setSubject("Welcome to Squash League");
        mail.setText("Hello" + user.getLogin()
                + ".\n To reset your password please visit link below " +
                "localhost:8080/passwords/reset/" + token
                + "\n Thank you so much for using SquashLeagueApp, we wish you nothing but success!");
        javaMailSender.send(mail);
    }
}
