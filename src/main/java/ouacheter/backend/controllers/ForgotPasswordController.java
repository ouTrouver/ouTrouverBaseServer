package ouacheter.backend.controllers;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ouacheter.backend.entities.User;
import ouacheter.backend.exceptions.UserNotFoundException;
import ouacheter.backend.services.EmailServiceImpl;
import ouacheter.backend.services.UserService;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

@Controller
@RequestMapping("/auth")
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService UserService;

    @Autowired
    private EmailServiceImpl emailService;

    @PostMapping("/forgot_password")
    // @EventListener(ApplicationReadyEvent.class)
    public ResponseEntity<User> processForgotPassword(@RequestBody User email) {



        String email1 = email.getEmail();
        System.out.print("email :" + email1);
        String token = RandomString.make(30);

        try {
            UserService.updateResetPasswordToken(token, email1);
            String resetPasswordLink = "localhost:4200" + "/reset_password?token=" + token;
           // emailService.send(email1, "Reinitialization mot de passe",resetPasswordLink );
            emailService.send(email1, "Reinitialization mot de passe","bro you suck" );


        } catch (UserNotFoundException ex) {
            System.out.println("Utilisateur introuvable");
            return new ResponseEntity<>(email, HttpStatus.OK);

        }
        return new ResponseEntity<>(email, HttpStatus.OK);

    }





    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User customer = UserService.getByResetPasswordToken(token);
        model.addAttribute("token", token);

        if (customer == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }

        return "reset_password_form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(String token,String password) {

        User customer = UserService.getByResetPasswordToken(token);


        if (customer == null) {
            return "You couldn't change your password.";
        } else {
            UserService.updatePassword(customer, password);

            return "You have successfully changed your password.";
        }


    }
}


