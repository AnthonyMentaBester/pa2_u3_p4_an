package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.EstudianteService;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;
import com.example.demo.service.MateriaService;
import com.example.demo.service.MatriculaService;

@SpringBootApplication
public class Pa2U3P4AnApplication implements CommandLineRunner{

	@Autowired
	private EstudianteService estudianteService;
	
	@Autowired
	private MateriaService materiaService;

	@Autowired
	private MatriculaService matriculaService;
	
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
		/*CuentaBancaria ctaOrigen = new CuentaBancaria();
		ctaOrigen.setNumero("1");
		ctaOrigen.setSaldo(new BigDecimal(100));
		ctaOrigen.setTipo("A");
		this.bancariaService.agregar(ctaOrigen);
		
		CuentaBancaria ctaDestino = new CuentaBancaria();
		ctaDestino.setNumero("2");
		ctaDestino.setSaldo(new BigDecimal(200));
		ctaDestino.setTipo("C");
		this.bancariaService.agregar(ctaDestino);*/
	
		this.transferenciaService.realizarTransferencia("2", "1", new BigDecimal(190));
	}

	

}
