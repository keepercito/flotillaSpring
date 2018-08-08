package com.example.keepercito.flotilla.flotilla;

import com.example.keepercito.flotilla.flotilla.Services.MarcaService;
import com.example.keepercito.flotilla.flotilla.Services.TipoMantenimientoService;
import com.example.keepercito.flotilla.flotilla.Services.TipoVehiculoService;
import com.example.keepercito.flotilla.flotilla.Services.UnidadService;
import com.example.keepercito.flotilla.flotilla.Services.VehiculoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public TipoVehiculoService tipoVehiculoService(){
		return new TipoVehiculoService();
	}

	@Bean
	public TipoMantenimientoService tipoMantenimientoService(){
		return new TipoMantenimientoService();
	}
	
	@Bean
	public MarcaService marcaService(){
		return new MarcaService();
	}
	
	@Bean
	public UnidadService unidadService(){
		return new UnidadService();
	}
	
	@Bean
	public VehiculoService vehiculoService(){
		return new VehiculoService();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
