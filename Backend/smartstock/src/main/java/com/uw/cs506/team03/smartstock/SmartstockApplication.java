package com.uw.cs506.team03.smartstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the main class for the Smartstock application
 */
@SpringBootApplication
public class SmartstockApplication {

	/**
	 * This is the default constructor for the SmartstockApplication class
	 */
	public SmartstockApplication() {
		
	}

	/**
	 * This is the main method for the Smartstock application
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SmartstockApplication.class, args);
	}

}
