package in.ashokit.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
   @Autowired
   private JavaMailSender mailSender;

   public boolean sendEmail(String to, String subject, String body) {
      boolean isSent = false;

      try {
         MimeMessage mimeMessage = this.mailSender.createMimeMessage();
         MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
         helper.setTo(to);
         helper.setSubject(subject);
         helper.setText(body, true);
         this.mailSender.send(mimeMessage);
         isSent = true;
      } catch (Exception var7) {
         var7.printStackTrace();
      }

      return isSent;
   }
}