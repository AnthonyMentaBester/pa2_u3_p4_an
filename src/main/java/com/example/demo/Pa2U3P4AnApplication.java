package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
//esto me permite habilitar el rpoceso asincronamente 
@EnableAsync
public class Pa2U3P4AnApplication implements CommandLineRunner {

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
		/*
		 * //ASINCRONO FUTURE SIN RESPUESTA //nombre del hilo con el que se ejecuta mi
		 * programa LOG.info("HILO: " + Thread.currentThread().getName());
		 * 
		 * //inicio long tiempoInicial = System.currentTimeMillis();
		 * List<CuentaBancaria> lista = new ArrayList<>(); for(int i =0; i<=10; i++) {
		 * CuentaBancaria ctaOrigen = new CuentaBancaria();
		 * ctaOrigen.setNumero(String.valueOf(i)); ctaOrigen.setSaldo(new
		 * BigDecimal(100)); ctaOrigen.setTipo("A"); lista.add(ctaOrigen);
		 * this.bancariaService.agrearAsincrono(ctaOrigen); }
		 * 
		 * //final long tiempoFinal = System.currentTimeMillis(); long
		 * tiempoTotal=(tiempoFinal-tiempoInicial)/1000;
		 * LOG.info("Tiempo transcurrido: " + (tiempoFinal-tiempoInicial));
		 * LOG.info("Tiempo transcurrido: " + tiempoTotal);
		 * LOG.info("Se termino de procesar todo todo: ");
		 */

		// ASINCRONO FUTURE CON RESPUESTA
		LOG.info("HILO: " + Thread.currentThread().getName());

		// inicio
		long tiempoInicial = System.currentTimeMillis();
		List<CompletableFuture<String>> listaRespuesta = new ArrayList<>();
		List<CuentaBancaria> lista = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			CuentaBancaria ctaOrigen = new CuentaBancaria();
			ctaOrigen.setNumero(String.valueOf(i));
			ctaOrigen.setSaldo(new BigDecimal(100));
			ctaOrigen.setTipo("A");
			lista.add(ctaOrigen);

			// LO QUE DEBO HACER AL METODO ASINCRONO QUE DEBO SABER UNA RESPUESTA
			// LO DEBO CAPTURAR EN UN FUTURE DE TIPO STRING
			// en un futuro debo decirle dame las respuesta de todo
			// tengo una promesa de respuesta
			CompletableFuture<String> respuesta = this.bancariaService.agrearAsincrono2(ctaOrigen);
			listaRespuesta.add(respuesta);

		}
		// sentencia que espera termine de procesarse todos los hilos para obtener la
		// respuesta
		CompletableFuture.allOf(listaRespuesta.get(0), listaRespuesta.get(1), listaRespuesta.get(2),
				listaRespuesta.get(3), listaRespuesta.get(4), listaRespuesta.get(5), listaRespuesta.get(6),
				listaRespuesta.get(7), listaRespuesta.get(8), listaRespuesta.get(9));

		LOG.info("Respuesta 0: " + listaRespuesta.get(0).get());
		
		// final
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTotal = (tiempoFinal - tiempoInicial) / 1000;
		LOG.info("Tiempo transcurrido: " + (tiempoFinal - tiempoInicial));
		LOG.info("Tiempo transcurrido: " + tiempoTotal);
		LOG.info("Se termino de procesar todo todo: ");
	}

}
