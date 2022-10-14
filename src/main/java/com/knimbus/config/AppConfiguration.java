package com.knimbus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfiguration {

		
		// Password Encoder configuration bean
		@Bean
		public PasswordEncoder passwordencoder() {
			
			return new BCryptPasswordEncoder();
			
		}
}
