package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U3P4AnApplication implements CommandLineRunner{

	private static final Logger LOG = LoggerFactory.getLogger(Pa2U3P4AnApplication.class);

	
	@Autowired
	private ITransferenciaService transferenciaService;

	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private IPropietarioService iPropietarioService;
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//nombre del hilo con el que se ejecuta mi programa
		LOG.info("HILO: " + Thread.currentThread().getName());
		


		/*
		 //programacion tradicional
		//para medir tomo tiempo inicioo y final
		//inicio
		long tiempoInicial = System.currentTimeMillis();
		for(int i =0; i<=30; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			this.bancariaService.agregar(ctaOrigen);
		}
		//final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal=(tiempoFinal-tiempoInicial)/1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal-tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTotal);
		*/
		/*
		//inicio
				long tiempoInicial = System.currentTimeMillis();
				List<CuentaBancaria> lista = new ArrayList<>();
				for(int i =0; i<=100; i++) {
					CuentaBancaria ctaOrigen = new CuentaBancaria();
					ctaOrigen.setNumero(String.valueOf(i));
					ctaOrigen.setSaldo(new BigDecimal(100));
					ctaOrigen.setTipo("A");
					lista.add(ctaOrigen);
				}
				//esto es igual
				//lista.stream().forEach(cta -> this.bancariaService.agregar(cta));
				//ahora en lugar de aplicar stream llamamos al paralelstream
				//lista.parallelStream().forEach(cta -> this.bancariaService.agregar(cta));
				lista.parallelStream().forEach(cta -> this.bancariaService.agregar2(cta));
				//final
				long tiempoFinal = System.currentTimeMillis();
				long tiempoTotal=(tiempoFinal-tiempoInicial)/1000;
				LOG.info("Tiempo transcurrido: " + (tiempoFinal-tiempoInicial));
				LOG.info("Tiempo transcurrido: " + tiempoTotal);
				*/
		
				//inicio
				long tiempoInicial = System.currentTimeMillis();
				List<CuentaBancaria> lista = new ArrayList<>();
				for(int i =0; i<=100; i++) {
					CuentaBancaria ctaOrigen = new CuentaBancaria();
					ctaOrigen.setNumero(String.valueOf(i));
					ctaOrigen.setSaldo(new BigDecimal(100));
					ctaOrigen.setTipo("A");
					lista.add(ctaOrigen);
				}
				
				//esto es igual
				//lista.stream().forEach(cta -> this.bancariaService.agregar(cta));
				//ahora en lugar de aplicar stream llamamos al paralelstream
				Stream<String> listaFinal = lista.parallelStream().map(cta -> this.bancariaService.agregar2(cta));
				LOG.info("Se guardaron las siguientes cuentas:");
				listaFinal.forEach(cadena -> LOG.info(cadena));
				//final
				long tiempoFinal = System.currentTimeMillis();
				long tiempoTotal=(tiempoFinal-tiempoInicial)/1000;
				LOG.info("Tiempo transcurrido: " + (tiempoFinal-tiempoInicial));
				LOG.info("Tiempo transcurrido: " + tiempoTotal);
				
				
	}

	

}
