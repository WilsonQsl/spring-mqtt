package com.sun.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author qiansl
 * @version 1.0
 * @date 2023/8/29 21:15
 * @description
 */
@SpringBootApplication
public class MqttApplication {
	public static void main(String [] args) {
		SpringApplication.run(MqttApplication.class, args);
	}
}