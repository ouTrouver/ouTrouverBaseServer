package ouacheter.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Arrays;

@SpringBootApplication
public class OuacheterApplication {

	public static void main(String[] args) {
		SpringApplication.run(OuacheterApplication.class, args);
	}


	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	@Bean
	public JavaMailSender javaMailSender() {
		return new JavaMailSender() {
			@Override
			public void send(SimpleMailMessage simpleMessage) throws MailException {

			}

			@Override
			public void send(SimpleMailMessage... simpleMessages) throws MailException {

			}

			@Override
			public MimeMessage createMimeMessage() {
				return null;
			}

			@Override
			public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
				return null;
			}

			@Override
			public void send(MimeMessage mimeMessage) throws MailException {

			}

			@Override
			public void send(MimeMessage... mimeMessages) throws MailException {

			}

			@Override
			public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {

			}

			@Override
			public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {

			}
		};
	}
}
