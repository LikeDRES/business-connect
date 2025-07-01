package com.andrestapias.businessconnect.business_connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusinessConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessConnectApplication.class, args);

		// Mensaje personalizado cuando la aplicación está lista
		System.out.println("\n====================================");
		System.out.println("¡La aplicación está corriendo! 🚀");
		System.out.println("Local: http://localhost:8080");
		System.out.println("====================================\n");
	}
}
