package com.eventoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // realiza a configuração, varredura de componentes e definem configuraçoes da classe de aplicativo.
public class EventoappApplication {

	// http://localhost:8080
	// http://localhost:8080/cadastrarEvento
	// http://localhost:8080/eventos

	public static void main(String[] args) {
		SpringApplication.run(EventoappApplication.class, args);
	}

}
