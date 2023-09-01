package com.sun.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author wilson
 */
@SpringBootApplication
public class MqttApplication {
	public static void main(String [] args) {
		SpringApplication.run(MqttApplication.class, args);
	}
}