package ouacheter.backend.controllers;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
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
import ouacheter.backend.services.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/auth")
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService UserService;

    @PostMapping("/forgot_password")
    public ResponseEntity<User> processForgotPassword(@RequestBody User email) {

        System.out.print("email : azeaze" + email);
        String token = RandomString.make(30);

        try {
            UserService.updateResetPasswordToken(token, email.getEmail());
            String resetPasswordLink = "localhost:4200" + "/reset_password?token=" + token;
            sendEmail(email.getEmail(), resetPasswordLink);

        } catch (UserNotFoundException ex) {
            System.out.println("Utilisateur introuvable");
        } catch (UnsupportedEncodingException | MessagingException e) {
            System.out.println("L'email ne s'est pas bien envoyé");
        }
        return new ResponseEntity<>(email, HttpStatus.OK);

    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("OuAcheter.fr", "Shopme Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
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
class Utility {
    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
}