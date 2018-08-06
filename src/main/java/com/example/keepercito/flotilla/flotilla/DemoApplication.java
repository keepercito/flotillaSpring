package com.example.keepercito.flotilla.flotilla;

import com.example.keepercito.flotilla.flotilla.Services.TipoVehiculoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public TipoVehiculoService tipoVehiculoService(){
		return new TipoVehiculoService();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
