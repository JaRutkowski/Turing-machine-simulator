package com.javafee.tms.spring.config;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppJavaConfig {

	@Bean(name = "stringPrintWriter")
	@Scope("prototype")
	public PrintWriter printWriter() {
		return new PrintWriter(new StringWriter());
	}

}
