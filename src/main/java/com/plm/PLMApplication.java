package com.plm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.plm.config.FileStorageConfig;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

 
@SpringBootApplication
@EntityScan(basePackageClasses = { PLMApplication.class, Jsr310JpaConverters.class })
public class PLMApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PLMApplication.class, args);
	}
}
